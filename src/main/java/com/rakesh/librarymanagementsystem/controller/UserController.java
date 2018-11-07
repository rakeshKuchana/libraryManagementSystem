package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
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
        userDto.setId(request.getParameter(AppConstants.PARAM_USER_NAME));

        List<User> list = null;

        try
        {
            if (request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_SEARCH))
            {

                list = userService.searchByUsername(userDto);

                if (list != null)
                {
                    request.setAttribute(AppConstants.ATTR_USER_LIST, list);

                }
                else
                {
                    request.setAttribute(AppConstants.ATTR_ERROR_MSG, AppConstants.MSG_NO_RESULTS_FOUND);
                }

                request.getRequestDispatcher(AppConstants.URI_RELATIVE_HOME).forward(request, response);
            }
        }
        catch (Exception e)
        {
            logger.error(e);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();
        userDto.setId(request.getParameter(AppConstants.PARAM_USER_ID));

        if (request.getParameter(AppConstants.PARAM_ACTION).equals(AppConstants.PARAM_VALUE_DELETE))
        {
            try
            {
                userService.delete(userDto);
                PrintWriter out = response.getWriter();
                out.println("<h1>Deleted successfully</h1>");
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }
    }

}
