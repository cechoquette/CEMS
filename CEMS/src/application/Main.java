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
	public static User CURRENTUSER;
	public static Club ALLCLUBS = new Club("All Clubs", "This is the club for all SuperAdmins.");
	public static BorderPane defaultPane = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		try {
			ClubMember fakeClubMember = new ClubMember(232545245, "Bob", "Joe", "bobjoe@algomau.ca", ALLCLUBS);
//			ReportHandler.createSamplePDF("TestPDF");
//			ReportHandler.exportToExcel("TestExcel");

			//Create Database (if first time running app)

			//Create Clubs if Database empty
				//Maybe make a method for this in Club class called createFirstClubs() and send to Database. Or RequestType.
			//if doesn't already exist in Database, create:

			//add ALLCLUBS Club to database


			//Retrieve and populate class static IDs from Database
				//Club, User, Event, Expenditure, EventBudget, ClubBudget
				//Ex
				ClubEvent.setCountForIds(25);
				//User.setCountForIds();//this one is different, UserId is student number. So no static count required??
				Expenditure.setCountForIds(25);
	//			EventBudget

			//Initialize User currentUser during login


			//for Paths: use absolute paths (leading / ) and do note use .. , the resulting .jar executable will not function.
			/* Keeping this code segnment in case anyone needs to test individual fxml pages*/
//			Parent root;
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ClubBudgetSubmissionForm.fxml"));
//			Scene scene = new Scene(root, 900, 575);

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

		
		
//		try {
//			ReportHandler.exportToExcel();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
