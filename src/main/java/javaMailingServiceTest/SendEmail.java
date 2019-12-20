package javaMailingServiceTest;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) {
		//authentication info
		final String username = "arun4801@gmail.com";
		final String password = "April@2019";
		String fromEmail = "arun4801@gmail.com";
		String toEmail = "arun4801@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); // this is for enforcing authentication
		properties.put("mail.smtp.starttls.enable", "true");//switches connection to tls enabled one you may choose to use ssl enabled one also
		properties.put("mail.smtp.host", "smtp.gmail.com");//set host as yahoo or even you can set the company mail also
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Subject Line");
			
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Hello Arun");
			textBodyPart.setText("Hello Arun");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.setContent("<h1>Test Message</h1>","text/html");
			//pdfAttachment.attachFile("C:\\Users\\ARUNR11\\Desktop\\Arun_Time Sheet_Sep.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
