package com.nocknock.mailapi;
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

public class SendEmailUsingGMailSMTP {
  // public static void main(String[] args) {
	public void sendMail(String email,String message,long id) {
		System.out.println("In Email");
		//String email="manoj@codebele.com";long business_id=1;
      // Recipient's email ID needs to be mentioned.
      String to = email;//"manjuktrl@gmail.com";//change accordingly

      String emailBody=message;
      // Sender's email ID needs to be mentioned
      String from = "manojreddy.mkr@gmail.com";//change accordingly
      final String username = "manojreddy.mkr@gmail.com";//change accordingly
      final String password = "manoj.mkr";//change accordingly

    
      String result = null;
      
      //String message1 = "UnFortunately Your File will Be deleted From Cloud we will recover soon";
      try {
           
          Properties props = System.getProperties();
          props.setProperty("mail.transport.protocol", "smtp");
          props.setProperty("mail.host", "smtp.gmail.com");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "465");
          props.put("mail.debug", "true");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.socketFactory.fallback", "false");

          Session emailSession = Session.getInstance(props,
                  new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username,password);
                  }
          });

          emailSession.setDebug(true);
          Message msg = new MimeMessage(emailSession);

      	msg.setFrom(new InternetAddress(username));
      	InternetAddress[] toAddresses = { new InternetAddress(email) };
      	msg.setRecipients(Message.RecipientType.TO, toAddresses);
      	msg.setSubject(" registration  Welcomes You");
      	//msg.setSentDate(new Date());

      	// creates message part
      	MimeBodyPart messageBodyPart = new MimeBodyPart();
      	messageBodyPart.setContent(emailBody, "text/html");

      	// creates multi-part
      	Multipart multipart = new MimeMultipart();
      	multipart.addBodyPart(messageBodyPart);

      	// adds attachments


      	// sets the multi-part as e-mail's content
      	msg.setContent(multipart);

      	// sends the e-mail
      	Transport.send(msg);

      	System.out.println("Successfully sent email");
          //result = "Successfully sent email";

         } catch (MessagingException e) {
      	   System.out.println("Unable to send email");
      }

      
   }
}