package Utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AccountGenerator {
	
	public static String generate(String username,String phoneno) {
		
		 UUID uuid = UUID.randomUUID();
		 String str = uuid.toString();
	    	str = str.toString().replace("-","");
	    	Random ran = new Random();
	        int rand1 = ran.nextInt(25);
	        int rand2 = rand1 +3;

	       
	        String account1 = str.substring(rand1,rand2);
	        char[] account = account1.toCharArray();

	        for(int i=0;i<3;i++)
	        {
	            if(Character.isLetter(account[i]))
	            {
	                account[i] = Character.toUpperCase(account[i]);
	            }
	        }
	        account1 = String.valueOf(account);
	        
	        int rand3 = ran.nextInt(7);
	        int rand4 = rand3+2;

	        String account2 = phoneno.substring(rand3,rand4);
	        username = username.replace(" ","");
	    	System.out.println(username);
	    
	        int rand5 = ran.nextInt(3);
	        
	        char letter = Character.toUpperCase(username.charAt(rand5));

	         

	        
		
		     return "LEO"+account1+account2+letter;
		
	}
	public static void sendmail() throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("chennavamshikrishna69@gmail.com", "vamshi61439");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("chennavamshikrishna69@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chennavamshikrishna69@gmail.com"));
		   msg.setSubject("Tutorials point email");
		   msg.setContent("Tutorials point email", "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Tutorials point email", "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

		   attachPart.attachFile("/var/tmp/image19.png");
		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}

}
