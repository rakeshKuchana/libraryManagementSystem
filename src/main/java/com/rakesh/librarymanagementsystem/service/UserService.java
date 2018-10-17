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
    private final UserDao userDao;
    
    public UserService()
    {
        userDao = new UserDao();
    }
    
    public User findById(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        User user = userDao.findById(userDto.getId());
        return user;
    }
    
    public void save(UserDto userDto) throws SQLException, FileNotFoundException, IOException
    {
        User user = new User();
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setGender(userDto.getGender());
        user.setDateOfBirth(userDto.getDay()+"/"+userDto.getMonth()+"/"+userDto.getYear());
        user.setUserId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        
        userDao.save(user);
    }
    
}
