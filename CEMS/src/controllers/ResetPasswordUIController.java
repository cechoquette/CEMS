package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class ResetPasswordUIController {
    HashMap<Object, Object> dataToSubmit;

    private boolean fieldsValid = true;

    @FXML
    private Button btnResetPass;

    @FXML
    private TextField tfResetPass;
    
    @FXML
    private TextField tfResetPassConfirm;

//    @FXML
//    private void initialize() {
//        lbForgotPassSecQ.setText("What is your mother's maiden name?");
//    }

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {

        // If the password values entered don't match
        if (!tfResetPass.getText().equals(tfResetPassConfirm.getText())) {
            tfResetPass.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            tfResetPassConfirm.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {

            // Check the password field
            if (!InputValidation.validatePassword(tfResetPass)) {
                tfResetPass.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
                fieldsValid = false;
            } else {
                tfResetPass.setStyle(null);
                fieldsValid = true;
            }

            // Confirm password field
            if (!InputValidation.validatePassword(tfResetPassConfirm)) {
                tfResetPassConfirm.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
                fieldsValid = false;
            } else {
                tfResetPassConfirm.setStyle(null);
                fieldsValid = true;
            }

        }

    }

    @FXML
    void btnResetBackClicked(ActionEvent event) {
        // Clear the fields
        tfResetPass.setText("");
        tfResetPass.setStyle(null);
        tfResetPassConfirm.setText("");
        tfResetPassConfirm.setStyle(null);

        // Return the user to the dashboard if logged in, and the login page if not logged in
        // TODO: currently only returns them to login page, need something to tell us where to send them
        Pane menuScreen = ViewBuilder.newScreen("LoginMenuBar");
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(mainScreen);

    }

    @FXML
    void btnResetPassClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        if (fieldsValid){
            // Add data to the hashmap
            dataToSubmit = new HashMap<Object, Object>();
            dataToSubmit.put("ResetUserPassword", tfResetPass);
            dataToSubmit.put("ResetUserPasswordConfirm", tfResetPassConfirm);

            // Send data to the controller
            Controller.processRequest(RequestType.PASSWORD_RESET, dataToSubmit);
        }

    }


}

