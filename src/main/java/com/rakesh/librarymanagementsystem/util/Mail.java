package com.rakesh.librarymanagementsystem.util;

import com.rakesh.librarymanagementsystem.constant.AppConstants;
import com.rakesh.librarymanagementsystem.service.MailAuthenticationService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rakesh Kuchana
 */
public class Mail
{
    public static void send(String to, String subject, String body)
    {
        try
        {
        
        Properties props = PropertyManager.getInstance().getProperties(AppConstants.MAIL_PROPERTIES);

        Session session = Session.getDefaultInstance(props, new MailAuthenticationService());
        
        
            MimeMessage message = new MimeMessage(session);
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            
            Transport.send(message);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
         
    }
}
