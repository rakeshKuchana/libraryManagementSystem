package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class UserController extends HttpServlet
{
    
    private UserService userService;
    Logger logger;
    
    @Override
    public void init()
    {
        userService = new UserService();
        logger = Logger.getLogger(UserController.class);
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter("username"));
        
        List<User> list = null;
        
        if (request.getParameter("action").equals("search"))
        {
            try
            {
                list = userService.searchById(userDto);
            }
            catch(SQLException e)
            {
               logger.error(e);
            }
            
            if (list != null)
            {
                request.setAttribute("userList", list);
                
            }
            else
            {
                request.setAttribute("errMsg", "No results found");
            }
            
            request.getRequestDispatcher("/home").forward(request, response);
        }
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter("userId"));
        
        if (request.getParameter("action").equals("delete"))
        {
            try
            {
                userService.delete(userDto);
                PrintWriter out = response.getWriter();
                out.println("<h1>Deleted successfully</h1>");
            }
            catch(SQLException e)
            {
               logger.error(e);
            }
        }
    }
   
}
