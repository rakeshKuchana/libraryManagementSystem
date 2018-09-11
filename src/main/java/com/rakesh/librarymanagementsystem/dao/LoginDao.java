package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Rakesh Kuchana
 */
public class LoginDao
{
    
    public User getUserDetails(UserDto userDto)
    {
        User user = new User();
        Connection conn = null;
        try
        {
            conn = getSQLConnection();
            //create statement object
            PreparedStatement stmt = conn.prepareStatement("select * from system.users where name=? and password=?");
            //set values
            stmt.setString(1, userDto.getUsername());
            stmt.setString(2, userDto.getPassword());
            //execute query
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
            
            conn.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return user;
    }

    public Connection getSQLConnection()
    {
        DataSource dataSource = null;
        Connection conn = null;
        try
        {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/worldDB");
            conn = dataSource.getConnection();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }
    
//    public boolean isValidUser(UserDto userDto)
//    {
//        int recordCount = 0;
//        Connection conn = null;
//        try
//        {
//            conn = getSQLConnection();
//            //create statement object
//            PreparedStatement stmt = conn.prepareStatement("select * from system.users where name=? and password=?");
//            //set values
//            stmt.setString(1, userDto.getUsername());
//            stmt.setString(2, userDto.getPassword());
//            //execute query
//            recordCount = stmt.executeUpdate();
//            conn.close();
//            
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        
//            if (recordCount>0)
//            {
//                return true;
//            }
//            
//            return false;
//    }
}
