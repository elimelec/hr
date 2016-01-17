package email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender
{
    String from = "hrulbs@gmail.com";

    public void send(String to, String subject, String message) {

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(properties, null);
        session.setDebug(true);

        try {
                Message mimeMessage = new MimeMessage(session);

                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(message);

                Transport transport = session.getTransport("smtps");
                transport.connect("smtp.gmail.com", from, "hrulbshrulbs");
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        }
        catch (MessagingException mex) {
           mex.printStackTrace();
        }
    }
}
