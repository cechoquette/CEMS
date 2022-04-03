package CEMS.src.controllers;

import CEMS.src.application.CalendarView;
import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
        //TODO:Need to submit changes to the DB
        Pane mainScreen = ViewBuilder.newScreen("ForgotPassword");
        defaultPane.setCenter(mainScreen);

        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
        Pane home = ViewBuilder.newScreen("HomePage");
        BorderPane homePage = new BorderPane();
        CalendarView calendar = new CalendarView();

        homePage.setTop(home);
        homePage.setCenter(calendar.makeCalendar());

        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(homePage);

    }
}
