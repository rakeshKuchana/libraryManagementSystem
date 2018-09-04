package com.home.librarymanagementsystem.servlet;

import com.home.librarymanagementsystem.dao.LoginDao;
import com.home.librarymanagementsystem.dto.UserDto;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rakesh Kuchana
 */
public class LoginServlet extends HttpServlet
{
    
    @Override
    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, java.io.IOException
    {   
        UserDto userDto = new UserDto();
        userDto.setUsername(httpServletRequest.getParameter("username"));
        userDto.setPassword(httpServletRequest.getParameter("password"));
        
        LoginDao loginDao = new LoginDao();
        
        if(loginDao.isValidUser(userDto))
        {
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("jsp/success.jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);   
        }        
        else
        {
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        }
        
    }
}
