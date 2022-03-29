package CEMS.src.application;//package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	//do not delete, global User for session. Initialize in Start.
	public User currentUser;
	public static BorderPane defaultPane = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		try {

			//Create Database (if first time running app)

			//Create Clubs if Database empty
				//Maybe make a method for this in Club class called createFirstClubs() and send to Database. Or RequestType.

			//Retrieve and populate class static IDs from Database
				//Club, User, Event, Expenditure, EventBudget, ClubBudget
				//Ex
				Event.setCountForIds(25);
				//User.setCountForIds();//this one is different, UserId is student number. So no static count required??
				Expenditure.setCOUNT_FOR_IDS(25);
	//			EventBudget

			//Initialize User currentUser during login


			//for Paths: use absolute paths (leading / ) and do note use .. , the resulting .jar executable will not function.
			//Parent root;
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ClubBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/CreateEventForm.fxml"));
			//root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/CreateUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/DeleteUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/EventBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ExpenditureSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ForgotPassword.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/HomePage.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/LoginPage.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ProfilePage.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ReportRequestForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/RequestAccessForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/UpdateUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/UserManagement.fxml"));

			ViewBuilder object = new ViewBuilder();

			Pane defaultMenu = ViewBuilder.newScreen("LoginMenuBar");
			Pane defaultScreen = ViewBuilder.newScreen("HomePage");
			defaultPane.setTop(defaultMenu);
			defaultPane.setCenter(defaultScreen);

			Scene scene = new Scene (defaultPane, 900, 625);

			//Scene scene = new Scene(root);
			ReportHandler.exportToExcel();
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

		
		
//		try {
//			ReportHandler.exportToExcel();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
