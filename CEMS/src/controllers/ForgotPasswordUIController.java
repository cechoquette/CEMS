package CEMS.src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ForgotPasswordUIController {

    @FXML
    private Button btnForgotBack;

    @FXML
    private Button btnForgotRecover;

    @FXML
    void btnForgotBackClicked(ActionEvent event) {
        // return the user to the dashboard if logged in, and the login page if not logged in
    }

    /** Method to check the fields have been filled **/
    public void checkMandatoryFields() {
        // TODO: use labels in FXML to check that the email field has been filled out
    }

    @FXML
    void btnForgotRecoverClicked(ActionEvent event) {
        // Check that all mandatory fields are filled
        checkMandatoryFields();

    }


}

