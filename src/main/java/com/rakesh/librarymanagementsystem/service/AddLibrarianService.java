package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.AddLibrarianDao;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author Rakesh Kuchana
 */
public class AddLibrarianService
{
    public String addLibrarian(UserDto userDto)
    {
        String registrationId = RandomStringUtils.randomAlphabetic(30);
        userDto.setRegistrationId(registrationId);
        
        AddLibrarianDao addLibrarianDao = new AddLibrarianDao();
        addLibrarianDao.addLibrarian(userDto);
        
        return registrationId;
    }
}
