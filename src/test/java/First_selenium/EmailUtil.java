package First_selenium;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailUtil {

    public static void sendEmail(String toEmail,String subject, String body) {

        String fromEmail = System.getenv("NaukriUser");
        String appPassword = System.getenv("AuthCode");

        //String toEmail = "anuragvighe8@gmail.com";
        //System.out.println("Email found: " + (fromEmail != null));
        //System.out.println("Password found: " + (appPassword != null));
        //System.out.println("Password found: " + toEmail);

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(
                properties,
                new Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                fromEmail,
                                appPassword
                        );
                    }
                }
        );

        try {

            Message message = new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(fromEmail)
            );

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject(subject);

            message.setText(body);

            Transport.send(message);

            System.out.println(
                    "Email notification sent successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Failed to send email: " + e.getMessage()
            );
        }
    }
}
