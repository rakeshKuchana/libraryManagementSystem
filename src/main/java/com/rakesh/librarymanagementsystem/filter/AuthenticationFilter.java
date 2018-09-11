package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationFilter implements Filter
{
    
    public void init(FilterConfig filterConfig) throws ServletException
    {
        //initialize nothing
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));
        
        UserService userService  = new UserService();
        User user = userService.getUserDetails(userDto);
        
        if (userDto.getUsername().equalsIgnoreCase(user.getUsername()) && userDto.getPassword().equals(user.getPassword()))
        {
            //Start session here
            HttpSession session = ((HttpServletRequest)request).getSession();
            session.setAttribute("session_username", user.getUsername());
            session.setAttribute("session_userRole", user.getRole());

            chain.doFilter(request, response);
        }
        else
        {
            request.setAttribute("ErrorMsg", "Invalid Credentials");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }   
    }
    
    public void destroy()
    {
        //nothing to destroy
    }
} 
