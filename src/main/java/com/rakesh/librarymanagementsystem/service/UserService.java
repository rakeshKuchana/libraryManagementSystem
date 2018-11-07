package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.dao.UserDao;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import com.rakesh.librarymanagementsystem.exception.AuthenticationException;
import java.util.List;

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
    
    /**
     * @param userDto
     * @return List
     */
    public List searchByUsername(UserDto userDto)
    {
        return userDao.searchByUsername(userDto.getId());
    }
    
    /**
     * Service to complete librarian registration
     * @param userDto
     */
    public void create(UserDto userDto)
    {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setGender(userDto.getGender());
        user.setDateOfBirth(userDto.getDay()+AppConstants.CHAR_FORWARD_SLASH+userDto.getMonth()+AppConstants.CHAR_FORWARD_SLASH+userDto.getYear());
        user.setUserId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        
        userDao.create(user);
    }
    
    /**
     * removes the user
     * @param userDto
     */
    public void delete(UserDto userDto)
    {
        userDao.delete(userDto.getId());
    }
    
    /**
     * @param userDto - takes userDto with username and password
     * @return User - returns User with authentication and authorization information.If user not found or password does not match then throws AuthenticationException
     * @throws AuthenticationException - this exception is throws if username is not found or password does not match
     */
    public User authenticate(UserDto userDto) throws AuthenticationException
    {
        User user = userDao.getAuthInfoByUsername(userDto.getId());
        
        if (user != null && user.getPassword().equals(userDto.getPassword()))
        {
            //remove password from User object before sending it to the controller for security purpose as we don't want to set the password into session object
            user.setPassword(null);
            return user;
        }
        else
        {
            throw new AuthenticationException(AppConstants.MSG_INVALID_CREDS);
        }
    }
    
    /**
     * @param userDto
     * @return boolean
     */
    public boolean isAlreadyRegistered(UserDto userDto)
    {
        User user = new User();
        user.setEmailAddress(userDto.getEmailAddress());
        
        return userDao.getEmailAddress(user) != null;
    }
    
    /**
     * To check whether the userId already exists
     * @param userDto
     * @return boolean
     */
    public boolean isUserIdAlreadyUsed(UserDto userDto)
    {
        User user = new User();
        user.setUserId(userDto.getUserId());
        
        return userDao.getUserId(user) != null;
        
    }
    
}
