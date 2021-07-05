package utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class MailPropperties {

    public Properties mailPropertiesSet(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocl", "smtp");
        return properties;
    }

    public Session createSession(){
        Session session = Session.getInstance(mailPropertiesSet(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kodigo.projects@gmail.com","Fiaues2011**");
            }
        });
        return session;
    }
}
