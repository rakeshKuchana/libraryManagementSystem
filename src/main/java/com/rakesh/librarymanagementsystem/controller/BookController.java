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

        if (request.getParameter("action").equals("search"))
        {

            bookDto.setName(request.getParameter("name"));

            try
            {
                List list = bookService.searchBooksByNameOrAuthor(bookDto);

                if (list != null)
                {
                    request.setAttribute("booksList", list);
                }
                else
                {
                    request.setAttribute("errMsg", "No results found");
                }

                request.getRequestDispatcher("/home").forward(request, response);
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }
        else if (request.getParameter("action").equals("return"))
        {
            bookDto.setId(request.getParameter("id"));

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

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        BookDto bookDto = new BookDto();
        if (request.getParameter("action").equals("return"))
        {
            bookDto.setId(request.getParameter("id"));

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
        else if(request.getParameter("action").equals("issue"))
        {
            Book book = new Book();
            book.setId(request.getParameter("id"));
            book.setAuthor(request.getParameter("author"));
            book.setName(request.getParameter("name"));
            
            request.setAttribute("book", book);
            request.getRequestDispatcher("/issue").forward(request, response);
        }
        else if(request.getParameter("action").equals("issueBook"))
        {
            HttpSession session = request.getSession(false);
            
            User user = (User)session.getAttribute(AppConstants.SESSION_USER);
            
            String issuedBy = user.getUserId();
            bookDto.setId(request.getParameter("id"));
            
            try
            {
                bookService.issueBook(bookDto, issuedBy, request.getParameter("studentId"));
                
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
