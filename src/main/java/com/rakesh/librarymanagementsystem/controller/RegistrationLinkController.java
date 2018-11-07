package com.rakesh.librarymanagementsystem.controller;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.domain.Registration;
import com.rakesh.librarymanagementsystem.dto.RegistrationDto;
import com.rakesh.librarymanagementsystem.service.RegistrationService;
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
public class RegistrationLinkController extends HttpServlet
{

    private RegistrationService registrationService;
    private Logger logger;

    @Override
    public void init(ServletConfig config)
    {
        registrationService = new RegistrationService();
        logger = Logger.getLogger(RegistrationLinkController.class);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String registrationId = request.getParameter(AppConstants.PARAM_REG_ID);
        String errorMessage = null;

        if (registrationId != null)
        {
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setId(registrationId);

            try
            {
                Registration registration = registrationService.findById(registrationDto);
                if (registration != null)
                {
                    request.setAttribute(AppConstants.ATTR_REGISTRATION, registration);
                    request.getRequestDispatcher(AppConstants.JSP_REGISTRATION_COMPLETE).forward(request, response);
                }
                else
                {
                    errorMessage = AppConstants.MSG_INVALID_REGISTRATION_LINK;
                }
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }
        else
        {
            errorMessage = AppConstants.MSG_INVALID_REGISTRATION_LINK;
        }
        
        if (errorMessage != null)
        {
            PrintWriter out = response.getWriter();
            out.println("<h1>"+errorMessage+"</h1>");
        }

    }
}
