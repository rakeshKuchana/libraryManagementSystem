package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.LoginService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Kuchana
 */
public class LoginController extends HttpServlet
{
    private LoginService loginService;
    
    @Override
    public void init(ServletConfig config)
    {
        loginService = new LoginService();
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));
        
        try
        {
            User user = loginService.validateUser(userDto);
            
            if (user != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("session_user", user);
                String targetURI = request.getParameter("targetURI");
               
                if (targetURI.equals(""))
                {
                    response.sendRedirect("/libraryManagementSystem/jsp/home.jsp");
                }
                else
                {
                    response.sendRedirect(targetURI);
                }
                
            }
            else
            {
                request.setAttribute("ErrorMsg", "Invalid Credentials");
                request.getRequestDispatcher("/login").include(request, response);
            }
            
        }
        catch(SQLException se)
        {
            
        }
        catch(Exception e)
        {
            
        }
        
    }
}
