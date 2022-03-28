package CEMS.src.controllers;

import CEMS.src.application.InputValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ForgotPasswordUIController {

    @FXML
    private Button btnForgotBack;

    @FXML
    private Button btnForgotRecover;

    @FXML
    private TextField tfForgotEmail;

    @FXML
    void btnForgotBackClicked(ActionEvent event) {
        // TODO: return the user to the dashboard if logged in, and the login page if not logged in
    }

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {
        // TODO: use labels in FXML to check that the email field has been filled out
        // Check the email field
        if (!InputValidation.validateEmail(tfForgotEmail)) {
            tfForgotEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfForgotEmail.setStyle(null);
        }
    }

    @FXML
    void btnForgotRecoverClicked(ActionEvent event) {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

        // TODO: Send the user to a Reset Password page

    }


}

