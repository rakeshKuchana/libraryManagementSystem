package com.rakesh.librarymanagementsystem.util;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Rakesh Kuchana
 */
public class ConnectionFactory
{
    static Connection conn = null;
    private static DataSource dataSource = null;
    
    static
    {
        try
        {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/worldDB");
        }
        catch(Exception e)
        {
            
        }
        
    }
    
    public static Connection getSQLConnection()
    {
        
        try
        {
            conn = dataSource.getConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }
}
