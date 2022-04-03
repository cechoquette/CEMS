package CEMS.src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ClubProfileUIController {

    @FXML
    private Button btnClubProfileEdit;

    @FXML
    private ImageView imgClubProfilePicture;

    @FXML
    private TextArea taClubProfileDescription;

    @FXML
    private Text textClubDateCreated;

    @FXML
    private Text textClubMemberNum;

    @FXML
    private Text textClubProfileName;

    @FXML
    public void initialize(){
        System.out.println();
    }

    @FXML
    void btnClubProfileEditClicked(ActionEvent event) {

    }

}
