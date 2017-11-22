package Database;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailserver
{
  public static void emailRecommend(String name, String senderMail, String friendMail, String messageTxt)
  {
    String username = "ras1.team10@gmail.com";
    String password = "ras.team";
    String[] to = { friendMail };
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new Authenticator()
    {
      protected PasswordAuthentication getPasswordAuthentication()
      {
        return new PasswordAuthentication("ras1.team10@gmail.com", "ras.team");
      }
    });
    try
    {
      Message message = new MimeMessage(session);
      InternetAddress me = new InternetAddress(senderMail);
      try
      {
        me.setPersonal(name);
      }
      catch (UnsupportedEncodingException e)
      {
        e.printStackTrace();
      }
      message.setFrom(me);
      for (int i = 0; i < to.length; i++) {
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
      }
      message.setSubject("Recommend For User");
      message.setText("Hello " + friendMail.split("\\@")[0] + ",\n" + "\nI would like to recommend you....! " + name + ".\n\n" + "Message:  " + messageTxt + "\n\nThanks,\n" + name + "");
      
      Transport.send(message);
    }
    catch (MessagingException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public static void emailContact(String name, String friendMail, String messageTxt)
  {
    String username = "ras1.team10@gmail.com";
    String password = "ras.team";
    String[] to = { friendMail };
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new Authenticator()
    {
      protected PasswordAuthentication getPasswordAuthentication()
      {
        return new PasswordAuthentication("ras1.team10@gmail.com", "ras.team");
      }
    });
    try
    {
      Message message = new MimeMessage(session);
      InternetAddress me = new InternetAddress("ras1.team10@gmail.com");
      try
      {
        me.setPersonal(name);
      }
      catch (UnsupportedEncodingException e)
      {
        e.printStackTrace();
      }
      message.setFrom(me);
      for (int i = 0; i < to.length; i++) {
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
      }
      message.setSubject("Add the New Contact");
      message.setText("Hi " + friendMail.split("\\@")[0] + ",\n" + "\n I wouuld like to add you as a contact. Please respond " + name + ".\n\n" + "Message:  " + messageTxt + "\n\nThanks,\n" + name + "");
      
      Transport.send(message);
    }
    catch (MessagingException e)
    {
      throw new RuntimeException(e);
    }
  }
}
