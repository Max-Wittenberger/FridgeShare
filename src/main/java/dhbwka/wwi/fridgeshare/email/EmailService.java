package dhbwka.wwi.fridgeshare.email;

 
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class EmailService {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
        static String pdfPath = "C:\\Users\\maxwi\\Desktop\\4.Semester\\FRIDGESHARE\\FRIDGESHARE\\FridgeShare\\src\\main\\webapp\\Einkaufsliste.pdf";
 
	public static void sendEmailTo(String emailTo ) throws AddressException, MessagingException, IOException {
		generateAndSendEmail(emailTo);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void generateAndSendEmail(String emailTo) throws AddressException, MessagingException, IOException {
 
		// Step1 Mail Properties einrichten
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2 Email Inhalt füllen (Absender, sowie Inhalt)
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("Dein Einkaufszettel | FridgeShare");
                
		//String emailBody = "Hallo ";
		//generateMailMessage.setContent(emailBody, "text/html");
                //add PDF to email
                Multipart multipart = new MimeMultipart();
                MimeBodyPart attachPart = new MimeBodyPart();
                attachPart.attachFile(pdfPath);
                multipart.addBodyPart(attachPart);
                generateMailMessage.setContent(multipart, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3 einloggen und email senden
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		transport.connect("smtp.gmail.com", "FridgeShareProject@gmail.com", "TyBtnmSV2MGQfdj");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}



