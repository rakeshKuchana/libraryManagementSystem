package com.rakesh.librarymanagementsystem.Utilities;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Rakesh Kuchana
 */
public class ConnectionUtility
{
    static Connection conn = null;
    
    public static Connection getSQLConnection()
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
}
