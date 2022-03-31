package CEMS.src.controllers;

import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static CEMS.src.application.Main.defaultPane;

public class ProfilePageUIController {

    @FXML
    private Button btnProfilePassword;

    @FXML
    private Button btnProfileSubmit;

    @FXML
    private TextField tfProfileEmail;

    @FXML
    private TextField tfProfileFirst;

    @FXML
    private TextField tfProfileLast;

    @FXML
    private TextField tfProfileRecoveryAnswer;

    @FXML
    private TextField tfProfileRecoveryQuestion;

    @FXML
    public void initialize(){
        //TODO: Need to populate the text fields
    }

    @FXML
    void btnProfilePasswordClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ForgotPassword");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnProfileSubmitClicked(ActionEvent event) {

    }
}
