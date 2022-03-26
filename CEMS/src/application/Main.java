package CEMS.src.application;//package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			//for Paths: use absolute paths (leading / ) and do note use .. , the resulting .jar executable will not function.
			Parent root;
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ClubBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/CreateEventForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/CreateUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/DeleteUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/EventBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ExpenditureSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ForgotPassword.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/HomePage.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/LoginPage.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ProfilePage.fxml"));
			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/ReportRequestForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/RequestAccessForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/UpdateUserForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("/CEMS/src/resources/fxml/UserManagement.fxml"));


			Scene scene = new Scene(root);
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
