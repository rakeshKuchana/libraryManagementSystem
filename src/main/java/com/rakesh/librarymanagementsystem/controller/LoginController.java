package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
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
        HttpSession session = request.getSession();
        String targetURI;
        
        try
        {
            User user = loginService.validateUser(userDto);
            
            if (user != null)
            {
                session.setAttribute(AppConstants.SESSION_USER, user);
                targetURI = (String)session.getAttribute(AppConstants.TARGET_URI);
               
               
                if (targetURI == null)
                {
                    targetURI = AppConstants.HOME_URI;
                }  
                
            }
            else
            {
                session.setAttribute("ErrorMsg", "Invalid Credentials");
                targetURI = AppConstants.LOGIN_URI;
                
            }
            
            response.sendRedirect(targetURI);
            
        }
        catch(SQLException se)
        {
            
        }
        catch(Exception e)
        {
            
        }
        
    }
}
