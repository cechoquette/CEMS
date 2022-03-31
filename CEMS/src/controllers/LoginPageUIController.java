package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

import static CEMS.src.application.Main.*;

public class LoginPageUIController {
    HashMap<Object, Object> dataToSubmit;

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
        // Email
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
    }

    @FXML
    void btnLoginForgotClicked(ActionEvent event) {
        btnLoginCancelClicked(event);
        btnLoginForgot.setStyle("-fx-text-fill: turquoise; -fx-background-color: transparent;");

        // Link to the forgot password page
        Pane mainScreen = ViewBuilder.newScreen("ForgotPassword");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnLoginSubmitClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        checkMandatoryFields();

        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
        Pane mainScreen = ViewBuilder.newScreen("HomePage");
        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(mainScreen);

        // Query the DB to retrieve the CURRENTUSER
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("LoginUserEmail", tfLoginEmail.getText());
        dataToSubmit.put("LoginUserPassword", pfLoginPassword.getText());

//        Controller.processRequest(RequestType.GET_USER, dataToSubmit);

        // Once the GET_USER request has run, add the remaining data to the hashmap and process the next login request
//        dataToSubmit.put("UserStudentID", CURRENTUSER.getStudentID());
//        dataToSubmit.put("UserFirstName", CURRENTUSER.getFirstName());
//        dataToSubmit.put("UserLastName", CURRENTUSER.getLastName());
//        dataToSubmit.put("UserEmail", CURRENTUSER.getEmail());
//        dataToSubmit.put("UserPassword", CURRENTUSER.getPassword());
//        dataToSubmit.put("UserPhoneNumber", CURRENTUSER.getPhone());
//        dataToSubmit.put("UserPermissions", CURRENTUSER.getPermission());
//        dataToSubmit.put("UserSalt", CURRENTUSER.getUserSalt());
//        dataToSubmit.put("UserSecurityQ", CURRENTUSER.getSecurityQuestion());
//        dataToSubmit.put("UserSecurityA", CURRENTUSER.getSecurityAnswer());

//        Controller.processRequest(RequestType.LOGIN_USER, dataToSubmit);

//        // Retrieve the user's email on login attempt
//        String email = tfLoginEmail.getText();
//
//        // Retrieve the user's salt from the DB
//        String salt = CURRENTUSER.getUserSalt();
//
//        // Hash the entered password
//        String hashedPassword = PasswordUtil.hashPassword(CURRENTUSER, pfLoginPassword.getText(), salt);
//
//        // Compare the email and the hashed password to the one stored in the DB
//        // Check the email
//        if (CURRENTUSER.getEmail().equals(tfLoginEmail.getText())) {
//            System.out.println("Email is correct");
//            // Check the password
//            if (CURRENTUSER.getPassword().equals(hashedPassword)) {
//                System.out.println("Password is correct");
//                // Link to the home page
//                Pane menuScreen = ViewBuilder.newScreen("MenuBar");
//                Pane mainScreen = ViewBuilder.newScreen("HomePage");
//                defaultPane.setTop(menuScreen);
//                defaultPane.setCenter(mainScreen);
//            } else {
//                // Set the password field as an error state
//                pfLoginPassword.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//            }
//        } else {
//            // Set the email field as an error state
//            tfLoginEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//        }


        // TODO: When logging in if true call controller - if not true cancel the submit action
        // nothing happens until everything is correct

    }

}

