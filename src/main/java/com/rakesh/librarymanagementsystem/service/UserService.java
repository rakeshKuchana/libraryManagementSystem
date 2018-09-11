package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dao.LoginDao;
import com.rakesh.librarymanagementsystem.dto.UserDto;

/**
 *
 * @author Rakesh Kuchana
 */
public class UserService
{
    public User getUserDetails(UserDto userDto)
    {
        LoginDao loginDao = new LoginDao();
        User user = loginDao.getUserDetails(userDto);
        return user;
    }
}
