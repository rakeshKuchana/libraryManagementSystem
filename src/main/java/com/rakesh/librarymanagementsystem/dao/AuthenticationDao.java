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
public class AuthenticationDao
{
    Connection conn = null;
    
    public Connection getSQLConnection()
    {
        DataSource dataSource = null;
        
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
    
    public User authenticate(UserDto userDto)
    {
        User user = new User();
        
        try
        {
            conn = getSQLConnection();
            //create statement object
            PreparedStatement stmt = conn.prepareStatement("select name, role from system.users where name=? and password=?");
            //set values
            stmt.setString(1, userDto.getUsername());
            stmt.setString(2, userDto.getPassword());
            //execute query
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                user.setUsername(rs.getString("name"));
                user.setRole(rs.getString("role"));
            }
            
            conn.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if (user.getUsername() == null)
        {
            return null;
        }
        
        return user;
    }
}
