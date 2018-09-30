package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.util.ConnectionFactory;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class RegistrationDao
{
    Connection conn = null;
    
    public RegistrationDao()
    {
        conn = ConnectionFactory.getSQLConnection();
    }
    
    public String getRegisteredEmailId(UserDto userDto)
    {
        
        String registeredEmailId = null;
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement("select email_id from system.registration where id=?");
        
            stmt.setString(1, userDto.getRegistrationId());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                registeredEmailId = rs.getString("email_id");
            }
            
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        
        return registeredEmailId;
         
    }
    
    public void register(UserDto userDto)
    {
        try
        {
            PreparedStatement stmt = conn.prepareStatement("insert into system.users values (?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, userDto.getId());
            stmt.setString(2, userDto.getPassword());
            stmt.setString(3, userDto.getFirstname());
            stmt.setString(4, userDto.getLastname());
            stmt.setString(5, userDto.getEmailId());
            stmt.setString(6, userDto.getGender());
            stmt.setString(7, userDto.getDateOfBirth());
            
            stmt.executeUpdate();
            
            PreparedStatement stmt2 = conn.prepareStatement("insert into system.authorities values (?, ?)");
            
            stmt2.setString(1, userDto.getId());
            stmt2.setString(2, userDto.getRole());
            
            stmt2.executeUpdate();
            
            
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
    }
}
