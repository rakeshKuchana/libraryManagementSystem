package com.rakesh.librarymanagementsystem.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Rakesh Kuchana
 */
public class ContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        //Do basic configuration to use log4j
        BasicConfigurator.configure();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        
    }
}
