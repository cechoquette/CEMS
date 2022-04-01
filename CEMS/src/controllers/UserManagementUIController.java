package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.HashMap;

import static CEMS.src.application.Main.defaultPane;

public class UserManagementUIController {
    HashMap<Object, Object> dataToSubmit;

    @FXML
    private TextField tfUserManagementSearch;

    @FXML
    private AnchorPane apUserMgmtResults;

    @FXML
    private Button btnUserMgmtCreate;

    @FXML
    private Button btnUserMgmtDelete;

    @FXML
    private Button btnUserMgmtSearch;

    @FXML
    private Button btnUserMgmtUpdate;

    @FXML
    private Text textUserMgmtClub;

    @FXML
    private Text textUserMgmtEmail;

    @FXML
    private Text textUserMgmtID;

    @FXML
    private Text textUserMgmtName;

    @FXML
    private Text textUserMgmtPermissions;

    @FXML
    private Text textUserMgmtPhone;

    @FXML
    private Text textUserMgmtResultsNum;

    /** Method to check that all mandatory fields are filled in **/
    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfUserManagementSearch)) {
            tfUserManagementSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfUserManagementSearch.setStyle(null);
        }
    }

    /** EventHandler Method - Create User button **/
    @FXML
    void btnUserMgmtCreateClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("CreateUserForm");
        defaultPane.setCenter(mainScreen);
    }

    /** EventHandler Method - Delete User button **/
    @FXML
    void btnUserMgmtDeleteClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("DeleteUserForm");
        defaultPane.setCenter(mainScreen);
    }

    /** EventHandler Method - Search button **/
    @FXML
    void btnUserMgmtSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add data to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("UserManagementSearchEmail", tfUserManagementSearch.getText());

        // Send a query to the DB for the users email address
        HashMap<Object, Object> hm;
        hm = Controller.processRequest(RequestType.SEARCH_FOR_USER_USERMGMT, dataToSubmit);

        // If found, return results in the correct fields
        User user = (User)hm.get("User");

        // If found, return results in the correct fields
        if (user != null) {
            textUserMgmtResultsNum.setText("1");
            textUserMgmtName.setText(user.getFirstName() + " " + user.getLastName());
            textUserMgmtClub.setText(user.getUserClub().toString());
            textUserMgmtEmail.setText(user.getEmail());
            textUserMgmtID.setText(String.valueOf(user.getStudentID()));
            textUserMgmtPhone.setText(user.getPhone());
            textUserMgmtPermissions.setText(user.getPermission());
        } else {
            // If not found, display 0 results found and error state
            textUserMgmtResultsNum.setText("0");
            textUserMgmtName.setText("(user name)");
            textUserMgmtClub.setText("(club name)");
            textUserMgmtEmail.setText("(email)");
            textUserMgmtID.setText("(student ID)");
            textUserMgmtPhone.setText("(phone)");
            textUserMgmtPermissions.setText("(permissions)");
            tfUserManagementSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }

    }

    /** EventHandler Method - Update User button **/
    @FXML
    void btnUserMgmtUpdateClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("UpdateUserForm");
        defaultPane.setCenter(mainScreen);
    }

}
