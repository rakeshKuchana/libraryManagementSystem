package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.domain.Book;
import com.rakesh.librarymanagementsystem.util.ConnectionFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rakesh Kuchana
 */
public class BookDao
{

    public List searchBooksByNameOrAuthor(String name) throws SQLException
    {
        List<Book> list = null;

        try (Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select * from system.books_v where (name like ? or author like ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                list = new ArrayList();
                rs.beforeFirst();

                while (rs.next())
                {
                    Book book = new Book();
                    book.setId(rs.getString("id"));
                    book.setName(rs.getString("name"));
                    book.setAuthor(rs.getString("author"));
                    book.setStatus(rs.getString("status"));
                    book.setIssued_to(rs.getString("issued_to"));
                    book.setIssue_date(rs.getString("issue_date"));
                    book.setExpected_return_date(rs.getString("expected_return_date"));
                    book.setIssued_by(rs.getString("issued_by"));
                    
                    list.add(book);
                }
            }
            
            return list;

        }
    }
    
    public void deleteFromXref(String id) throws SQLException
    {
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("delete from book_student_xref where book_id = ?");
            stmt.setString(1, id);
            
            stmt.executeUpdate();
            
            conn.commit();
        }
    }
    
    public void createXref(Book book) throws SQLException
    {
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("insert into system.book_student_xref (book_id, student_id, issued_by)values (?, ?, ?)");
            
            stmt.setString(1, book.getId());
            stmt.setString(2, book.getIssued_to());
            stmt.setString(3, book.getIssued_by());
            
            stmt.executeUpdate();
            
            conn.commit();
        }
    }
}
