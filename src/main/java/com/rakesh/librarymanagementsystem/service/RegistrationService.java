package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.RegistrationDao;
import com.rakesh.librarymanagementsystem.domain.User;
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
    
    public String register(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        String registrationId = UUID.randomUUID().toString();
        
        User user = new User();
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setRegistrationId(registrationId);
        user.setEmailAddress(userDto.getEmailAddress());
        
        registrationDao.save(user);
        
        return registrationId;
    }
}
