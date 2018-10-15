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
public class UserService
{
    private UserDao userDao;
    
    public UserService()
    {
        userDao = new UserDao();
    }
    
    public User findById(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        User user = userDao.findById(userDto.getId());
        return user;
    }
    
}
