/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

/**
 *
 * @author pc2
 */
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP {

    private static final String email = "personalfinanc1@gmail.com";
    private static final String password = "X"; // X = znqpowcxtgcwyixg

    public static void sendmail(String to, String m) {
        // Set up the properties for the SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Set up the session
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            // Set up the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email, "BANK"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Actions on your account");
            String SSN = ATM.DataBase.getValue("SSN", "Account,Customer", "  Account.Customer_ID=Customer.Customer_ID and Account_NO = " + LogIn.CustID);
            String NAME =ATM.DataBase.getValue("FirstName", "Person", " SSN = " + SSN);
            message.setText("Hi " + NAME + ", \n" + m);
            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SMTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
