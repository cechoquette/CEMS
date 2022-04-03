package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class CreateUserUIController {
    HashMap<Object, Object> dataToSubmit;

    private boolean fieldsValid = true;

    @FXML
    private Button btnCreateUserBack;

    @FXML
    private Button btnCreateUserCancel1;

    @FXML
    private Button btnCreateUserClear;

    @FXML
    private Button btnCreateUserSubmit;

    @FXML
    private ComboBox<Club> comboCreateUserClub;

    @FXML
    private ComboBox<PermissionType> comboCreateUserPermissions;

    @FXML
    private TextField tfCreateUserEmail;

    @FXML
    private TextField tfCreateUserFirst;

    @FXML
    private TextField tfCreateUserID;

    @FXML
    private TextField tfCreateUserLast;

    @FXML
    private TextField tfCreateUserPhone;

    @FXML
    private TextField tfCreateUserSecQ;

    @FXML
    private TextField tfCreateUserSecA;

    /** Initialize Method - sets fields on load **/
    @FXML
    public void initialize() {
        // Add the values to the Permissions dropdown
        comboCreateUserPermissions.getItems().addAll(Arrays.asList(PermissionType.values()));

        // Add the values to the Clubs dropdown
        comboCreateUserClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));

        // Set placeholder text
        tfCreateUserFirst.setPromptText("first name");
        tfCreateUserLast.setPromptText("last name");
        tfCreateUserEmail.setPromptText("example@email.com");
        tfCreateUserID.setPromptText("123456789");
        tfCreateUserPhone.setPromptText("555-123-4567");
        tfCreateUserSecQ.setPromptText("security question");
        tfCreateUserSecA.setPromptText("security answer");
    }

    /** Method to check that mandatory fields have been filled **/
    public void checkMandatoryFields() {
        // All fields in the form are mandatory, so check them all
        // First Name
        if(!InputValidation.validateNotEmpty(tfCreateUserFirst)) {
            tfCreateUserFirst.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
		} else {
            tfCreateUserFirst.setStyle(null);
            fieldsValid = true;
		}

        // Last Name
        if(!InputValidation.validateNotEmpty(tfCreateUserLast)) {
            tfCreateUserLast.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            tfCreateUserLast.setStyle(null);
            fieldsValid = true;
        }

        // Phone Number
        if(!InputValidation.validatePhone(tfCreateUserPhone)) {
            tfCreateUserPhone.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            tfCreateUserPhone.setStyle(null);
            fieldsValid = true;
        }

        // Email
        if(!InputValidation.validateEmail(tfCreateUserEmail)) {
            tfCreateUserEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            tfCreateUserEmail.setStyle(null);
            fieldsValid = true;
        }

        // StudentID
        if(!InputValidation.validateStudentID(tfCreateUserID)) {
            tfCreateUserID.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
            fieldsValid = false;
        } else {
            tfCreateUserID.setStyle(null);
            fieldsValid = true;
        }

        // Club
        if(!InputValidation.validateComboNotEmpty(comboCreateUserClub)) {
            comboCreateUserClub.setStyle("-fx-background-color: #fabdb9 ;-fx-focus-color: red; -fx-border-color: red");
            fieldsValid = false;
        } else {
            comboCreateUserClub.setStyle(null);
            fieldsValid = true;
        }

        // Permissions
        if(!InputValidation.validateComboNotEmpty(comboCreateUserPermissions)) {
            comboCreateUserPermissions.setStyle("-fx-background-color: #fabdb9 ;-fx-focus-color: red; -fx-border-color: red");
            fieldsValid = false;
        } else {
            comboCreateUserPermissions.setStyle(null);
            fieldsValid = true;
        }

        // Security Question
        if(!InputValidation.validateSecurity(tfCreateUserSecQ)) {
            tfCreateUserSecQ.setStyle("-fx-background-color: #fabdb9 ;-fx-focus-color: red; -fx-border-color: red");
            fieldsValid = false;
        } else {
            tfCreateUserSecQ.setStyle(null);
            fieldsValid = true;
        }

        // Security Answer
        if(!InputValidation.validateSecurity(tfCreateUserSecA)) {
            tfCreateUserSecA.setStyle("-fx-background-color: #fabdb9 ;-fx-focus-color: red; -fx-border-color: red");
            fieldsValid = false;
        } else {
            tfCreateUserSecA.setStyle(null);
            fieldsValid = true;
        }

    }

    /** EventHandler Method - Back button **/
    @FXML
    void btnCreateUserBackClicked(ActionEvent event) {
        // Clear the fields
        btnCreateUserCancelClicked(event);

        // Return user to the dashboard
        Pane menuScreen = ViewBuilder.newScreen("MenuBar");
        Pane home = ViewBuilder.newScreen("HomePage");
        BorderPane homePage = new BorderPane();
        CalendarView calendar = new CalendarView();

        homePage.setTop(home);
        homePage.setCenter(calendar.makeCalendar());

        defaultPane.setTop(menuScreen);
        defaultPane.setCenter(homePage);
    }

    /** Method handles both cancel and clear button ActionEvents **/
    @FXML
    void btnCreateUserCancelClicked(ActionEvent event) {
        // Clear values in the form
        tfCreateUserFirst.setText("");
        tfCreateUserFirst.setStyle(null);
        tfCreateUserLast.setText("");
        tfCreateUserLast.setStyle(null);
        tfCreateUserPhone.setText("");
        tfCreateUserPhone.setStyle(null);
        tfCreateUserEmail.setText("");
        tfCreateUserEmail.setStyle(null);
        tfCreateUserID.setText(""); // StudentID
        tfCreateUserID.setStyle(null);
        comboCreateUserClub.setValue(null);
        comboCreateUserClub.setStyle(null);
        comboCreateUserPermissions.setValue(null);
        comboCreateUserPermissions.setStyle(null);
        tfCreateUserSecQ.setText("");
        tfCreateUserSecQ.setStyle(null);
        tfCreateUserSecA.setText("");
        tfCreateUserSecA.setStyle(null);

        // TODO: Return user to the dashboard

    }

    /** EventHandler Method - Submit button **/
    @FXML
    void btnCreateUserSubmitClicked(ActionEvent event) {
        // Check that all mandatory fields are filled in
        checkMandatoryFields();

        if (fieldsValid) {
            // Add all data to the hashmap
            dataToSubmit = new HashMap<Object, Object>();
            dataToSubmit.put("CreateUserFirstName", tfCreateUserFirst.getText());
            dataToSubmit.put("CreateUserLastName", tfCreateUserLast.getText());
            dataToSubmit.put("CreateUserPhone", tfCreateUserPhone.getText());
            dataToSubmit.put("CreateUserEmail", tfCreateUserEmail.getText());
            dataToSubmit.put("CreateUserStudentID", tfCreateUserID.getText());
            dataToSubmit.put("CreateUserClub", comboCreateUserClub.getValue());
            dataToSubmit.put("CreateUserPermission", comboCreateUserPermissions.getValue());
            dataToSubmit.put("CreateUserSecurityQ", tfCreateUserSecQ.getText());
            dataToSubmit.put("CreateUserSecurityA", tfCreateUserSecA.getText());

            // Send data to the controller
            Controller.processRequest(RequestType.CREATE_USER, dataToSubmit);

            btnCreateUserCancelClicked(event);
        }

    }

}

