package dhbwka.wwi.fridgeshare.email;


import java.io.File;
import java.util.Properties;

/*import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EmailService {

	private static Properties getMailProperties() {

		// Die Properties der JVM holen
		Properties properties = System.getProperties();

		// Postausgangsserver
		properties.setProperty("mail.smtp.host", "993");

		// Benutzername
		properties.setProperty("mail.user", "FridgeShareProject@gmail.com");

		// Passwort
		properties.setProperty("mail.password", "TyBtnmSV2MGQfdj");

		// Einstellungen für die SSL Verschlüsselte übermittlung von E-Mails
		properties.put("mail.smtps.auth", "true");
		properties.put("mail.smtps.**ssl.enable", "true");
		properties.put("mail.smtps.**ssl.required", "true");
		return properties;
	}

	public static void sendMail(String empfaenger, String betreff, String text ) {
		// Versender der E-Mail
		String versender = "FridgeShareProject@gmail.com";

		// Erstellt ein Session Objekt mit der E-Mail Konfiguration
		Session session = Session.getDefaultInstance(getMailProperties());
		// Optional, schreibt auf die Konsole / in das Log, die Ausgabe des
		// E-Mail Servers, dieses kann bei einer Fehleranalyse sehr Hilfreich
		// sein.
		session.setDebug(true);
		try {
			// Erstellt ein MimeMessage Objekt.
			MimeMessage message = new MimeMessage(session);

			// Setzt die E-Mail Adresse des Versenders in den E-Mail Header
			message.setFrom(new InternetAddress(versender));

			// Setzt die E-Mail Adresse des Empfängers in den E-Mail Header
			// hier können beliegig viele E-Mail Adressen hinzugefügt werden
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(empfaenger));

			// Der Empfänger erhält eine Kopie dieser E-Mail
			// message.addRecipient(Message.RecipientType.CC, new
			// InternetAddress(empfaenger));

			// Der Empfänger erhält eine "Blindkopie" dieser E-Mail d.h. er
			// sieht nicht wer diese E-Mail noch erhalten hat.
			// message.addRecipient(Message.RecipientType.BCC, new
			// InternetAddress(empfaenger));

			// Setzt den Betreff der E-Mail
			message.setSubject(betreff);

			// Erstellen des "Containers" für die Nachricht
			BodyPart messageBodyPart = new MimeBodyPart();

			// Setzen des Textes
			messageBodyPart.setText(text);

			// Erstellen eines Multipart Objektes für das ablegen des Textes
			Multipart multipart = new MimeMultipart();
			// Setzen des Textes
			multipart.addBodyPart(messageBodyPart);

			

			// Setzt den Inhalt der E-Mail, Text + Dateianhänge
			message.setContent(multipart);

			// E-Mail versenden
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	
	
}
*/
