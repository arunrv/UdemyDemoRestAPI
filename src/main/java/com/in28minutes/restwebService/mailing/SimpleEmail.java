package com.in28minutes.restwebService.mailing;

import java.util.Properties;

import javax.mail.Session;

public class SimpleEmail {
	
	public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		
	  //  String smtpHostServer = "smtp.example.com";
	    String emailID = "arun4801@gmail.com";
	    
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		//props.put("mail.smtp.auth", "true"); //enable authentication
		//props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

	    //props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}