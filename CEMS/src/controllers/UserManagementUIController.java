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

    public void checkMandatoryFields() {
        // Check the search field
        if (!InputValidation.validateNotEmpty(tfUserManagementSearch)) {
            tfUserManagementSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        } else {
            tfUserManagementSearch.setStyle(null);
        }
    }

    @FXML
    void btnUserMgmtCreateClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("CreateUserForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnUserMgmtDeleteClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("DeleteUserForm");
        defaultPane.setCenter(mainScreen);
    }

    @FXML
    void btnUserMgmtSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // Add data to the hashmap
        dataToSubmit = new HashMap<Object, Object>();
        dataToSubmit.put("UserManagementSearchEmail", tfUserManagementSearch.getText());

        // Send a query to the DB for the users email address
        dataToSubmit = Controller.processRequest(RequestType.SEARCH_FOR_USER, dataToSubmit);
//        System.out.println(dataToSubmit);

        // If found, return results in the correct fields
        User user = (User)dataToSubmit.get("User");

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
            tfUserManagementSearch.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
        }

//        // TEST DATA TO APPEAR ON SUBMIT
//        if (InputValidation.validateNotEmpty(tfUserManagementSearch)) {
//            textUserMgmtResultsNum.setText("1");
//            textUserMgmtName.setText("Erin");
//            textUserMgmtEmail.setText("erin@email.com");
//            textUserMgmtID.setText("023485212");
//            textUserMgmtPhone.setText("856-747-4534");
//            textUserMgmtClub.setText(OptionLists.getClubs()[1].getClubName());
//            textUserMgmtPermissions.setText(PermissionType.ADMIN.toString());
//        } else {
//            textUserMgmtResultsNum.setText("0");
//            textUserMgmtName.setText("(user name)");
//            textUserMgmtEmail.setText("(email)");
//            textUserMgmtID.setText("(student ID)");
//            textUserMgmtPhone.setText("(phone number)");
//            textUserMgmtClub.setText("(club name)");
//            textUserMgmtPermissions.setText("(permissions)");
//        }

    }

    @FXML
    void btnUserMgmtUpdateClicked(ActionEvent event) {
        Pane mainScreen = ViewBuilder.newScreen("UpdateUserForm");
        defaultPane.setCenter(mainScreen);
    }

}
