package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class ForgotPasswordUIController {
    HashMap<Object, Object> dataToSubmit;

    @FXML
    private Button btnForgotBack;

    @FXML
    private Button btnForgotRecover;

    @FXML
    private TextField tfForgotEmail;
    
    @FXML
    private TextField tfForgotPassSecA;

    @FXML
    private Label lbForgotPassSecQ;

    @FXML
    private void initialize() {
        lbForgotPassSecQ.setText("What is your mother's maiden name?");
    }

    @FXML
    void btnForgotBackClicked(ActionEvent event) {
        // Clear the fields
        tfForgotEmail.setText("");
        tfForgotEmail.setStyle(null);
        tfForgotPassSecA.setText("");
        tfForgotPassSecA.setStyle(null);

        // Return the user to the dashboard if logged in, and the login page if not logged in
        // TODO: currently only returns them to login page, need something to tell us where to send them
        Pane menuScreen = ViewBuilder.newScreen("LoginMenuBar");
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(mainScreen);

    }

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {
        // Check the email field
        if (!InputValidation.validateEmail(tfForgotEmail)) {
            tfForgotEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfForgotEmail.setStyle(null);
        }

        // Security Answer
        if (!InputValidation.validateSecurityAnswer(tfForgotPassSecA)) {
            tfForgotPassSecA.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfForgotPassSecA.setStyle(null);
        }

    }

    @FXML
    void btnForgotRecoverClicked(ActionEvent event) {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        // Put data into hashmap and send to controller
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("ForgotPasswordEmail", tfForgotEmail.getText());
        dataToSubmit.put("ForgotPasswordSecurityA", tfForgotPassSecA.getText());

        Controller.processRequest(RequestType.GET_USER, dataToSubmit);

        // Once the GET_USER request has run, confirm user and conditionally progress through app
        if (dataToSubmit.get("ForgotPasswordEmail").equals(Main.CURRENTUSER.getEmail())) {
            if (dataToSubmit.get("ForgotPasswordSecA").equals(Main.CURRENTUSER.getSecurityAnswer())) {
                // Conditionally send the user to a Reset Password page
                Pane mainScreen = ViewBuilder.newScreen("ResetPassword");
                defaultPane.setCenter(mainScreen);
            } else {
                tfForgotPassSecA.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            }
        } else {
            tfForgotEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
    }
}

