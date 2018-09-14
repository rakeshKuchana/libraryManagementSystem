package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.domain.User;
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
public class AuthorizationFilter implements Filter
{
    public void init(FilterConfig config)
    {
        //nothing to initialize
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        
        if (session == null || (session != null && ((User)session.getAttribute("session_user")).getRole() == null))
        {
            request.getRequestDispatcher("/jsp/notAuthorized.jsp").forward(request, response);
        }
        else
        {
            chain.doFilter(request, response);
        }
        
    }
    
    public void destroy()
    {
        //nothing to destroy
    }
}
