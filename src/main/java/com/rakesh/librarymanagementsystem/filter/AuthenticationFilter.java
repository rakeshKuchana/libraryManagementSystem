package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.service.AuthenticationService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationFilter implements Filter
{
    private AuthenticationService authenticationService;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        authenticationService  = new AuthenticationService();
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        
        if (authenticationService.isAuthenticated(request))
        {
            chain.doFilter(request, response);
        }
        else
        {
            String requestURI = (String)(((HttpServletRequest)request).getRequestURI());
            ((HttpServletResponse)response).sendRedirect("/libraryManagementSystem/login?pageId="+URLEncoder.encode(requestURI));
            
        }
        
    }
    
    @Override
    public void destroy()
    {
        //nothing to destroy
    }
}
