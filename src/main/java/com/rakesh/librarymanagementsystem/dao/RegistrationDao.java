package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.domain.Registration;
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
public class RegistrationDao
{
   public void save(User user) throws SQLException, FileNotFoundException, IOException
   {
       try(Connection conn = ConnectionFactory.getConnection())
       {
           PreparedStatement stmt = conn.prepareStatement("insert into system.registration values (?, ?, ?, ?)");
       
           stmt.setString(1, user.getRegistrationId());
           stmt.setString(2, user.getEmailAddress());
           stmt.setString(3, user.getFirstName());
           stmt.setString(4, user.getLastName());
       
           stmt.executeUpdate();
           
           conn.commit();
       }
   }
   
   public Registration findById(String registrationId) throws FileNotFoundException, IOException, SQLException
   {
       
       Registration registration = null; 
       
        try(Connection conn= ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select first_name, last_name, email_address from system.registration where id=?");
        
            stmt.setString(1, registrationId);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                registration = new Registration();
                registration.setFirstName(rs.getString("first_name"));
                registration.setLastName(rs.getString("last_name"));
                registration.setEmailAddress(rs.getString("email_address"));
            }
            
        }
        
        return registration;
   }
}
