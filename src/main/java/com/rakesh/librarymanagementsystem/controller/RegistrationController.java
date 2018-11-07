package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService;
import com.rakesh.librarymanagementsystem.util.Mail;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationController extends HttpServlet
{

    private RegistrationService registrationService;
    Logger logger;

    @Override
    public void init(ServletConfig config)
    {
        registrationService = new RegistrationService();
        logger = Logger.getLogger(RegistrationController.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String firstName = request.getParameter(AppConstants.PARAM_FIRST_NAME);
        String lastName = request.getParameter(AppConstants.PARAM_LAST_NAME);
        String emailAddress = request.getParameter(AppConstants.PARAM_EMAIL_ADDRESS);
        String registrationId;

        UserDto userDto = new UserDto();

        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmailAddress(emailAddress);

        try
        {
            registrationId = registrationService.register(userDto);

            if (registrationId != null)
            {
                String body = "Hello " + firstName + " " + lastName + "\n" + "Please complete your registration using the following link" + "\n"
                        + "http://localhost:8084/libraryManagementSystem/registrationLn?regId=" + registrationId;

                Mail.send(emailAddress, "lms registration", body);

                request.setAttribute(AppConstants.ATTR_REGISTRATION_RESPONSE, AppConstants.MSG_MAIL_SENT);
            }
            else
            {
                request.setAttribute(AppConstants.ATTR_REGISTRATION_RESPONSE, AppConstants.MSG_ALREADY_REGISTERED_EMAIL);
            }
            
            request.getRequestDispatcher("/librarianRegistration").forward(request, response);

        }
        catch (Exception e)
        {
            logger.error(e);
        }

    }
}
