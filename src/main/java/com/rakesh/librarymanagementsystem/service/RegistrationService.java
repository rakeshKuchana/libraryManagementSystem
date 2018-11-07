package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.RegistrationDao;
import com.rakesh.librarymanagementsystem.domain.Registration;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.RegistrationDto;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationService
{

    private final RegistrationDao registrationDao;

    public RegistrationService()
    {
        registrationDao = new RegistrationDao();
    }

    /**
     * Registers a new librarian and returns the registration ID
     * @param userDto
     * @return String - returns registration ID
     */
    public String register(UserDto userDto)
    {
        String registrationId= null;
        UserService userService = new UserService();

        if (!userService.isAlreadyRegistered(userDto))
        {
            registrationId = UUID.randomUUID().toString();

            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setRegistrationId(registrationId);
            user.setEmailAddress(userDto.getEmailAddress());

            registrationDao.create(user);
        }

        return registrationId;
    }

    public Registration findById(RegistrationDto registrationDto) throws FileNotFoundException, IOException, SQLException
    {
        Registration registration = registrationDao.findById(registrationDto.getId());
        return registration;
    }
}
