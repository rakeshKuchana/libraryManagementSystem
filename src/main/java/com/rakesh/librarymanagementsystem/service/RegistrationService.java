package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.RegistrationDao;
import com.rakesh.librarymanagementsystem.dto.UserDto;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationService
{
    public String getRegisteredEmailId(UserDto userDto)
    {
        RegistrationDao registrationDao = new RegistrationDao();
        return registrationDao.getRegisteredEmailId(userDto);
    }
    
    public void register(UserDto userDto)
    {
        RegistrationDao registrationDao = new RegistrationDao();
        registrationDao.register(userDto);
    }
}
