package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationCompleteController extends HttpServlet
{
    private UserService userService;
    private Logger logger;
    
    @Override
    public void init()
    {
        userService = new UserService();
        logger = Logger.getLogger(RegistrationCompleteController.class);
    }
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        
        userDto.setFirstname(request.getParameter("firstName"));
        userDto.setLastname(request.getParameter("lastName"));
        userDto.setEmailAddress(request.getParameter("emailAddress"));
        userDto.setGender(request.getParameter("gender"));
        userDto.setDay(request.getParameter("day"));
        userDto.setMonth(request.getParameter("month"));
        userDto.setYear(request.getParameter("year"));
        userDto.setUserId(request.getParameter("userId"));
        userDto.setPassword(request.getParameter("newPassword"));
        userDto.setRole(AppConstants.ROLE_LIBRARIAN);
        
        
        try
        {
            userService.save(userDto);
            PrintWriter out = response.getWriter();
            out.println("<h1>Registered successfully</h1>");
        }
        catch(Exception e)
        {
            logger.error(e);
        }
    }
}
