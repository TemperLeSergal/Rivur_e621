package sample.modules.EmailManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Emailer {
    public String hoste = "smtp.gmail.com";
    public String porte = "587";
    public String mailFrom = "avalondiscord@gmail.com";
    public String password = "KBHSkbhs!!8199";
    public Properties properties = new Properties();

    /**
     * Test the send html e-mail method
     */
    public static void main(String[] args) {

    }

    public void sendHtmlEmail(String toAddress_, String s) {

        // sets SMTP server properties

        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "false");
            props.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(props, new EmailAuth());
            Message msg = new MimeMessage(session);

            InternetAddress from = new InternetAddress("avalondiscord@gmail.com", "Avalon Support");
            msg.setFrom(from);

            InternetAddress toAddress = new InternetAddress(toAddress_);

            msg.setRecipient(Message.RecipientType.TO, toAddress);

            msg.setSubject("Test");
            msg.setContent(s, "text/html");
            Transport.send(msg);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    static class EmailAuth extends Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("avalondiscord@gmail.com", "KBHSkbhs!!8199");

        }
    }

}