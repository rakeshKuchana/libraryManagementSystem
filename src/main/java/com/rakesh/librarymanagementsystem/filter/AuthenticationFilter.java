package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.AuthenticationService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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
    
    AuthenticationService authenticationService;
    
    public void init(FilterConfig filterConfig) throws ServletException
    {
        authenticationService  = new AuthenticationService();
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));
        
        User user = authenticationService.authenticate(userDto);
        
        if (user != null)
        {
            HttpSession session = ((HttpServletRequest)request).getSession(true);
            session.setAttribute("session_user", user);
            
            chain.doFilter(request, response);
        }
        else
        {
            request.setAttribute("ErrorMsg", "Invalid Credentials");
            request.getRequestDispatcher("/").forward(request, response);
        }
         
    }
    
    public void destroy()
    {
        //nothing to destroy
    }
}
