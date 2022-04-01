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

import static CEMS.src.application.Main.CURRENTUSER;
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

    /** Initialize Method - initializes the Security Question text **/
    @FXML
    private void initialize() {
        lbForgotPassSecQ.setText(Main.CURRENTUSER.getSecurityQuestion());
    }

    /** EventHandler Method - Back button **/
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
        if (!InputValidation.validateSecurity(tfForgotPassSecA)) {
            tfForgotPassSecA.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfForgotPassSecA.setStyle(null);
        }

    }

    /** EventHandler Method - Reset Password button **/
    @FXML
    void btnForgotRecoverClicked(ActionEvent event) {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        // Once the GET_USER request has run, confirm user and conditionally progress through app
        if (Main.CURRENTUSER != null) {
            if (Main.CURRENTUSER.getEmail().equals(tfForgotEmail.getText())) {
                if (Main.CURRENTUSER.getSecurityAnswer().equals(tfForgotPassSecA.getText())) {
                    // Conditionally send the user to a Reset Password page
                    Pane menuScreen = ViewBuilder.newScreen("MenuBar");
                    Pane mainScreen = ViewBuilder.newScreen("ResetPassword");
                    defaultPane.setTop(menuScreen);
                    defaultPane.setCenter(mainScreen);
                } else {
                    tfForgotPassSecA.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
                }
            } else {
                tfForgotEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            }
        }


    }
}

