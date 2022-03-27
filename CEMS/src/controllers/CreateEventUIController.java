package CEMS.src.controllers;

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
import java.util.HashMap;

public class CreateEventUIController {

    @FXML
    private Button btnCreateEventBack;

    @FXML
    private Button btnCreateEventCancel;

    @FXML
    private Button btnCreateEventClear;

    @FXML
    private Button btnCreateEventSubmit;

    @FXML
    private ComboBox<String> comboCreateEventClub;

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

        HashMap<Object, Object> dataToSubmit = new HashMap<Object, Object>();

        dataToSubmit.put("EventName", tfCreateEventName.getText());
        dataToSubmit.put("EventDescription", tfCreateEventName.getText());
        dataToSubmit.put("EventClub", null);//either send a club, or a club id
        dataToSubmit.put("EventDateTime", formatDateTime());
        dataToSubmit.put("EventEmailGroup", comboCreateEventEmail.getValue());

    }

}
