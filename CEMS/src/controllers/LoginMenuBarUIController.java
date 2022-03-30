package CEMS.src.controllers;

import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import static CEMS.src.application.Main.defaultPane;

public class LoginMenuBarUIController {

    @FXML
    private Button btnLoginMenuNavLogin;

    @FXML
    private Button btnLoginMenuNavRequestAccess;

    @FXML
    void btnLoginMenuNavLoginClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnLoginMenuNavRequestAccessClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("RequestAccessForm");
        defaultPane.setCenter(mainScreen);
    }

}
