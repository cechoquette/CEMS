package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root;
//			root = FXMLLoader.load(getClass().getResource("ReportRequestForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("ClubBudgetSubmissionForm.fxml"));
<<<<<<< HEAD
//			root = FXMLLoader.load(getClass().getResource("EventBudgetSubmissionForm.fxml"));
			root = FXMLLoader.load(getClass().getResource("ExpenditureSubmissionForm.fxml"));
=======
			root = FXMLLoader.load(getClass().getResource("../../resources/fxml/EventBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("ExpenditureSubmissionForm.fxml"));

>>>>>>> 89c16bd01b72621b61b959e633bc7aeeae44f68d
			
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
