package CEMS.src.application;//package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
	//do not delete, global User for session. Initialize in Start.
	public static User CURRENTUSER;
	public static Club ALLCLUBS = new Club("All Clubs", "This is the club for all SuperAdmins.");
	public static BorderPane defaultPane = new BorderPane();



	@Override
	public void start(Stage primaryStage) {
		try { DatabaseRunner.setUPDB();

			/* For setting ID COUNT_FOR_IDS - Do not delete*/
			DAO daoID = new DAO();
			int clubID = (daoID.maxClubId() == null) ? 0 : daoID.maxClubId();
			int clubEventID = (daoID.maxClubEventId() == null) ? 0 : daoID.maxClubEventId();
			int clubBudgetID = (daoID.maxClubBudgetId() == null) ? 0 : daoID.maxClubBudgetId();
			int clubEventBudgetID = (daoID.maxClubEventBudget() == null) ? 0 : daoID.maxClubEventBudget();
			int expenditureID = (daoID.maxExpenditureID() == null) ? 0 : daoID.maxExpenditureID();

			Club.COUNT_FOR_IDS = clubID;
			ClubEvent.COUNT_FOR_IDS = clubEventID;
			ClubBudget.COUNT_FOR_IDS = clubBudgetID;
			ClubEventBudget.COUNT_FOR_IDS = clubEventBudgetID;
			Expenditure.COUNT_FOR_IDS = expenditureID;
			//************************************************











			//for Paths: use absolute paths (leading / ) and do note use .. , the resulting .jar executable will not function.

			/* Keeping this code segment in case anyone needs to test individual fxml pages*/

//			Parent root;
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ExpenditureSubmissionForm.fxml"));
//			Scene scene = new Scene(root, 900, 625);

			Pane defaultMenu = ViewBuilder.newScreen("LoginMenuBar");
			Pane defaultMain = ViewBuilder.newScreen("LoginPage");

			defaultPane.setTop(defaultMenu);
			defaultPane.setCenter(defaultMain);

			Scene scene = new Scene(defaultPane, 900, 625);

			primaryStage.setTitle("CEMS");
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
