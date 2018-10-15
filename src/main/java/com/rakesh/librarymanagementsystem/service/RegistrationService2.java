package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.RegistrationDao2;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationService2
{
    public String getRegisteredEmailId(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        RegistrationDao2 registrationDao = new RegistrationDao2();
        return registrationDao.getRegisteredEmailId(userDto);
    }
    
    public void register(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        RegistrationDao2 registrationDao = new RegistrationDao2();
        registrationDao.register(userDto);
    }
}
