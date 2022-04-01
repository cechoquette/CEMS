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

public class UpdateUserUIController {
    HashMap<Object, Object> dataToSubmit;

    @FXML
    private Button btnUpdateUserBack;

    @FXML
    private Button btnUpdateUserCancel1;

    @FXML
    private Button btnUpdateUserClear;

    @FXML
    private Button btnUpdateUserSearch;

    @FXML
    private Button btnUpdateUserSubmit;

    @FXML
    private ComboBox<Club> comboUpdateUserClub;

    @FXML
    private ComboBox<PermissionType> comboUpdateUserPermissions;

    @FXML
    private TextField tfUpdateUserSearch;

    @FXML
    private TextField tfUpdateUserEmail;

    @FXML
    private TextField tfUpdateUserFirst;

    @FXML
    private TextField tfUpdateUserID;

    @FXML
    private TextField tfUpdateUserLast;

    @FXML
    private TextField tfUpdateUserPhone;

    @FXML
    private BorderPane updateUserBorderPane;

    /** Initialize Method - sets fields on form on load **/
    @FXML
    public void initialize() {

        // Add the values to the Permissions dropdown
        comboUpdateUserPermissions.getItems().addAll(Arrays.asList(PermissionType.values()));

        // Add the values to the Clubs dropdown

//        comboUpdateUserClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));//use for testing only
        comboUpdateUserClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));

        // Set all TextFields to have non-editable styling
        tfUpdateUserFirst.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserLast.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserPhone.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserEmail.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserID.setStyle("-fx-control-inner-background: #cce0ff");
        comboUpdateUserClub.setStyle("-fx-control-inner-background: #cce0ff");
    }

    /** Method to check that all mandatory fields have been filled **/
    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfUpdateUserSearch)) {
            tfUpdateUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfUpdateUserSearch.setStyle(null);
        }
    }

    /** EventHandler Method - Back button **/
    @FXML
    void btnUpdateUserBackClicked(ActionEvent event) {
        // Clear the fields
        btnUpdateUserCancelClicked(event);

        // Return the user to the User Management page
        Pane mainScreen = ViewBuilder.newScreen("UserManagement");
        defaultPane.setCenter(mainScreen);

    }

    /** EventHandler Method - Cancel button **/
    @FXML
    void btnUpdateUserCancelClicked(ActionEvent event) {
        // Clear the fields
        tfUpdateUserSearch.setText("");
        tfUpdateUserSearch.setStyle(null);
        tfUpdateUserFirst.setText("");
        tfUpdateUserLast.setText("");
        tfUpdateUserPhone.setText("");
        tfUpdateUserEmail.setText("");
        tfUpdateUserID.setText("");
        comboUpdateUserClub.setValue(null);
        comboUpdateUserPermissions.setValue(null);
        comboUpdateUserPermissions.setStyle(null);

        // TODO: return the user to the User Management page

    }

    /** EventHandler Method - Search button **/
    @FXML
    void btnUpdateUserSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add data to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("UpdateUserPermissionSearchEmail", tfUpdateUserSearch.getText());

        // Send a query to the DB for the users email address
        HashMap<Object, Object> hm;
        hm = Controller.processRequest(RequestType.SEARCH_FOR_USER_UPDATE, dataToSubmit);

        User user = (User)hm.get("User");

        if (user != null) {
            System.out.println(user.getEmail() + "is not null");
            tfUpdateUserFirst.setText(user.getFirstName());
            tfUpdateUserLast.setText(user.getLastName());
            tfUpdateUserID.setText(String.valueOf(user.getStudentID()));
            tfUpdateUserEmail.setText(user.getEmail());
            tfUpdateUserPhone.setText(user.getPhone());
            comboUpdateUserClub.setValue(user.getUserClub());
            if (user.getPermission().equals(PermissionType.ADMIN.toString())) {
                comboUpdateUserPermissions.setValue(PermissionType.ADMIN);
                comboUpdateUserPermissions.setVisible(true);
            }
            if (user.getPermission().equals(PermissionType.ADMIN_PLUS.toString())) {
                comboUpdateUserPermissions.setValue(PermissionType.ADMIN_PLUS);
            }
            if (user.getPermission().equals(PermissionType.SUPER_ADMIN.toString())) {
                comboUpdateUserPermissions.setValue(PermissionType.SUPER_ADMIN);
            }
        } else {
            tfUpdateUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }
    }

    /** EventHandler Method - Submit button **/
    @FXML
    void btnUpdateUserSubmitClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add the permission update to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("UpdateUserPermission", comboUpdateUserPermissions.getValue());

        // Send data to the controller
        Controller.processRequest(RequestType.MODIFY_USER_PERMISSION, dataToSubmit);

        btnUpdateUserCancelClicked(event);
    }

}
