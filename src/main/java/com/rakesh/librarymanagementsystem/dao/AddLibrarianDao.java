package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.Utilities.ConnectionUtility;
import com.rakesh.librarymanagementsystem.dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rakesh Kuchana
 */
public class AddLibrarianDao
{
    
    Connection conn = null;
    
    public AddLibrarianDao()
    {
        conn = ConnectionUtility.getSQLConnection();
    }
    
    public void addLibrarian(UserDto userDto)
    {
        try
        {
            PreparedStatement stmt = conn.prepareStatement("insert into system.registration values (?, ?, ?)");
            stmt.setString(1, userDto.getRegistrationId());
            stmt.setString(2, userDto.getEmailId());
            stmt.setString(3, userDto.getFirstname());
            
            stmt.executeUpdate();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
    }
}
