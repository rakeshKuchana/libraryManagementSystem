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
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class LoginController extends HttpServlet
{
    private LoginService loginService;
    private Logger logger;
    
    
    
    @Override
    public void init(ServletConfig config)
    {
        loginService = new LoginService();
        logger = Logger.getLogger(LoginController.class);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter(AppConstants.PARAM_USER_NAME));
        userDto.setPassword(request.getParameter(AppConstants.PARAM_PASSWORD));
        HttpSession session = request.getSession();
        String targetUri;
        
        try
        {
            User user = loginService.validateUser(userDto);
            
            if (user != null)
            {
                session.setAttribute(AppConstants.SESSION_USER, user);
                targetUri = (String)session.getAttribute(AppConstants.ATTR_URI_TARGET);
               
               
                if (targetUri == null)
                {
                    targetUri = AppConstants.URI_HOME;
                }  
                
            }
            else
            {
                session.setAttribute(AppConstants.ATTR_ERROR_MSG, AppConstants.MSG_INVALID_CREDS);
                targetUri = AppConstants.URI_LOGIN;
                
            }
            
            response.sendRedirect(targetUri);
            
        }
        catch(SQLException se)
        {
            logger.error(se);
        }
        catch(Exception e)
        {
            logger.error(e);
        }
        
    }
}
