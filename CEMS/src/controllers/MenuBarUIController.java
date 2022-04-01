package CEMS.src.controllers;

import CEMS.src.application.Main;
import CEMS.src.application.PermissionType;
import CEMS.src.application.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static CEMS.src.application.Main.defaultPane;

public class MenuBarUIController {

    @FXML
    private MenuItem menuClubsMember;

    @FXML
    private MenuItem menuClubsProfile;

    @FXML
    private MenuItem menuEventsCalendar;

    @FXML
    private MenuItem menuEventsCreate;

    @FXML
    private MenuItem menuFileExit;

    @FXML
    private MenuItem menuFileLogout;

    @FXML
    private MenuItem menuFileUserMgmt;

    @FXML
    private MenuItem menuItemReportingClubs;

    @FXML
    private MenuItem menuItemReportingEvents;

    @FXML
    private MenuItem menuItemReportingFinance;

    @FXML
    private MenuItem menuProfilePage;

    @FXML
    private MenuItem menuProfilePassword;

/* **** Buttons under the 'File' tab **** */

    @FXML
    void menuFileUserMgmtClicked(ActionEvent event) {
        if (Main.CURRENTUSER.getPermission().equals(PermissionType.SUPER_ADMIN.toString())) {
            Pane mainScreen = ViewBuilder.newScreen("UserManagement");
            defaultPane.setCenter(mainScreen);
        } else {
            try {
                Desktop.getDesktop().browse(new URI("mailto:sysadmin@services.net"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
//        Pane mainScreen = ViewBuilder.newScreen("UserManagement");
//        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuFileLogoutClicked(ActionEvent event) {
        Pane menuScreen = ViewBuilder.newScreen("LoginMenuBar");
        Pane mainScreen = ViewBuilder.newScreen("LoginPage");
        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuFileExitClicked(ActionEvent event) {
        ((Stage)defaultPane.getScene().getWindow()).close();
    }

/* **** Buttons under the 'Profile' tab **** */

    @FXML
    void menuProfilePageClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ProfilePage");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuProfilePasswordClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ForgotPassword");
        defaultPane.setCenter(mainScreen);
    }

/* **** Buttons under the 'Clubs' tab **** */
    @FXML
    void menuClubsMemberClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("MemberManagementForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuClubsProfileClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ClubProfileForm");
        defaultPane.setCenter(mainScreen);
    }

/* **** Buttons under the 'Events' tab **** */
    @FXML
    void menuEventsCalendarClicked(ActionEvent event) {
        //TODO: Need to create fxml
        Pane mainScreen = ViewBuilder.newScreen("");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuEventsCreateClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("CreateClubEventForm");
        defaultPane.setCenter(mainScreen);
    }

/* **** Buttons under the 'Reporting' tab **** */

    @FXML
    void menuItemReportingClubsClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ClubBudgetSubmissionForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuItemReportingEventsClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ClubEventBudgetSubmissionForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuItemReportingExpenditureClicked(ActionEvent event) {
        //Need to create fxml
        Pane mainScreen = ViewBuilder.newScreen("ExpenditureSubmissionForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void menuItemReportClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("ReportRequestForm");
        defaultPane.setCenter(mainScreen);
    }

}
