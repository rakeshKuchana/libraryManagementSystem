package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.Utilities.ConnectionUtility;
import com.rakesh.librarymanagementsystem.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class UserDao
{
    private Connection conn;
    
    public User findByUserId(String id) throws SQLException
    {
        conn = ConnectionUtility.getSQLConnection();
        User user = new User();
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement("select id, password, role from system.users, system.authorities where id = user_id and id = ?");
            
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               user.setUserId(rs.getString("id"));
               user.setPassword(rs.getString("password"));
               user.setRole(rs.getString("role"));
            } 
        }
        finally
        {
            conn.close();
        }
       
        return user;
    }
    
    public User findByEmailId(String emailId) throws SQLException
    {
        conn = ConnectionUtility.getSQLConnection();
        User user = new User();
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement("select id, password, role from system.users, system.authorities where id = user_id and email_id = ?");
            
            stmt.setString(1, emailId);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               user.setUserId(rs.getString("id"));
               user.setPassword(rs.getString("password"));
               user.setRole(rs.getString("role"));
            } 
        }
        finally
        {
            conn.close();
        }
       
        return user;
    }
    
}
