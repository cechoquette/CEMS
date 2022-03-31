package CEMS.src.controllers;

import CEMS.src.application.Club;
import CEMS.src.application.Controller;
import CEMS.src.application.OptionLists;
import CEMS.src.application.RequestType;
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

        HashMap<Object, Object> dataToSubmit = new HashMap<Object, Object>();

        dataToSubmit.put("EventName", tfCreateEventName.getText());
        dataToSubmit.put("EventDescription", taCreateEventDescription.getText());
        dataToSubmit.put("EventClub", comboCreateEventClub.getValue());
        dataToSubmit.put("EventDateTime", formatDateTime());
        dataToSubmit.put("EventLocation", tfCreateEventLocation.getText());
        dataToSubmit.put("EventEmailGroup", comboCreateEventEmail.getValue());

        Controller.processRequest(RequestType.CREATE_EVENT, dataToSubmit);
    }

}
