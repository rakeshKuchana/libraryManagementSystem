package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rakesh Kuchana
 */
public class UserController extends HttpServlet
{
    
    private UserService userService;
    
    @Override
    public void init()
    {
        userService = new UserService();
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter("username"));
        
        User user = null;
        
        if (request.getParameter("action").equals("search"))
        {
            try
            {
                user = userService.findById(userDto);
            }
            catch(SQLException e)
            {
               
            }
            
            if (user != null)
            {
                request.setAttribute("user", user);
                
            }
            else
            {
                request.setAttribute("errMsg", "No results found");
            }
            
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
    
    @Override
    public void destroy()
    {
        
    }
}
