package CEMS.src.controllers;

import CEMS.src.application.InputValidation;
import CEMS.src.application.PasswordUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class ResetPasswordUIController {

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
        } else {

            // Check the password field
            if (!InputValidation.validatePassword(tfResetPass)) {
                tfResetPass.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            } else {
                tfResetPass.setStyle(null);
            }

            // Confirm password field
            if (!InputValidation.validatePassword(tfResetPassConfirm)) {
                tfResetPassConfirm.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            } else {
                tfResetPassConfirm.setStyle(null);
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

        // TODO: return the user to the dashboard if logged in, and the login page if not logged in

    }

    @FXML
    void btnResetPassClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        // Hash password (and store in DB with salt)
//        PasswordUtil.hashPassword(user, tfResetPass.getText(), PasswordUtil.generateSalt());
    }


}

