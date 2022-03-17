package application;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InputValidation{

	public static boolean validateAmount(TextField tf) {
		
		try {
			
		}
		catch(NumberFormatException ex){
			
		}
		
		return false;
	}
	public static boolean validateDate(DatePicker dp) {
		return false;
	}
	public static boolean validateAccountNumber(TextField tf) {
		return false;
	}
	public static boolean validateText(TextField tf) {
		if(tf.getText() == "") return false;
		return true;
	}
	public static boolean validateInput(TextField tf) {
		return false;
	}
	public static boolean validateEmail(TextField tf) {
		
		
		return false;
	}
	

}
