package com.rakesh.librarymanagementsystem.dao;

import com.rakesh.librarymanagementsystem.constant.DBConstants;
import com.rakesh.librarymanagementsystem.domain.User;
import com.rakesh.librarymanagementsystem.util.ConnectionFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rakesh Kuchana
 */
public class UserDao
{
    /**
     * @param username - takes userId or emailId
     * @return User - returns User object with user authentication and authorization information.If user is not found then returns null
     */
    public User getAuthInfoByUsername(String username)
    {

        User user = null;

        try (Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select id, password, role  from system.users, system.authorities where id = user_id and (id = ? or email_address = ?)");

            stmt.setString(1, username);
            stmt.setString(2, username);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                user = new User();
                user.setUserId(rs.getString(DBConstants.COLUMN_ID));
                user.setPassword(rs.getString(DBConstants.COLUMN_PASSWORD));
                user.setRole(rs.getString(DBConstants.COLUMN_ROLE));
                
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        

        return user;
    }

    public List<User> searchById(String id) throws SQLException, FileNotFoundException, IOException
    {

        final String QUERY = "select id, password, role, first_name, last_name, email_address, gender, to_char(date_of_birth,'DD-MON-YYYY') date_of_birth from system.users, system.authorities where id = user_id and (id like ? or email_address like ?)";
        User user;
        List<User> list = null;

        try (Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement(QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1, "%" + id + "%");
            stmt.setString(2, "%" + id + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                list = new ArrayList();
                rs.beforeFirst();

                while (rs.next())
                {
                    user = new User();

                    user.setUserId(rs.getString("id"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmailAddress(rs.getString("email_address"));
                    user.setGender(rs.getString("gender"));
                    user.setDateOfBirth(rs.getString("date_of_birth"));

                    list.add(user);

                }
            }

        }

        return list;
    }
    
    /**
     * Creates records in users and authorities tables
     * @param user
     */
    public void create(User user)
    {
        try (Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("insert into system.users values (?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy'))");
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmailAddress());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getDateOfBirth());

            stmt.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement("insert into system.authorities values (?, ?)");
            stmt2.setString(1, user.getUserId());
            stmt2.setString(2, user.getRole());

            stmt2.executeUpdate();
            
            
            PreparedStatement stmt3 = conn.prepareStatement("delete from system.registration where email_address = ?");
            stmt3.setString(1, user.getEmailAddress());
            
            stmt3.executeUpdate();
            
            conn.commit();

        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
    
    public void delete(String id) throws SQLException, FileNotFoundException, IOException
    {
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("delete from system.authorities where user_id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
            
            PreparedStatement stmt2 = conn.prepareStatement("delete from system.users where id = ?");
            stmt2.setString(1, id);
            stmt2.executeUpdate();
            
            conn.commit();
        }
    }
    
    public String getEmailAddress(User user)
    {
        String emailAddress = null;
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select email_address from system.users where email_address = ?");
            stmt.setString(1, user.getEmailAddress());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               emailAddress = rs.getString("email_address");
            }
            
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        
        return emailAddress;
    }
    
    /**
     * To get user Id from users table
     * @param user
     * @return String
     */
    public String getUserId(User user)
    {
        String userId = null;
        try(Connection conn = ConnectionFactory.getConnection())
        {
            PreparedStatement stmt = conn.prepareStatement("select id from system.users where id = ?");
            stmt.setString(1, user.getUserId());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               userId = rs.getString(DBConstants.COLUMN_ID);
            }
            
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        
        return userId;
    }
    

}
