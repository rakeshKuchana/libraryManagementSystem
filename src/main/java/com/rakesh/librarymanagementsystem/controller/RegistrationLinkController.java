package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationLinkController extends HttpServlet
{
    
    RegistrationService registrationService;
    
    public void init(ServletConfig config)
    {
        registrationService = new RegistrationService();
    }
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userdto = new UserDto();
        userdto.setRegistrationId(request.getParameter("id"));
        
        String registeredEmailId = registrationService.getRegisteredEmailId(userdto);
        
        request.setAttribute("registeredEmailId", registeredEmailId);
        
        request.getRequestDispatcher("/jsp/librarianRegistration.jsp").forward(request, response);
        
    }
}
