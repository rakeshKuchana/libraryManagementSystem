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
    User user = null;
    
    public AuthenticationService()
    {
        userDao = new UserDao();
        user = new User();
    }
    
    public User authenticate(UserDto userDto) throws SQLException, AuthenticationException
    {
        user = userDao.findByUserId(userDto.getId());
        
        if (user.getUserId() == null)
        {
            user = userDao.findByEmailId(userDto.getId());
            
            if (user.getUserId() == null)
            {
                throw new AuthenticationException("Invalid Credentials");
            }
        }
        
        return user;
    }
}
