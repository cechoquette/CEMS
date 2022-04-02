package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

import static CEMS.src.application.Main.*;

public class LoginPageUIController {
    HashMap<Object, Object> dataToSubmit;

    private boolean fieldsValid = true;

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

    /** Method to check that the mandatory fields are filled **/
    public void checkMandatoryFields() {
        // All fields in the form are mandatory, so check them all
        // Email
        if(!InputValidation.validateEmail(tfLoginEmail)) {
            tfLoginEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            tfLoginEmail.setStyle(null);
            fieldsValid = true;
        }

        // Password
        if(!InputValidation.validatePassword(pfLoginPassword)) {
            pfLoginPassword.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            pfLoginPassword.setStyle(null);
            fieldsValid = true;
        }
    }

    /** EventHandler Method - Cancel button **/
    @FXML
    void btnLoginCancelClicked(ActionEvent event) {
        // Clear the fields
        tfLoginEmail.setText("");
        tfLoginEmail.setStyle(null);
        pfLoginPassword.setText("");
        pfLoginPassword.setStyle(null);
    }

    /** EventHandler Method - Forgot Password button **/
    @FXML
    void btnLoginForgotClicked(ActionEvent event) {
        btnLoginCancelClicked(event);
        btnLoginForgot.setStyle("-fx-text-fill: turquoise; -fx-background-color: transparent;");

        // Link to the forgot password page
        Pane mainScreen = ViewBuilder.newScreen("ForgotPassword");
        defaultPane.setCenter(mainScreen);
    }

    /** EventHandler Method - Login button **/
    @FXML
    void btnLoginSubmitClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        checkMandatoryFields();

//        if (fieldsValid) {
//            // Query the DB to retrieve and populate the CURRENTUSER
//            dataToSubmit = new HashMap<Object, Object>();
//            dataToSubmit.put("LoginUserEmail", tfLoginEmail.getText());
//            dataToSubmit.put("LoginUserPassword", pfLoginPassword.getText());
//
//            Controller.processRequest(RequestType.GET_USER, dataToSubmit);
//
//            if ((Main.CURRENTUSER != null) && (Main.CURRENTUSER.getUserSalt() != null)) {
//                Controller.processRequest(RequestType.LOGIN_USER, dataToSubmit);
//
//                // Retrieve the user's email on login attempt
//                String email = tfLoginEmail.getText();
//
//                // Retrieve the user's salt from the DB
//                String salt = CURRENTUSER.getUserSalt();
//
//                // Hash the entered password
//                String hashedPassword = PasswordUtil.hashPassword(CURRENTUSER, pfLoginPassword.getText(), salt);
//
//                // Compare the email and the hashed password to the one stored in the DB
//                // Check the email
//                if (CURRENTUSER.getEmail().equals(tfLoginEmail.getText())) {
//                    // Check the password
//                    if (CURRENTUSER.getPassword().equals(hashedPassword)) {
//                        // Link to the home page
//                        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
//                        Pane mainScreen = ViewBuilder.newScreen("HomePage");
//                        defaultPane.setTop(menuScreen);
//                        defaultPane.setCenter(mainScreen);
//                    } else {
//                        // Set the password field as an error state
//                        pfLoginPassword.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//                    }
//                }
//            } else {
//                // Set the email field as an error state
//                tfLoginEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//            }
//        }

        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
        //Pane mainScreen = ViewBuilder.newScreen("HomePage");
        BorderPane homePage = new BorderPane();
        homePage.setTop(menuScreen);
        CalendarView calendar = new CalendarView();
        homePage.setCenter(calendar.makeCalendar());
        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(homePage);



    }

}

