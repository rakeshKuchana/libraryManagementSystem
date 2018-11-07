package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.BookDao;
import com.rakesh.librarymanagementsystem.domain.Book;
import com.rakesh.librarymanagementsystem.dto.BookDto;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rakesh Kuchana
 */
public class BookService
{
    private BookDao bookDao;
    
    public BookService()
    {
        bookDao = new BookDao();
    }
    
    
    public List<Book> searchBooksByNameOrAuthor(BookDto bookDto) throws SQLException
    {
        return bookDao.searchBooksByNameOrAuthor(bookDto.getName());
    }
    
    public void returnBook(BookDto bookDto) throws SQLException
    {
        bookDao.deleteFromXref(bookDto.getId());
    }
    
    public void issueBook(BookDto bookDto, String issued_by, String issued_to) throws SQLException
    {
        Book book = new Book();
        
        book.setId(bookDto.getId());
        book.setIssued_to(issued_to);
        book.setIssued_by(issued_by);
        
        bookDao.createXref(book);
    }
}
