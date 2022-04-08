package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class RequestAccessUIController {
    private boolean firstNameFieldsValid = true;
    private boolean lastNameFieldsValid = true;
    private boolean emailFieldsValid = true;
    private boolean studentIDFieldsValid = true;
    private boolean clubFieldsValid = true;
    private boolean reasonFieldsValid = true;

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

    /** Method to initialize fields in the form **/
    public void initialize() {
        // Add the values to the Clubs dropdown
        comboRequestAccessClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));
    }

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {

        // First Name
        if (!InputValidation.validateNotEmpty(tfRequestAccessFirst)) {
            tfRequestAccessFirst.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            firstNameFieldsValid = false;
        } else {
            tfRequestAccessFirst.setStyle(null);
            firstNameFieldsValid = true;
        }

        // Last Name
        if (!InputValidation.validateNotEmpty(tfRequestAccessLast)) {
            tfRequestAccessLast.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            lastNameFieldsValid = false;
        } else {
            tfRequestAccessLast.setStyle(null);
            lastNameFieldsValid = true;
        }

        // Student ID
        if (!InputValidation.validateStudentID(tfRequestAccessID)) {
            tfRequestAccessID.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            studentIDFieldsValid = false;
        } else {
            tfRequestAccessID.setStyle(null);
            studentIDFieldsValid = true;
        }

        // Email
        if (!InputValidation.validateEmail(tfRequestAccessEmail)) {
            tfRequestAccessEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            emailFieldsValid = false;
        } else {
            tfRequestAccessEmail.setStyle(null);
            emailFieldsValid = true;
        }

        // Reason for Request
        if (!InputValidation.validateNotEmptyTextArea(taRequestAccessReason)) {
            taRequestAccessReason.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            reasonFieldsValid = false;
        } else {
            taRequestAccessReason.setStyle(null);
            reasonFieldsValid = true;
        }

        // Club
        if (!InputValidation.validateComboNotEmpty(comboRequestAccessClub)) {
            comboRequestAccessClub.setStyle("-fx-background-color: #fabdb9 ;-fx-focus-color: red; -fx-border-color: red");
            clubFieldsValid = false;
        } else {
            comboRequestAccessClub.setStyle(null);
            clubFieldsValid = true;
        }
    }

    @FXML
    void btnRequestAccessBackClicked(ActionEvent event) {
        // Clear the fields
        btnRequestAccessCancelClicked(event);

        // Return the user to the login page
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnRequestAccessCancelClicked(ActionEvent event) {
        // Clear the fields
        tfRequestAccessFirst.setText("");
        tfRequestAccessFirst.setStyle(null);
        tfRequestAccessLast.setText("");
        tfRequestAccessLast.setStyle(null);
        tfRequestAccessID.setText("");
        tfRequestAccessID.setStyle(null);
        tfRequestAccessEmail.setText("");
        tfRequestAccessEmail.setStyle(null);
        taRequestAccessReason.setText("");
        taRequestAccessReason.setStyle(null);
        comboRequestAccessClub.setValue(null);
        comboRequestAccessClub.setStyle(null);

        // TODO: Mention any abort or cancel method or tracking needed

        // Return the user to the login page
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnRequestAccessSubmitClicked(ActionEvent event) {
        // Validation of fields and error checking
        checkMandatoryFields();

        if (firstNameFieldsValid && lastNameFieldsValid
            && emailFieldsValid && studentIDFieldsValid
            && clubFieldsValid && reasonFieldsValid) {
            
            // Submit the info to wherever it needs to go
            HashMap<Object, Object> dataToSend = new HashMap<Object, Object>();

            dataToSend.put("RequestAccessClub", comboRequestAccessClub.getValue());
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
    }

    @FXML
    void btnRequestAccessClearClicked(ActionEvent event) {
        //Reload the screen
        Pane mainScreen = ViewBuilder.newScreen("RequestAccessForm");
        defaultPane.setCenter(mainScreen);
    }

}
