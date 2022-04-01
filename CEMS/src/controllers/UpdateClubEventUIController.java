package CEMS.src.controllers;

import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private ComboBox<?> comboUpdateEventClub;

    @FXML
    private ComboBox<?> comboUpdateEventEmail;

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
        //TODO: Resubmit this updated event to the DB
    }

}

