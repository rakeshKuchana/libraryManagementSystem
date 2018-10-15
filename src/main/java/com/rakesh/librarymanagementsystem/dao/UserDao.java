package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.util.ConnectionFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public User findById(String id) throws SQLException, FileNotFoundException, IOException
    {
        
        User user = null;
        
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select * from system.users, system.authorities where id = user_id and (id = ? or email_id = ?)");
            
            stmt.setString(1, id);
            stmt.setString(2, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               user = new User();
               user.setUserId(rs.getString("id"));
               user.setPassword(rs.getString("password"));
               user.setRole(rs.getString("role"));
               user.setFirstName(rs.getString("first_name"));
               user.setLastName(rs.getString("last_name"));
               user.setEmailAddress(rs.getString("email_id"));
               user.setGender(rs.getString("gender"));
               user.setDate(rs.getString("date_of_birth"));

            } 
        }
        
        return user;
    }
    
}
