package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService2;
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
public class RegistrationController2 extends HttpServlet
{
    RegistrationService2 registrationService;
    
    public void init(ServletConfig config)
    {
        registrationService = new RegistrationService2();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        
        userDto.setId(request.getParameter("userId"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setFirstname(request.getParameter("firstName"));
        userDto.setLastname(request.getParameter("lastName"));
        userDto.setEmailAddress(request.getParameter("emailId"));
        userDto.setGender(request.getParameter("gender"));
        userDto.setDateOfBirth(request.getParameter("dateOfBirth"));
        userDto.setRole("librarian");
        
        try
        {
            registrationService.register(userDto);
        }
        catch(Exception e)
        {
        }
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>Registered successfully</h1>");
        

    }
}
