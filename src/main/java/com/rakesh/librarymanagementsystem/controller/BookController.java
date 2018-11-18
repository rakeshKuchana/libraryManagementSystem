package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.domain.Book;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.BookDto;
import com.rakesh.librarymanagementsystem.service.BookService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class BookController extends HttpServlet
{

    private BookService bookService;
    private Logger logger;

    @Override
    public void init()
    {
        bookService = new BookService();
        logger = Logger.getLogger(BookController.class);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        BookDto bookDto = new BookDto();

        if (request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_SEARCH))
        {

            bookDto.setName(request.getParameter(AppConstants.PARAM_NAME));

            try
            {
                List booksList = bookService.searchBooksByNameOrAuthor(bookDto);

                if (booksList != null)
                {
                    request.setAttribute(AppConstants.ATTR_BOOKS_LIST, booksList);
                }
                else
                {
                    request.setAttribute(AppConstants.ATTR_ERROR_MSG, AppConstants.MSG_NO_RESULTS_FOUND);
                }

                request.getRequestDispatcher(AppConstants.URI_RELATIVE_HOME).forward(request, response);
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        BookDto bookDto = new BookDto();
        
        if (request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_RETURN))
        {
            bookDto.setId(request.getParameter(AppConstants.PARAM_ID));

            try
            {
                bookService.returnBook(bookDto);

                PrintWriter out = response.getWriter();
                out.println("<h1>Returned successfully</h1>");
            }
            catch (Exception e)
            {
                logger.error(e);
            }

        }
        else if(request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_ISSUE))
        {
            Book book = new Book();
            book.setId(request.getParameter(AppConstants.PARAM_ID));
            book.setAuthor(request.getParameter(AppConstants.PARAM_AUTHOR));
            book.setName(request.getParameter(AppConstants.PARAM_NAME));
            
            request.setAttribute(AppConstants.ATTR_BOOK, book);
            request.getRequestDispatcher(AppConstants.URI_RELATIVE_ISSUE).forward(request, response);
        }
        else if(request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_ISSUE_BOOK))
        {
            HttpSession session = request.getSession(AppConstants.BOOLEAN_FALSE);
            
            User user = (User)session.getAttribute(AppConstants.SESSION_USER);
            
            String issuedBy = user.getUserId();
            bookDto.setId(request.getParameter(AppConstants.PARAM_ID));
            
            try
            {
                bookService.issueBook(bookDto, issuedBy, request.getParameter(AppConstants.PARAM_STUDENT_ID));
                
                PrintWriter out = response.getWriter();
                out.println("<h1>Issued successfully</h1>");
            }
            catch(Exception e)
            {
                logger.error(e);
            }
            
        }

    }
}
