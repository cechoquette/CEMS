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

    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfDeleteUserSearch)) {
            tfDeleteUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfDeleteUserSearch.setStyle(null);
        }
    }

    @FXML
    void btnDeleteUserBackClicked(ActionEvent event) {
        // Clear the fields
        btnDeleteUserCancelClicked(event);

        // TODO: return the user to the User Management page
    }

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

    @FXML
    void btnDeleteUserSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // TODO: send a query to the DB for the users email address

        // TODO: If found, return results in the correct fields

        // TODO: If not found, highlight the search bar red
//        tfUpdateUserSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");

        // TEST DATA TO APPEAR ON SUBMIT
        if (InputValidation.validateNotEmpty(tfDeleteUserSearch)) {
            tfDeleteUserFirst.setText("Erin");
            tfDeleteUserLast.setText("Cameron");
            tfDeleteUserPhone.setText("857-685-3453");
            tfDeleteUserEmail.setText("erin@email.com");
            tfDeleteUserID.setText("023485212");
            comboDeleteUserClub.setValue(OptionLists.getClubs()[1]);
            comboDeleteUserPermissions.setValue(PermissionType.ADMIN);
        } else {
            tfDeleteUserFirst.setText("");
            tfDeleteUserLast.setText("");
            tfDeleteUserPhone.setText("");
            tfDeleteUserEmail.setText("");
            tfDeleteUserID.setText("");
            comboDeleteUserClub.setValue(null);
            comboDeleteUserPermissions.setValue(null);
        }

    }

    @FXML
    void btnDeleteUserSubmitClicked(ActionEvent event) {
        // TODO: send query to the DB to remove the user from the DB

        // TODO: Add the user information to delete to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("", tfDeleteUserFirst.getText());
        dataToSubmit.put("", tfDeleteUserLast.getText());
        dataToSubmit.put("", tfDeleteUserPhone.getText());
        dataToSubmit.put("", tfDeleteUserEmail.getText());
        dataToSubmit.put("", tfDeleteUserID.getText());
        dataToSubmit.put("", comboDeleteUserClub.getValue());
        dataToSubmit.put("", comboDeleteUserPermissions.getValue());

        // Send data to the controller
        Controller.processRequest(RequestType.DELETE_USER, dataToSubmit);
    }

}
