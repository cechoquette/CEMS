package CEMS.src.controllers;

import CEMS.src.application.Club;
import CEMS.src.application.Controller;
import CEMS.src.application.RequestType;
import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class RequestAccessUIController {

    @FXML
    private Button btnRequestAccessBack;

    @FXML
    private Button btnRequestAccessCancel;

    @FXML
    private Button btnRequestAccessClear;

    @FXML
    private Button btnRequestAccessSubmit;

    @FXML
    private ComboBox<Club> comboRequestAccessClub;

    @FXML
    private TextArea taRequestAccessReason;

    @FXML
    private TextField tfRequestAccessEmail;

    @FXML
    private TextField tfRequestAccessFirst;

    @FXML
    private TextField tfRequestAccessID;

    @FXML
    private TextField tfRequestAccessLast;

    @FXML
    void btnRequestAccessBackClicked(ActionEvent event) {
        // Return the user to the login page
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnRequestAccessCancelClicked(ActionEvent event) {
        // TODO: Mention any abort or cancel method or tracking needed

        // Return the user to the login page
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnRequestAccessSubmitClicked(ActionEvent event) {
        // TODO: Validation of fields and error checking

        // TODO: Submit the info to wherever it needs to go

        HashMap<Object, Object> dataToSend = new HashMap<Object, Object>();

        dataToSend.put("RequestAccessClub", comboRequestAccessClub.getValue().toString());
        dataToSend.put("RequestAccessReason", taRequestAccessReason.getText());
        dataToSend.put("RequestAccessEmail", tfRequestAccessEmail.getText());
        dataToSend.put("RequestAccessFirstName", tfRequestAccessFirst.getText());
        dataToSend.put("RequestAccessStudentID", tfRequestAccessID.getText());
        dataToSend.put("RequestAccessLastName", tfRequestAccessLast.getText());

        Controller.processRequest(RequestType.SEND_REQUEST_ACCESS, dataToSend);

        // Return the user to the login page
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnRequestAccessClearClicked(ActionEvent event) {
        //Reload the screen
        Pane mainScreen = ViewBuilder.newScreen("RequestAccessForm");
        defaultPane.setCenter(mainScreen);
    }

}
