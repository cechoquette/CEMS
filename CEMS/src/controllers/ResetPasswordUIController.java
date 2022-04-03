package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
    private PasswordField pfResetPass;
    
    @FXML
    private PasswordField pfResetPassConfirm;

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {

        // If the password values entered don't match
        if (!pfResetPass.getText().equals(pfResetPassConfirm.getText())) {
            pfResetPass.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            pfResetPassConfirm.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {

            // Check the password field
            if (!InputValidation.validatePassword(pfResetPass)) {
                pfResetPass.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
                fieldsValid = false;
            } else {
                pfResetPass.setStyle(null);
                fieldsValid = true;
            }

            // Confirm password field
            if (!InputValidation.validatePassword(pfResetPassConfirm)) {
                pfResetPassConfirm.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
                fieldsValid = false;
            } else {
                pfResetPassConfirm.setStyle(null);
                fieldsValid = true;
            }
        }
    }

    /** EventHandler Method - Back button **/
    @FXML
    void btnResetBackClicked(ActionEvent event) {
        // Clear the fields
        pfResetPass.setText("");
        pfResetPass.setStyle(null);
        pfResetPassConfirm.setText("");
        pfResetPassConfirm.setStyle(null);

        // Return the user to the dashboard if logged in, and the login page if not logged in
        // TODO: currently only returns them to login page, need something to tell us where to send them


//        if(Main.CURRENTUSER == null){
            Pane menuScreen = ViewBuilder.newScreen("LoginMenuBar");
            Pane mainScreen = ViewBuilder.newScreen("LoginPage");
            defaultPane.setTop(menuScreen);
            defaultPane.setCenter(mainScreen);
//        }
//        else{
//            Pane menuScreen2 = ViewBuilder.newScreen("MenuBar");
//            Pane home = ViewBuilder.newScreen("HomePage");
//            BorderPane homePage = new BorderPane();
//            CalendarView calendar = new CalendarView();
//
//            homePage.setTop(home);
//            homePage.setCenter(calendar.makeCalendar());
//
//            defaultPane.setTop(menuScreen2);
//            defaultPane.setCenter(homePage);
//        }

    }

    /** EventHandler Method - Reset Password button **/
    @FXML
    void btnResetPassClicked(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        if (fieldsValid){
            // Add data to the hashmap
            dataToSubmit = new HashMap<Object, Object>();
            dataToSubmit.put("ResetUserPassword", pfResetPass.getText());
            dataToSubmit.put("ResetUserPasswordConfirm", pfResetPassConfirm.getText());

            // Send data to the controller
            Controller.processRequest(RequestType.PASSWORD_RESET, dataToSubmit);

            btnResetBackClicked(event);
        }
    }


}

