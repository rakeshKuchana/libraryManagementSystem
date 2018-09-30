package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.domain.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Kuchana
 */
public class HomeController extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String targetURI = null;
        HttpSession session = request.getSession(false);
        
        User user = (User)session.getAttribute(AppConstants.SESSION_USER);
        
        if (user.getRole().equals(AppConstants.ROLE_ADMIN))
        {
            targetURI = AppConstants.JSP_ADMIN_HOME;
        }
        else if (user.getRole().equals(AppConstants.ROLE_LIBRARIAN))
        {
            targetURI = AppConstants.JSP_LIBRARIAN_HOME;
        }
        
        request.getRequestDispatcher(targetURI).forward(request, response);
    }
}
