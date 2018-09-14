package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.AuthenticationDao;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationService
{
    public User authenticate(UserDto userDto)
    {
        AuthenticationDao authenticationDao = new AuthenticationDao();
        User user = authenticationDao.authenticate(userDto);
        
        if ( user != null)
        {
            return user;
        }
        
        return null;
        
    }
}
