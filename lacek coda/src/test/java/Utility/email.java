package Utility;

import org.openqa.selenium.WebDriver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class email extends TestBase{
	/*constructor*/
	public email(WebDriver driver) 
	{
		super();
	}
	//send email notification
	public static void main(String[] args) {

		String to = "arjun.karnati@lacek.com";
		String subject = "AUTOMATION REPORT NOTIFICATION";
		final String from ="autoreporttlg@gmail.com";
		final  String password ="Monday#2";
		Properties props = new Properties();  
		props.setProperty("mail.transport.protocol", "smtp");     
		props.setProperty("mail.host", "smtp.gmail.com");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "465");  
		props.put("mail.debug", "true");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.socketFactory.fallback", "false");  
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(from,password);  
			}  
		}); 
		try {
			String environment=testconfig.getProperty("baseUrl");
			String browser=testconfig.getProperty("os_browser");
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			//message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("prince.kabuika@lacek.com"));
			//message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("prbitmus@gmail.com"));
			// Set Subject: header field
			message.setSubject("AUTOMATED REPORT NOTIFICATION");
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			// set the actual message
			messageBodyPart.setText("Please Find The Attached Report File!!! "+"Environment: "+environment+", Browser: "+browser);
			                            
			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\prince.kabuika\\git\\codalacek\\lacek coda\\test-output\\emailable-report.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			// Send the complete message parts
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 		 
		InternetAddress addressFrom = null;
		try {
			addressFrom = new InternetAddress(from);
		} catch (AddressException e1) {
			e1.printStackTrace();
		}  
		MimeMessage message = new MimeMessage(session);  
		try {
			message.setSender(addressFrom);
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
		try {
			message.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
		try {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
	}  
	
	
}