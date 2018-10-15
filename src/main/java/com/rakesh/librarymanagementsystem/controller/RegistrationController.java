package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService;
import com.rakesh.librarymanagementsystem.service.EmailService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationController extends HttpServlet
{
    private RegistrationService registrationService;
    Logger logger;
    
    @Override
    public void init(ServletConfig config)
    {
        registrationService = new RegistrationService();
        logger = Logger.getLogger(RegistrationController.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setFirstname(request.getParameter("firstName"));
        userDto.setLastname(request.getParameter("lastName"));
        userDto.setEmailAddress(request.getParameter("email"));
        
        try
        {
            String registrationId = registrationService.register(userDto);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Registered successfully</h1>");
        }
        catch(FileNotFoundException | SQLException e)
        {
            logger.error(e);
        }
        
        
        
        //send email to the librarian to complete registration
        //EmailService.sendEmail(request.getParameter("email"), "lms registration", "Hello Rakesh");
        //out.println("<h1>Mail sent successfully</h1>");
    }
}
