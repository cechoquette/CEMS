package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.HashMap;

public class CreateUserUIController {
    HashMap<Object, Object> dataToSubmit;

    @FXML
    private Button btnCreateUserBack;

    @FXML
    private Button btnCreateUserCancel1;

    @FXML
    private Button btnCreateUserClear;

    @FXML
    private Button btnCreateUserSubmit;

    @FXML
    private ComboBox<String> comboCreateUserClub;

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
    public void initialize() {
        // TODO: Add menu - first, add label in the FXML document
//        createUserBorderPane.setTop(new MainMenu().createMenu());

        // Add the values to the Permissions dropdown
        comboCreateUserPermissions.getItems().addAll(Arrays.asList(PermissionType.values()));

        // TODO: Add the values to the Clubs dropdown
        comboCreateUserClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));
    }


    public void checkMandatoryFields() {
        // All fields in the form are mandatory, so check them all
        // First Name
        if(!InputValidation.validateNotEmpty(tfCreateUserFirst)) {
            tfCreateUserFirst.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		else {
            tfCreateUserFirst.setStyle(null);
		}

        // Last Name
        if(!InputValidation.validateNotEmpty(tfCreateUserLast)) {
            tfCreateUserLast.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
        else {
            tfCreateUserLast.setStyle(null);
        }

        // TODO: Phone Number - proper formatting in InputValidation class
        if(!InputValidation.validatePhone(tfCreateUserPhone)) {
            tfCreateUserPhone.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
        else {
            tfCreateUserPhone.setStyle(null);
        }

        // TODO: Email - proper formatting in InputValidation class
        if(!InputValidation.validateEmail(tfCreateUserEmail)) {
            tfCreateUserEmail.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
        else {
            tfCreateUserEmail.setStyle(null);
        }

        // StudentID
        if(!InputValidation.validateStudentID(tfCreateUserID)) {
            tfCreateUserID.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
        else {
            tfCreateUserID.setStyle(null);
        }

        // TODO: Club - combobox validation in InputValidation class
//        if(!InputValidation.validateText(tfCreateUserID)) {
//            tfCreateUserID.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//        }
//        else {
//            tfCreateUserID.setStyle(null);
//        }

        // TODO: Permissions - combobox validation in InputValidation class
//        if(!InputValidation.validateText(tfCreateUserID)) {
//            tfCreateUserID.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//        }
//        else {
//            tfCreateUserID.setStyle(null);
//        }

    }

    @FXML
    void btnCreateUserBackClicked(ActionEvent event) {
        // TODO: Return user to the dashboard
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
        comboCreateUserPermissions.setValue(null);

        // TODO: Return user to the dashboard

    }

    @FXML
    void btnCreateUserSubmitClicked(ActionEvent event) {
        // Check that all mandatory fields are filled in
        checkMandatoryFields();

        // Add all data to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("", tfCreateUserFirst.getText());
        dataToSubmit.put("", tfCreateUserLast.getText());
        dataToSubmit.put("", tfCreateUserPhone.getText());
        dataToSubmit.put("", tfCreateUserEmail.getText());
        dataToSubmit.put("", tfCreateUserID.getText());
        dataToSubmit.put("", comboCreateUserClub.getValue());
        dataToSubmit.put("", comboCreateUserPermissions.getValue());

        // Send data to the controller
        Controller.processRequest(RequestType.CREATE_USER, dataToSubmit);
    }

}

