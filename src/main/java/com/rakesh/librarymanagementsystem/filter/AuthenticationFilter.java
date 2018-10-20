package com.rakesh.librarymanagementsystem.filter;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    private List<String> excludeUriList;
    private List<String> excludePathList;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        excludeUriList = new ArrayList();
        excludeUriList.add(AppConstants.URI_LOGIN);
        excludeUriList.add(AppConstants.URI_LOGIN_CONTROLLER);
        excludeUriList.add(AppConstants.URI_REGISTRATION_LINK);
        excludeUriList.add(AppConstants.URI_REGISTRATION_COMPLETE);
        
        excludePathList = new ArrayList();
        excludePathList.add(AppConstants.PATH_CSS);
        excludePathList.add(AppConstants.PATH_HTML);
        excludePathList.add(AppConstants.PATH_JS);
        excludePathList.add(AppConstants.PATH_IMG);
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        
        if (isExcludedFromFilter(uri) || session.getAttribute(AppConstants.SESSION_USER) != null)
        {
            chain.doFilter(request, response);
        }
        else
        {
            session.setAttribute(AppConstants.ATTR_URI_TARGET, req.getRequestURI());
            ((HttpServletResponse)response).sendRedirect(AppConstants.URI_LOGIN);
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
        
        return excludeUriList.contains(URI);

    }
    
}
