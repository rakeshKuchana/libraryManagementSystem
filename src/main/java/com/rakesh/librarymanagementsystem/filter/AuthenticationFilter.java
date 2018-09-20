package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.exception.AuthenticationException;
import com.rakesh.librarymanagementsystem.service.AuthenticationService;
import java.io.IOException;
import java.sql.SQLException;
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
        
        userDto.setId(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));
        
        User user = null;
        
        try
        {
            user = authenticationService.authenticate(userDto);
            HttpSession session = ((HttpServletRequest)request).getSession(true);
            session.setAttribute("session_user", user);
            
            chain.doFilter(request, response);
        }
        catch(AuthenticationException ae)
        {
            request.setAttribute("ErrorMsg", ae);
            request.getRequestDispatcher("/").forward(request, response);
        }
        catch(SQLException e)
        {
            
        }
    
         
    }
    
    public void destroy()
    {
        //nothing to destroy
    }
}
