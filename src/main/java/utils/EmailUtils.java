package utils;

import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class EmailUtils {

    @SneakyThrows
    public void sendReport(String attName){
        MailPropperties mailPropperties = new MailPropperties();
        Properties properties = mailPropperties.mailPropertiesSet();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kodigo.projects@gmail.com","Fiaues2011**");
            }
        });
        Message message = new MimeMessage(session);
        message.setSubject("Report");
        Address addressTo = new InternetAddress("kodigo.projects@gmail.com");
        message.setRecipient(Message.RecipientType.TO,addressTo);
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart attachment =  new MimeBodyPart();
        attachment.attachFile(new File(attName));
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<h1>Subject 1 Report</h1>","text/html");
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Report Sended");

    }
}
