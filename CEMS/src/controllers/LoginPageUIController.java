package CEMS.src.controllers;

import CEMS.src.application.InputValidation;
import CEMS.src.application.PasswordUtil;
import CEMS.src.application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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
        if(!InputValidation.validatePassword(pfLoginPassword)) {
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

        // TODO: send the user to the Home Page
    }

    @FXML
    void btnLoginForgotClicked(ActionEvent event) {
        btnLoginCancelClicked(event);
        btnLoginForgot.setStyle("-fx-text-fill: turquoise; -fx-background-color: transparent;");

        // TODO: link to the forgot password page

    }

    @FXML
    void btnLoginSubmitClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        checkMandatoryFields();

        // TODO: Log the user in

        // TODO: Check the login information is correct
//        PasswordUtil.validatePassword(user, tfLoginEmail.getText(), pfLoginPassword.getText());

        // TODO: Then direct the user to their dashboard page
    }

}

