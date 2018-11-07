package com.rakesh.librarymanagementsystem.util;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Rakesh Kuchana
 */
public class ConnectionFactory
{
    private final BasicDataSource basicDataSource;
    private static ConnectionFactory connectionFactory;
    
    private ConnectionFactory()
    {
        Properties props = PropertyManager.getInstance().getPropertiesFromFileSystem(AppConstants.DATASOURCE_PROPERTIES);
        
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(props.getProperty(AppConstants.DRIVER_CLASS));
        basicDataSource.setUrl(props.getProperty(AppConstants.DRIVER_URL));
        basicDataSource.setUsername(props.getProperty(AppConstants.DB_USERNAME));
        basicDataSource.setPassword(props.getProperty(AppConstants.DB_PASSWORD));
        
    }
    
    private static ConnectionFactory getInstance()
    {
        if(connectionFactory == null)
        {
            connectionFactory = new ConnectionFactory();
        }
        
        return connectionFactory;
    }
    
    public static Connection getConnection()
    {
        try
        {
            return getInstance().basicDataSource.getConnection();
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        
    }
}
