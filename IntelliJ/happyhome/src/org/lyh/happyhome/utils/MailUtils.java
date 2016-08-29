package org.lyh.happyhome.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by admin on 2015/4/8.
 */
public class MailUtils {
    public static void sendMail(String to,String code ){
        /*
         * 1.get a session
         * 2.create message
         * 3.send mail
         */
        Properties props = new Properties();
        props.setProperty("mail.host","localhost");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lvyahui8@126.com","password");
            }
        });

        Message message = new MimeMessage(session);
        //
        try {
            message.setFrom(new InternetAddress("lvyahui8@126.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //title
            message.setSubject("from happyhome mail");
            //content
            message.setContent("<h1>happyhome</h1><h3><a href='http://localhost/happyhome/user_active.action?code="+code+"'>active</a></h3>","text/html;charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
