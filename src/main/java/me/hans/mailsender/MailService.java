package me.hans.mailsender;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
    public static String sendMail(String target, String subject, String text) {

        final String username = "email_here"; // Fill with your email
        final String password = "pass_here"; // Fill with your password of your email

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(target));
            msg.setSubject(subject);
            msg.setText(text);

            Transport.send(msg);

            return "Email sent successfully!";
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return "Failed to send email: " + mex.getMessage();
        }
    }
}
