package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationCompleteController extends HttpServlet
{

    private UserService userService;
    private Logger logger;

    @Override
    public void init()
    {
        userService = new UserService();
        logger = Logger.getLogger(RegistrationCompleteController.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto userDto = new UserDto();

        userDto.setFirstName(request.getParameter(AppConstants.PARAM_FIRST_NAME));
        userDto.setLastName(request.getParameter(AppConstants.PARAM_LAST_NAME));
        userDto.setEmailAddress(request.getParameter(AppConstants.PARAM_EMAIL_ADDRESS));
        userDto.setGender(request.getParameter(AppConstants.PARAM_GENDER));
        userDto.setDay(request.getParameter(AppConstants.PARAM_DAY));
        userDto.setMonth(request.getParameter(AppConstants.PARAM_MONTH));
        userDto.setYear(request.getParameter(AppConstants.PARAM_YEAR));
        userDto.setUserId(request.getParameter(AppConstants.PARAM_USER_ID));
        userDto.setPassword(request.getParameter(AppConstants.PARAM_NEW_PASSWORD));
        userDto.setRole(AppConstants.ROLE_LIBRARIAN);

        try
        {
            if (!userService.isUserIdAlreadyUsed(userDto))
            {
                userService.create(userDto);
                PrintWriter out = response.getWriter();
                out.println("<h1>Registered successfully</h1>");
            }
            else
            {
                request.setAttribute(AppConstants.ATTR_USER, userDto);
                request.setAttribute(AppConstants.ATTR_REGISTRATION_RESPONSE, AppConstants.MSG_ALREADY_USED_USER_ID);
                request.getRequestDispatcher(AppConstants.JSP_REGISTRATION_COMPLETE).forward(request, response);
            }

        }
        catch (Exception e)
        {
            logger.error(e);
        }
    }
}
