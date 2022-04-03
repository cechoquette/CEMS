package CEMS.src.application;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MailUtil {

    public static void sendNewEvent (HashMap<Object, Object> eventInfo) throws Exception {

        System.out.println("Preparing to send new event email");

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
        List<String> emailsAsAList = (List<String>) eventInfo.get("EventEmailsPopulated");
        //Turn the emails into a String[]
        String[] emailGroup = new String[emailsAsAList.size()];
        emailGroup = emailsAsAList.toArray(emailGroup);

        //Pass the info to the message builder

        Message message = newEventBuilder(session, appEmailUser, name, description, date, location, emailGroup);

        Transport.send(message);
    }

    public static void sendEventUpdate (HashMap<Object, Object> eventInfo) throws Exception {

        System.out.println("Preparing to send event update email");

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
        List<String> emailsAsAList = (List<String>) eventInfo.get("EventEmailsPopulated");
        //Turn the emails into a String[]
        String[] emailGroup = new String[emailsAsAList.size()];
        emailGroup = emailsAsAList.toArray(emailGroup);

        //Pass the info to the message builder

        Message message = upDateEventBuilder(session, appEmailUser, name, description, date, location, emailGroup);

        Transport.send(message);
    }

    public static void sendRequestAccess (HashMap<Object, Object> eventInfo) throws Exception {
        System.out.println("Preparing to send new event email");

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
        String firstName = (String) eventInfo.get("RequestAccessFirstName");
        String lastName = (String) eventInfo.get("RequestAccessLastName");
        int studentID = (int) eventInfo.get("RequestAccessStudentID");
        String club = (String) eventInfo.get("RequestAccessClub");
        String reason = (String) eventInfo.get("RequestAccessReason");
        String email = (String) eventInfo.get("RequestAccessEmail");

        //Pass the info to the message builder

        Message message = requestAccessBuilder(session, firstName, lastName, studentID, club, reason, email);

        Transport.send(message);
    }

    private static Message newEventBuilder (Session session, String fromEmail, String name, String description, LocalDateTime date, String location, String[] emailGroup) throws Exception {

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
    private static Message upDateEventBuilder (Session session, String fromEmail, String name, String description, LocalDateTime date, String location, String[] emailGroup) throws Exception {

        Message message = new MimeMessage(session);

        //Set email message parameters
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipient(Message.RecipientType.TO, (new InternetAddress("3506project@gmail.com")));
        message.setSubject("Upcoming Event: " + name);

        String htmlContent = "<h1>An Event has been updated!</h1>";
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
    private static Message requestAccessBuilder (Session session, String firstName, String lastName, int studentID, String club, String reason, String email) throws Exception {

        Message message = new MimeMessage(session);

        //Set email message parameters
        message.setFrom(new InternetAddress("3506project@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, (new InternetAddress("3506project@gmail.com")));
        message.setSubject("New Request for System Access from : " + firstName + " " + lastName);

        String htmlContent = "<h1>Attention: There is a new request for access</h1>";
        htmlContent += "<p>Sent from "  + firstName + " " + lastName + " <br></p>" +
                "<p>This email was sent from the Request Access form in the CEMS appliation<br></p>" +
                "<h2>New User Information:<br></h2>";
        htmlContent += "<p>First Name: " + firstName + "<br></p>";
        htmlContent += "<p>Last Name: " + lastName + "<br></p>";
        htmlContent += "<p>Email Address: " + email + "<br></p>";
        htmlContent += "<p>Student ID (please verify with school records): " + studentID + "<br></p>";
        htmlContent += "<p>Club Association requested: " + club + "<br></p>";
        htmlContent += "<h3>Justification Given for Granting Access:<br></h3>";
        htmlContent += "<p>" + reason + "<br></p>";

        message.setContent(htmlContent, "text/html");

        return message;
    }
}
