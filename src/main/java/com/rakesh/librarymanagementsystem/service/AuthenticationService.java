package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.UserDao;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.exception.AuthenticationException;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationService
{
    UserDao userDao = null;
    
    public AuthenticationService()
    {
        userDao = new UserDao();
    }
    
    public User authenticate(UserDto userDto) throws SQLException, AuthenticationException
    {
        User user = userDao.findById(userDto.getId());

        if (user == null)
        {
            throw new AuthenticationException("Invalid Credentials");
        }
        
        return user;
    }
}
