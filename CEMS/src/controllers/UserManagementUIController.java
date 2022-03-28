package CEMS.src.controllers;

import CEMS.src.application.InputValidation;
import CEMS.src.application.OptionLists;
import CEMS.src.application.PermissionType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class UserManagementUIController {

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
        // TODO: link to the Create a User form
    }

    @FXML
    void btnUserMgmtDeleteClicked(ActionEvent event) {
        // TODO: link to the Delete a User form
    }

    @FXML
    void btnUserMgmtSearchClicked(ActionEvent event) {
        checkMandatoryFields();

        // TODO: send a query to the DB for the users email address

        // TODO: If found, return results in the correct fields

        // TODO: If not found, display 0 results found

        // TEST DATA TO APPEAR ON SUBMIT
        textUserMgmtResultsNum.setText("1");
        textUserMgmtName.setText("Erin");
        textUserMgmtEmail.setText("erin@email.com");
        textUserMgmtID.setText("023485212");
        textUserMgmtPhone.setText("856-747-4534");
        textUserMgmtClub.setText(OptionLists.getClubs()[1]);
        textUserMgmtPermissions.setText(PermissionType.ADMIN.toString());
    }

    @FXML
    void btnUserMgmtUpdateClicked(ActionEvent event) {
        // TODO: link to the Update a User form
    }

}