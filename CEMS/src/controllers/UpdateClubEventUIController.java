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
import javafx.scene.layout.Pane;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static CEMS.src.application.Main.defaultPane;

public class UpdateClubEventUIController {

    @FXML
    private Button btnUpdateEventBack;

    @FXML
    private Button btnUpdateEventCancel;

    @FXML
    private Button btnUpdateEventClear;

    @FXML
    private Button btnUpdateEventSubmit;

    @FXML
    private ComboBox<Club> comboUpdateEventClub;

    @FXML
    private ComboBox<String> comboUpdateEventEmail;

    @FXML
    private DatePicker dpUpdateEventDate;

    @FXML
    private TextArea taUpdateEventDescription;

    @FXML
    private TextField tfUpdateEventLocation;

    @FXML
    private TextField tfUpdateEventName;

    @FXML
    private TextField tfUpdateEventTime;

    @FXML
    public void initialize(){
        //initialize club list
        //initialize email group list
        comboUpdateEventEmail.getItems().addAll(Arrays.asList(OptionLists.EMAIL_GROUPS()));
//        comboCreateEventClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));//use for testing only
        comboUpdateEventClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));
        int eventID = (int) EventID.getInstance().getID();
    }



    public LocalDateTime formatDateTime(){

        String time = tfUpdateEventTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime dateTime = LocalTime.parse(time, formatter);

        LocalDateTime eventDateTime = LocalDateTime.of(dpUpdateEventDate.getValue(), dateTime);

        return eventDateTime;
    }

    @FXML
    void btnUpdateEventBackClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("HomePage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnUpdateEventCancelClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("HomePage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnUpdateEventClearClicked(ActionEvent event) {

        comboUpdateEventClub.setValue(null);
        comboUpdateEventEmail.setValue(null);
        dpUpdateEventDate.setValue(null);
        taUpdateEventDescription.setText("");
        tfUpdateEventLocation.setText("");
        tfUpdateEventName.setText("");
        tfUpdateEventTime.setText("");
    }

    @FXML
    void btnUpdateEventSubmitClicked(ActionEvent event) {
        HashMap<Object, Object> dataToSubmit = new HashMap<Object, Object>();

        dataToSubmit.put("EventName", tfUpdateEventName.getText());
        dataToSubmit.put("EventDescription", taUpdateEventDescription.getText());
        dataToSubmit.put("EventClub", comboUpdateEventClub.getValue());
        dataToSubmit.put("EventDateTime", formatDateTime());
        dataToSubmit.put("EventLocation", tfUpdateEventLocation.getText());
        dataToSubmit.put("EventEmailGroup", comboUpdateEventEmail.getValue());

        //Create the event, get it back
        ClubEvent eventCreated = (ClubEvent) Controller.processRequest(RequestType.MODIFY_EVENT, dataToSubmit).get("ClubEvent");

        //Get the populated mailing list & put it in the HashMap
        List<String> emailList = eventCreated.getEmailGroup();
        dataToSubmit.put("EventEmailsPopulated", emailList);

        //Send the email with the updated HashMap
        Controller.processRequest(RequestType.SEND_EMAIL, dataToSubmit);


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

