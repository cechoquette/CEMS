package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.util.Arrays;
import java.util.HashMap;

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

    @FXML
    public void initialize() {
        // TODO: Add menu - first, add label in the FXML document
        updateUserBorderPane.setTop(new MainMenu().createMenu());

        // Add the values to the Permissions dropdown
        comboUpdateUserPermissions.getItems().addAll(Arrays.asList(PermissionType.values()));

        // Add the values to the Clubs dropdown
        comboUpdateUserClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));

        // Set all TextFields to have non-editable styling
        tfUpdateUserFirst.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserLast.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserPhone.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserEmail.setStyle("-fx-control-inner-background: #cce0ff");
        tfUpdateUserID.setStyle("-fx-control-inner-background: #cce0ff");
        comboUpdateUserClub.setStyle("-fx-control-inner-background: #cce0ff");
    }

    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfUpdateUserSearch)) {
            tfUpdateUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfUpdateUserSearch.setStyle(null);
        }
    }

    @FXML
    void btnUpdateUserBackClicked(ActionEvent event) {
        // Clear the fields
        btnUpdateUserCancelClicked(event);

        // TODO: Return the user to the User Management page

    }

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

    @FXML
    void btnUpdateUserSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // TODO: send a query to the DB for the users email address

        // TODO: If found, return results in the correct textfields

        // TODO: If not found, highlight the search bar red
//        tfUpdateUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");

        // TEST DATA TO APPEAR ON SUBMIT
        tfUpdateUserFirst.setText("Erin");
        tfUpdateUserLast.setText("Cameron");
        tfUpdateUserPhone.setText("857-685-3453");
        tfUpdateUserEmail.setText("erin@email.com");
        tfUpdateUserID.setText("023485212");
        comboUpdateUserClub.setValue(OptionLists.getClubs()[1]);
        comboUpdateUserPermissions.setValue(PermissionType.ADMIN);

    }

    @FXML
    void btnUpdateUserSubmitClicked(ActionEvent event) {

        // TODO: Add the permission update to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("", comboUpdateUserPermissions.getValue());

        // Send data to the controller
        Controller.processRequest(RequestType.MODIFY_USER, dataToSubmit);
    }

}
