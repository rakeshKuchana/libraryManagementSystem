package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.AddLibrarianService;
import com.rakesh.librarymanagementsystem.service.EmailService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rakesh Kuchana
 */
public class AddLibrarianController extends HttpServlet
{
    private AddLibrarianService addLibrarianService;
    
    public void init(ServletConfig config)
    {
        addLibrarianService = new AddLibrarianService();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setFirstname(request.getParameter("name"));
        userDto.setEmailId(request.getParameter("email"));

        //Add librarian
        String registrationId = addLibrarianService.addLibrarian(userDto);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Added successfully</h1>");
        //send email to the librarian to complete registration
        EmailService.sendEmail(request.getParameter("email"), "lms registration", "Hello Rakesh");
        out.println("<h1>Mail sent successfully</h1>");
    }
}
