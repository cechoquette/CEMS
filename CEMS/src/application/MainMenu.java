package application;
import java.beans.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainMenu {
	
	private MenuBar mainMenuBar;
	
	public MainMenu(){
		this.mainMenuBar = createMenu();
	}
	
	
	public MenuBar createMenu() {
		
		
	Menu menuTab1 = new Menu("File");
	
	MenuItem menuTab1Item1 = new MenuItem("Settings");
	MenuItem menuTab1Item2 = new MenuItem("Help");
	MenuItem menuTab1Item3 = new MenuItem("Restart");
	MenuItem menuTab1Item4 = new MenuItem("Exit");
	
	Menu menuTab2 = new Menu("Profile");
	MenuItem menuTab2Item1 = new MenuItem("View");
	MenuItem menuTab2Item2 = new MenuItem("Edit");
	MenuItem menuTab2Item3 = new MenuItem("Delete");
	MenuItem menuTab2Item4 = new MenuItem("Change Password");
	
	Menu menuTab3 = new Menu("Clubs");
	MenuItem menuTab3Item1 = new MenuItem("View");
	MenuItem menuTab3Item2 = new MenuItem("Create");
	MenuItem menuTab3Item3 = new MenuItem("Option 3");
	MenuItem menuTab3Item4 = new MenuItem("Option 4");
	
	Menu menuTab4 = new Menu("Events");
	MenuItem menuTab4Item1 = new MenuItem("View Calendar");
	MenuItem menuTab4Item2 = new MenuItem("Create");
	MenuItem menuTab4Item3 = new MenuItem("Edit");
	MenuItem menuTab4Item4 = new MenuItem("Email");

	Menu menuTab5 = new Menu("Reporting");
	MenuItem menuTab5Item1 = new MenuItem("Finance");
	MenuItem menuTab5Item2 = new MenuItem("Events");
	MenuItem menuTab5Item3 = new MenuItem("Clubs");
	
	
	menuTab1.getItems().addAll(menuTab1Item1, menuTab1Item2, menuTab1Item3, menuTab1Item4);
	menuTab2.getItems().addAll(menuTab2Item1, menuTab2Item2, menuTab2Item3, menuTab2Item4);
	menuTab3.getItems().addAll(menuTab3Item1, menuTab3Item2, menuTab3Item3, menuTab3Item4);
	menuTab4.getItems().addAll(menuTab4Item1, menuTab4Item2, menuTab4Item3, menuTab4Item4);
	menuTab5.getItems().addAll(menuTab5Item1, menuTab5Item2, menuTab5Item3);
	
	
	
	MenuBar mainMenu = new MenuBar(menuTab1, menuTab2, menuTab3, menuTab4, menuTab5);
	
	menuTab1Item1.setOnAction( e -> {
		if(menuTab2.getText().matches("Profile"))
		menuTab2.setText("This changed");
		else
			menuTab2.setText("Profile");
	});
	
	return mainMenu;
	
	}
	
}
