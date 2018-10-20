package com.rakesh.librarymanagementsystem.service;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.util.PropertyManager;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Rakesh Kuchana
 */
public class MailAuthenticationService extends Authenticator
{
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        Properties props = null;
        
        try
        {
           props = PropertyManager.getInstance().getProperties(AppConstants.MAIL_PROPERTIES);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        
        return new PasswordAuthentication(props.getProperty("mail.smpt.emailAddress"), props.getProperty("mail.smtp.password"));
        
    }
}
