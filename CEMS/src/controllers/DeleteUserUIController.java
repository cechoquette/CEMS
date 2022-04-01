package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import static CEMS.src.application.Main.defaultPane;

public class DeleteUserUIController {
    HashMap<Object, Object> dataToSubmit;

    @FXML
    private Button btnDeleteUserBack;

    @FXML
    private Button btnDeleteUserCancel1;

    @FXML
    private Button btnDeleteUserClear;

    @FXML
    private Button btnDeleteUserSearch;

    @FXML
    private Button btnDeleteUserSubmit;

    @FXML
    private ComboBox<Club> comboDeleteUserClub;

    @FXML
    private ComboBox<PermissionType> comboDeleteUserPermissions;

    @FXML
    private TextField tfDeleteUserSearch;

    @FXML
    private TextField tfDeleteUserEmail;

    @FXML
    private TextField tfDeleteUserFirst;

    @FXML
    private TextField tfDeleteUserID;

    @FXML
    private TextField tfDeleteUserLast;

    @FXML
    private TextField tfDeleteUserPhone;

    @FXML
    private BorderPane deleteUserBorderPane;

    /** Initialize Method - method to set fields on load **/
    @FXML
    public void initialize() {

        // Add the values to the Permissions dropdown
        comboDeleteUserPermissions.getItems().addAll(Arrays.asList(PermissionType.values()));

        // Add the values to the Clubs dropdown
        comboDeleteUserClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));

        // Set all TextFields to have non-editable styling
        tfDeleteUserFirst.setStyle("-fx-control-inner-background: #cce0ff");
        tfDeleteUserLast.setStyle("-fx-control-inner-background: #cce0ff");
        tfDeleteUserPhone.setStyle("-fx-control-inner-background: #cce0ff");
        tfDeleteUserEmail.setStyle("-fx-control-inner-background: #cce0ff");
        tfDeleteUserID.setStyle("-fx-control-inner-background: #cce0ff");
        comboDeleteUserClub.setStyle("-fx-control-inner-background: #cce0ff");
        comboDeleteUserPermissions.setStyle("-fx-control-inner-background: #cce0ff");
    }

    /** Method to check that all mandatory fields are filled **/
    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfDeleteUserSearch)) {
            tfDeleteUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfDeleteUserSearch.setStyle(null);
        }
    }

    /** EventHandler Method - Back button **/
    @FXML
    void btnDeleteUserBackClicked(ActionEvent event) {
        // Clear the fields
        btnDeleteUserCancelClicked(event);

        // Return the user to the User Management page
        Pane mainScreen = ViewBuilder.newScreen("UserManagement");
        defaultPane.setCenter(mainScreen);
    }

    /** EventHandler Method - Cancel button **/
    @FXML
    void btnDeleteUserCancelClicked(ActionEvent event) {
        // Clear the fields
        tfDeleteUserSearch.setText("");
        tfDeleteUserSearch.setStyle(null);
        tfDeleteUserFirst.setText("");
        tfDeleteUserLast.setText("");
        tfDeleteUserPhone.setText("");
        tfDeleteUserEmail.setText("");
        tfDeleteUserID.setText("");
        comboDeleteUserClub.setValue(null);
        comboDeleteUserPermissions.setValue(null);

        // TODO: return the user to the User Management page

    }

    /** EventHandler Method - Search button **/
    @FXML
    void btnDeleteUserSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add data to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("DeleteSearchEmail", tfDeleteUserSearch.getText());

        // Send a query to the DB for the users email address
        HashMap<Object, Object> hm;
        hm = Controller.processRequest(RequestType.SEARCH_FOR_USER, dataToSubmit);

        User user = (User)hm.get("User");

        // If found, return results in the correct fields
        if (user != null) {
            tfDeleteUserFirst.setText(user.getFirstName());
            tfDeleteUserLast.setText(user.getLastName());
            tfDeleteUserEmail.setText(user.getEmail());
            tfDeleteUserID.setText(String.valueOf(user.getStudentID()));
            tfDeleteUserPhone.setText(user.getPhone());
            comboDeleteUserClub.setValue(user.getUserClub());
            if (user.getPermission().equals(PermissionType.ADMIN.toString())) {
                comboDeleteUserPermissions.setValue(PermissionType.ADMIN);
            }
            if (user.getPermission().equals(PermissionType.ADMIN_PLUS.toString())) {
                comboDeleteUserPermissions.setValue(PermissionType.ADMIN_PLUS);
            }
            if (user.getPermission().equals(PermissionType.SUPER_ADMIN.toString())) {
                comboDeleteUserPermissions.setValue(PermissionType.SUPER_ADMIN);
            }

        } else {
            // Else, error state
            tfDeleteUserSearch.setText("");
            tfDeleteUserSearch.setStyle(null);
            tfDeleteUserFirst.setText("");
            tfDeleteUserLast.setText("");
            tfDeleteUserPhone.setText("");
            tfDeleteUserEmail.setText("");
            tfDeleteUserID.setText("");
            comboDeleteUserClub.setValue(null);
            comboDeleteUserPermissions.setValue(null);
            tfDeleteUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }

    }

    /** EventHandler Method - Submit button **/
    @FXML
    void btnDeleteUserSubmitClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add information to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("DeleteUserFirstName", tfDeleteUserFirst.getText());
        dataToSubmit.put("DeleteUserLastName", tfDeleteUserLast.getText());
        dataToSubmit.put("DeleteUserPhone", tfDeleteUserPhone.getText());
        dataToSubmit.put("DeleteUserEmail", tfDeleteUserEmail.getText());
        dataToSubmit.put("DeleteUserClub", comboDeleteUserClub.getValue());
        dataToSubmit.put("DeleteUserPermission", comboDeleteUserPermissions.getValue());

        // Send data to the controller
        Controller.processRequest(RequestType.DELETE_USER, dataToSubmit);

        // Clear form and send user to previous page
        btnDeleteUserBackClicked(event);
    }

}
