package CEMS.src.controllers;

import CEMS.src.application.Club;
import CEMS.src.application.MailUtil;
import CEMS.src.application.OptionLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;

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
        comboCreateEventClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));

    }

    public LocalDateTime formatDateTime(){

        String time = tfCreateEventTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime dateTime = LocalTime.parse(time, formatter);

        LocalDateTime eventDateTime = LocalDateTime.of(dpCreateEventDate.getValue(), dateTime);

        return eventDateTime;
    }

    @FXML
    void btnCreateEventBackClicked(ActionEvent event) {

    }

    @FXML
    void btnCreateEventCancelClicked(ActionEvent event) {

    }

    @FXML
    void btnCreateEventSubmitClicked(ActionEvent event) {

        /*HashMap<Object, Object> dataToSubmit = new HashMap<Object, Object>();

        dataToSubmit.put("EventName", tfCreateEventName.getText());
        dataToSubmit.put("EventDescription", taCreateEventDescription.getText());
        dataToSubmit.put("EventClub", comboCreateEventClub.getValue());
        dataToSubmit.put("EventDateTime", formatDateTime());
        dataToSubmit.put("EventLocation", tfCreateEventLocation.getText());
        dataToSubmit.put("EventEmailGroup", comboCreateEventEmail.getValue());*/

        /* *** Sample Email Utility call code segment start *** */
        String[] mailingList = {
                "zgwekwerere@algomau.ca",
                "lclimenhage@algomau.ca",
                "cchoquette@algomau.ca",
                "ercameron@algomau.ca"
        };

        LocalDateTime eventDateTime =  LocalDateTime.of(2022, 04, 01, 12, 00);

        HashMap<Object, Object> hmEventData = new HashMap<>();
        hmEventData.put("EventName", "Food fight");
        hmEventData.put("EventDescription", "Our 8th annual food fight festival! Fun for the full family!");
        hmEventData.put("EventDateTime", eventDateTime);
        hmEventData.put("EventLocation", "West Cafeteria");
        hmEventData.put("EventEmailGroup", mailingList);

        try {
            MailUtil.sendEmail(hmEventData);
            System.out.println("Message sent successfully");
        }
        catch (Exception e) {
            System.out.println("Error sending email");
            e.printStackTrace();
        }
        /* *** Sample Email Utility call code segment end *** */

    }

}
