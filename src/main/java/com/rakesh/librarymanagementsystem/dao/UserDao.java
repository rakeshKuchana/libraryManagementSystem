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
    public User findById(String id) throws SQLException
    {
        Connection conn = ConnectionUtility.getSQLConnection();
        User user = new User();
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement("select id, password, role from system.users, system.authorities where id = user_id and (id = ? or email_id = ?)");
            
            stmt.setString(1, id);
            stmt.setString(2, id);
            
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
        
        if (user.getUserId() == null)
        {
            return null;
        }
       
        return user;
    }
    
}
