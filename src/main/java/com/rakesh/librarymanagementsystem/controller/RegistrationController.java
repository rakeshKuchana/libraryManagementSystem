package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService;
import com.rakesh.librarymanagementsystem.util.Mail;
import java.io.IOException;
import java.io.PrintWriter;
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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String registrationId = null;

        UserDto userDto = new UserDto();

        userDto.setFirstname(firstName);
        userDto.setLastname(lastName);
        userDto.setEmailAddress(emailAddress);

        try
        {
            registrationId = registrationService.register(userDto);
            String body = "Hello " + firstName + " " + lastName + "\n" + "Please complete your registration using the following link" + "\n"
                    + "http://localhost:8084/libraryManagementSystem/registrationLn?regId=" + registrationId;

            Mail.send(emailAddress, "lms registration", body);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Registered successfully</h1>");
            
        }
        catch (Exception e)
        {
            logger.error(e);
        }

        //EmailService.sendEmail(request.getParameter("email"), "lms registration", "Hello Rakesh");
        //out.println("<h1>Mail sent successfully</h1>");
    }
}
