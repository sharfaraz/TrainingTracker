package com.att.ttt.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class SendMailAction extends ActionSupport
{
    private class SMTPAuthenticator extends Authenticator
    {
        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password)
        {
             authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
             return authentication;
        }
    }

    public Boolean mail()
    {
    	Boolean res;
        try
        {
            String from = "xyz.com";
            String to = "abc.com";
            String subject = "Your Subject.";
            String message = "Message Text.";
            String login = "xyz.com";
            String password = "password";

            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");

            Authenticator auth = new SMTPAuthenticator(login, password);

            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);

           try
           {
                msg.setText(message);
                msg.setSubject(subject);
                msg.setFrom(new InternetAddress(from));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
                Transport.send(msg);
                res = true;
           }
           catch (MessagingException ex)
           {
                Logger.getLogger(SendMailAction.class.getName()).
                log(Level.SEVERE, null, ex);
                res = false;
           }
           
           
        }
        catch(Exception e){
        	e.printStackTrace();
        	res = false;
        }
        return res;
    }


public String execute()
{
	String res;
	if (new SendMailAction().mail()){
		res = "success";
	}
	else{
		res ="failure";
	}
    return res;    
}
}
