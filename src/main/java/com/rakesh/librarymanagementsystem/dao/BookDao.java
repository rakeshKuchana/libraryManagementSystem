package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.constant.DBConstants;
import com.rakesh.librarymanagementsystem.domain.Book;
import com.rakesh.librarymanagementsystem.util.ConnectionFactory;
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

    public List searchBooksByNameOrAuthor(String name)
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
                    book.setId(rs.getString(DBConstants.COLUMN_ID));
                    book.setName(rs.getString(DBConstants.COLUMN_NAME));
                    book.setAuthor(rs.getString(DBConstants.COLUMN_AUTHOR));
                    book.setStatus(rs.getString(DBConstants.COLUMN_STATUS));
                    book.setIssued_to(rs.getString(DBConstants.COLUMN_ISSUED_TO));
                    book.setIssue_date(rs.getString(DBConstants.COLUMN_ISSUE_DATE));
                    book.setExpected_return_date(rs.getString(DBConstants.COLUMN_EXPECTED_RETURN_DATE));
                    book.setIssued_by(rs.getString(DBConstants.COLUMN_ISSUED_BY));
                    
                    list.add(book);
                }
            }
            
            return list;

        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteFromXref(String id)
    {
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("delete from book_student_xref where book_id = ?");
            stmt.setString(1, id);
            
            stmt.executeUpdate();
            
            conn.commit();
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void createXref(Book book)
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
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
