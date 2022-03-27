package CEMS.src.controllers;

import CEMS.src.application.InputValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageUIController {

    @FXML
    private Button btnLoginCancel;

    @FXML
    private Button btnLoginForgot;

    @FXML
    private Button btnLoginSubmit;

    @FXML
    private PasswordField pfLoginPassword;

    @FXML
    private TextField tfLoginEmail;

    public void checkMandatoryFields() {
        // All fields in the form are mandatory, so check them all

        // TODO: Email - proper formatting in InputValidation class
        if(!InputValidation.validateEmail(tfLoginEmail)) {
            tfLoginEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfLoginEmail.setStyle(null);
        }

        // Password
        if(!InputValidation.validateNotEmpty(pfLoginPassword)) {
            pfLoginPassword.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            pfLoginPassword.setStyle(null);
        }

    }

    @FXML
    void btnLoginCancelClicked(ActionEvent event) {
        // Clear the fields
        tfLoginEmail.setText("");
        tfLoginEmail.setStyle(null);
        pfLoginPassword.setText("");
        pfLoginPassword.setStyle(null);

        // TODO: What to do next - Maybe close the app after?
    }

    @FXML
    void btnLoginForgotClicked(ActionEvent event) {
        btnLoginCancelClicked(event);
        btnLoginForgot.setStyle("-fx-text-fill: turquoise; -fx-background-color: transparent;");

        // TODO: link to the forgot password page

    }

    @FXML
    void btnLoginSubmitClicked(ActionEvent event) {
        checkMandatoryFields();

        // TODO: Log the user in
    }

}

