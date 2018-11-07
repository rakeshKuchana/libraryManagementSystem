package com.rakesh.librarymanagementsystem.util;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Rakesh Kuchana
 */
public class PropertyManager
{

    private static PropertyManager propertyManager;

    private PropertyManager()
    {

    }

    public static PropertyManager getInstance()
    {
        if (propertyManager == null)
        {
            propertyManager = new PropertyManager();
        }

        return propertyManager;
    }

    public Properties getProperties(String fileName) throws FileNotFoundException, IOException
    {
        Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/property/" + fileName));
        return props;
    }

    public Properties getPropertiesFromFileSystem(String fileName)
    {
        try
        {
            Properties appProps = PropertyManager.getInstance().getProperties(AppConstants.APPLICATION_PROPERTIES);

            Properties props = new Properties();
            props.load(new FileInputStream(appProps.getProperty(AppConstants.DATASOURCE_FILE_PATH) + fileName));
            return props;
        }
        catch(FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
