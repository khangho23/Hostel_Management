/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SendEmail;
import Controller.XacNhanEmail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 *
 * @author QingShan
 */
public class email {
    public static String maxt = "";
    public static int RanDom(){
      int min = 100000;
      int max = 999999;
      int random_int = (int)(Math.random() * (max - min + 1) + min);
      System.out.println(random_int);
      maxt = String.valueOf(random_int);
      return random_int;
    }
    
    public static void GuiEmail(){
        final String username = "thanhson9112@gmail.com";
        final String password = "oqboegyladaeyitm";
        final String ToEmail = XacNhanEmail.getEmail();
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("thanhson9112@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(ToEmail)
            );
            message.setSubject("DOI MAT KHAU!");
            message.setText("Ðây là mã xác thuc: "+ RanDom() + "\n Vui lòng nhap de xac minh");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    
    }
        
}
