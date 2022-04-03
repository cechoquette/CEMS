package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static CEMS.src.application.Main.defaultPane;

public class CreateClubEventUIController {

    @FXML
    private Button btnCreateEventBack;

    @FXML
    private Button btnCreateEventCancel;

    @FXML
    private Button btnCreateEventClear;

    @FXML
    private Button btnCreateEventSubmit;

    @FXML
    private ComboBox<Club> comboCreateEventClub;

    @FXML
    private ComboBox<String> comboCreateEventEmail;

    @FXML
    private DatePicker dpCreateEventDate;

    @FXML
    private TextArea taCreateEventDescription;

    @FXML
    private TextField tfCreateEventLocation;

    @FXML
    private TextField tfCreateEventName;

    @FXML
    private TextField tfCreateEventTime;

    @FXML
    public void initialize(){
        //initialize club list
        //initialize email group list
        comboCreateEventEmail.getItems().addAll(Arrays.asList(OptionLists.EMAIL_GROUPS()));
//        comboCreateEventClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));//use for testing only
        comboCreateEventClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));

    }

    public LocalDateTime formatDateTime(){

        String time = tfCreateEventTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime dateTime = LocalTime.parse(time, formatter);

        LocalDateTime eventDateTime = LocalDateTime.of(dpCreateEventDate.getValue(), dateTime);

        return eventDateTime;
    }
    @FXML
    void btnCreateEventClearClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("CreateClubEventForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnCreateEventBackClicked(ActionEvent event) {
        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
        Pane home = ViewBuilder.newScreen("HomePage");
        BorderPane homePage = new BorderPane();
        CalendarView calendar = new CalendarView();

        homePage.setTop(home);
        homePage.setCenter(calendar.makeCalendar());

        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(homePage);
    }

    @FXML
    void btnCreateEventCancelClicked(ActionEvent event) {

        Pane mainScreen = ViewBuilder.newScreen("HomePage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnCreateEventSubmitClicked(ActionEvent event) {

        HashMap<Object, Object> dataToSubmit = new HashMap<Object, Object>();

        dataToSubmit.put("EventName", tfCreateEventName.getText());
        dataToSubmit.put("EventDescription", taCreateEventDescription.getText());
        dataToSubmit.put("EventClub", comboCreateEventClub.getValue());
        dataToSubmit.put("EventDateTime", formatDateTime());
        dataToSubmit.put("EventLocation", tfCreateEventLocation.getText());
        dataToSubmit.put("EventEmailGroup", comboCreateEventEmail.getValue());

        //Create the event, get it back
        ClubEvent eventCreated = (ClubEvent)Controller.processRequest(RequestType.CREATE_EVENT, dataToSubmit).get("ClubEvent");

        //Get the populated mailing list & put it in the HashMap
        List<String> emailList = eventCreated.getEmailGroup();
        dataToSubmit.put("EventEmailsPopulated", emailList);

        //Send the email with the updated HashMap
        Controller.processRequest(RequestType.SEND_EVENT_EMAIL, dataToSubmit);


//        /* *** Sample Email Utility call code segment start *** */
//
////        String[] mailingList = {
////                "zgwekwerere@algomau.ca",
////                "lclimenhage@algomau.ca",
////                "cchoquette@algomau.ca",
////                "ercameron@algomau.ca"
////        };
//
//        List<String> mailingList2 = new ArrayList<>();
//        mailingList2.add("zgwekwerere@algomau.ca");
//        mailingList2.add("zgwekwerere@algomau.ca");
//        mailingList2.add("zgwekwerere@algomau.ca");
//        mailingList2.add("zgwekwerere@algomau.ca");
//
//        LocalDateTime eventDateTime =  LocalDateTime.of(2022, 04, 01, 12, 00);
//
//        HashMap<Object, Object> hmEventData = new HashMap<>();
//        hmEventData.put("EventName", "Food fight");
//        hmEventData.put("EventDescription", "Our 8th annual food fight festival! Fun for the full family!");
//        hmEventData.put("EventDateTime", eventDateTime);
//        hmEventData.put("EventLocation", "West Cafeteria");
//        hmEventData.put("EventEmailGroup", mailingList2);
//
////        ClubEvent testEvent = new ClubEvent("Test Event", "This is to test the emails changes", Main.ALLCLUBS, eventDateTime, "At home", OptionLists.EMAIL_GROUPS()[0]);
//
//        try {
//            MailUtil.sendEmail(hmEventData);
//            System.out.println("Message sent successfully");
//        }
//        catch (Exception e) {
//            System.out.println("Error sending email");
//            e.printStackTrace();
//        }
//        /* *** Sample Email Utility call code segment end *** */

    }

}
