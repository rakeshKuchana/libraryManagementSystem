package com.rakesh.librarymanagementsystem.controller;

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
        String registrationId = request.getParameter("regId");
        String errorMessage = null;

        if (registrationId != null)
        {
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setId(request.getParameter("regId"));

            try
            {
                Registration registration = registrationService.findById(registrationDto);
                if (registration != null)
                {
                    request.setAttribute("registration", registration);
                    request.getRequestDispatcher("/WEB-INF/jsp/registrationComplete.jsp").forward(request, response);
                }
                else
                {
                    errorMessage = "Invalid registration link";
                }
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }
        else
        {
            errorMessage = "Invalid registration link";
        }
        
        if (errorMessage != null)
        {
            PrintWriter out = response.getWriter();
            out.println("<h1>"+errorMessage+"</h1>");
        }

    }
}
