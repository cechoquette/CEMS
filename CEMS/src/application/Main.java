package application;
	
import java.io.File;
import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root;
//			root = FXMLLoader.load(getClass().getResource("ReportRequestForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("ClubBudgetSubmissionForm.fxml"));
			root = FXMLLoader.load(getClass().getResource("EventBudgetSubmissionForm.fxml"));
//			root = FXMLLoader.load(getClass().getResource("ExpenditureSubmissionForm.fxml"));

			
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
