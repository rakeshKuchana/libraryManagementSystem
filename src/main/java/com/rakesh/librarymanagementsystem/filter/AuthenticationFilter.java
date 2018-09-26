package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationFilter implements Filter
{
    
    private ArrayList<String> excludeURIlist;
    private ArrayList<String> excludePathList;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        excludeURIlist = new ArrayList();
        excludeURIlist.add(AppConstants.LOGIN_URI);
        excludeURIlist.add(AppConstants.LOGIN_CONTROLLER_URI);
        
        excludePathList = new ArrayList();
        excludePathList.add(AppConstants.CSS_PATH);
        excludePathList.add(AppConstants.HTML_PATH);
        excludePathList.add(AppConstants.JS_PATH);
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpSession session = ((HttpServletRequest)request).getSession();
        String URI = ((HttpServletRequest)request).getRequestURI();
        
        if (isExcludedFromFilter(URI) || session.getAttribute(AppConstants.SESSION_USER) != null)
        {
            chain.doFilter(request, response);
        }
        else
        {
            session.setAttribute(AppConstants.TARGET_URI, (((HttpServletRequest)request).getRequestURI()));
            ((HttpServletResponse)response).sendRedirect(AppConstants.LOGIN_URI);
        }
        
    }
    
    @Override
    public void destroy()
    {
        //nothing to destroy
    }
    
    private boolean isExcludedFromFilter(String URI)
    {
        
        for (String path : excludePathList)
        {
            if (URI.startsWith(path))
            {
                return true;
            }
        }
        
        return excludeURIlist.contains(URI);

    }
    
}
