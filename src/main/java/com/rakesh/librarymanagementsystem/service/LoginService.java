package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.dao.UserDao;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class LoginService
{
    private UserDao userDao = null;
    
    public LoginService()
    {
        userDao = new UserDao();
    }
    
    public User validateUser(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        User user = userDao.findById(userDto.getId());
        
        if (user != null && user.getPassword().equals(userDto.getPassword()))
        {
             return user;
        }
        else
        {
            return null;
        }
    }
    
}
