package org.example.message;

import java.util.Properties;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
public class SendEmail {

    public static void sendMessage(String error) throws Exception{

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.Enable","true");
        properties.put("mail.smtp.user","melnyk1509@gmail.com");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("*********@gmail.com", "***************");
            }
        };

        Session session = Session.getDefaultInstance(properties,auth);
        System.out.println("Session created");

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("melnyk1509@gmail.com"));
        message.setReplyTo(InternetAddress.parse("melnyk1509@gmail.com", false));
        message.setSubject("The critical error occurred","ANSI");
        message.setText(error,"ANSI");

        message.setRecipient(Message.RecipientType.TO,new InternetAddress("melnyk1509@gmail.com"));
        Transport.send(message);
        System.out.println("Message was sent successfully...");

    }
}
