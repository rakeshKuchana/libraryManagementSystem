package com.rakesh.librarymanagementsystem.service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationService
{
    
    public boolean isAuthenticated(ServletRequest request)
    {
        
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        
        return session != null && session.getAttribute("session_user") != null;
        
        
    }
}
