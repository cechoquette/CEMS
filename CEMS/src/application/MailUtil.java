package CEMS.src.application;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MailUtil {

    public static void sendEmail(HashMap<Object, Object> eventInfo) throws Exception {

        System.out.println("Preparing to send email");

        //Creating the email session in Gmail
        Properties properties = new Properties();  //Key-value store

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String appEmailUser = "3506project@gmail.com";
        String appEmailPass = "Admin!2345";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(appEmailUser, appEmailPass);
            }
        });

        //Extract the info from the HashMap
        String name = (String) eventInfo.get("EventName");
        String description = (String) eventInfo.get("EventDescription");
        LocalDateTime date = (LocalDateTime) eventInfo.get("EventDateTime");
        String location = (String) eventInfo.get("EventLocation");
        List<String> emailsAsAList = (List<String>) eventInfo.get("EventEmailGroup");
        //Turn the emails into a String[]
        String[] emailGroup = new String[emailsAsAList.size()];
        emailGroup = emailsAsAList.toArray(emailGroup);

        //Pass the info to the message builder

        Message message = messageBuilder(session, appEmailUser, name, description, date, location, emailGroup);

        Transport.send(message);
    }
    private static Message messageBuilder (Session session, String fromEmail, String name, String description, LocalDateTime date, String location, String[] emailGroup) throws Exception {

        Message message = new MimeMessage(session);

        //Set email message parameters
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipient(Message.RecipientType.TO, (new InternetAddress("3506project@gmail.com")));
        message.setSubject("Upcoming Event: " + name);

        String htmlContent = "<h1>Upcoming Event</h1>";
        htmlContent += "<p>Hey there!<br></p>" +
                "<p>This email was sent from Algoma University's Club & Event Management System<br></p>" +
                "<h2>Event<br></h2>";
        htmlContent += "<p>" + name + "<br></p>";
        htmlContent += "<h2>What it's all about<br></h2>" +
                "<p>" + description + "<br></p>";
        htmlContent += "<h2>Where its being held<br></h2>";
        htmlContent += "<p>" + location + "<br></p>";
        htmlContent += "<h2>Who's on the invitation list<br></h2><ul>";

        for (int i = 0; i < emailGroup.length; i++) {
            htmlContent += "<li>" + emailGroup[i] + "<br></li>";
        }

        htmlContent += "</ul>";

        message.setContent(htmlContent, "text/html");

        return message;
    }

}
