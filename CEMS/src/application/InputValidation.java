package CEMS.src.application;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class InputValidation{

	public static boolean validateAmount(TextField tf) {
		try {
			Double.parseDouble(tf.getText());
			return true;
		}
		catch(NumberFormatException ex){
			System.out.println(tf.getText());
			return false;
		}
	}

//	public static boolean validateAmount(String text) {
//		try {
//			Double.parseDouble(text);
//			return true;
//		}
//		catch(NumberFormatException ex){
//			System.out.println(text);
//			return false;
//		}
//	}

	public static boolean validateDate(DatePicker dp) {
		if(dp.getValue() != null){
			return dp.getValue() instanceof LocalDate;
		}
		return false;
	}
	public static boolean validateAccountNumber(TextField tf) {//checks for all digits. no length requirement
		if(tf.getText().equals("")) {
			String number = tf.getText();

			for(int i = 0; i<number.length(); i++){
				if (!Character.isDigit(number.charAt(i))){
					return false;
				}

			}
			return true;
		}else {
			return false;
		}

	}
	public static boolean validateNotEmpty(TextField tf) {
		if(tf.getText().equals("")){
			return false;
		}
		return true;
	}

	public static boolean validateComboNotEmpty(ComboBox cb) {
		if(cb.getValue() == null) {
			return false;
		}
		return true;
	}

	public static boolean validateSecurity(TextField tf) {
		if(validateNotEmpty(tf)) {
			String security = tf.getText();

			// Security Answer must be greater than 4 characters
			if (security.length() > 4) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateInput(TextField tf) {
		return false;
	}

	public static boolean validatePassword(TextField tf) {
		// Check that the password has at least 7 characters
		if(validateNotEmpty(tf)) {
			String password = tf.getText();

			if (password.length() > 6) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateStudentID(TextField tf) {
		// Check that the field is not empty
		if(validateNotEmpty(tf)) {
			String studentID = tf.getText();

			// Check that the StudentID is 9 digits long
			if (studentID.length() == 9
					&& Character.isDigit(studentID.charAt(0))
					&& Character.isDigit(studentID.charAt(1))
					&& Character.isDigit(studentID.charAt(2))
					&& Character.isDigit(studentID.charAt(3))
					&& Character.isDigit(studentID.charAt(4))
					&& Character.isDigit(studentID.charAt(5))
					&& Character.isDigit(studentID.charAt(6))
					&& Character.isDigit(studentID.charAt(7))
					&& Character.isDigit(studentID.charAt(8))) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateEmail(TextField tf) {//using regex pattern
		if(validateNotEmpty(tf)){
			String email = tf.getText();
			String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
					+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			return Pattern.compile(regexPattern).matcher(email).matches();
		}


		return false;
	}
//
//	public static boolean validatePhoneNumber(TextField tf){
//		if(validateNotEmpty(tf)){
//		String phone = tf.getText();
//		String regexPattern = "^(\(?\s*\d{3}\s*[\)–\.]?\s*)?[2-9]\d{2}\s*[–\.]\s*\d{4}$";
//
//
//		}
//	}

	//Pass a tf. Expected format is DDD-DDD-DDDD
	public static boolean validatePhone(TextField tf){
		if(InputValidation.validateNotEmpty(tf)) {
			String number = tf.getText();

			if (number.length() == 12)
			{
				if (number.charAt(3) == 45 && number.charAt(7) == 45) //45 is ascii for hyphen
				{
					if (Character.isDigit(number.charAt(0)) &&
							Character.isDigit(number.charAt(1)) &&
							Character.isDigit(number.charAt(2)) &&
							Character.isDigit(number.charAt(4)) &&
							Character.isDigit(number.charAt(5)) &&
							Character.isDigit(number.charAt(6)) &&
							Character.isDigit(number.charAt(8)) &&
							Character.isDigit(number.charAt(9)) &&
							Character.isDigit(number.charAt(10)) &&
							Character.isDigit(number.charAt(11)))
					{
						return true;
					}
					else
					{
						System.out.println("not a digit -");
						return false;
					}
				}
				else
				{
					System.out.println("not a hyphen -");
					return false;
				}
			}
			else
			{
				System.out.println("length wrong -");
				return false;
			}
		}
		else {
			System.out.println("empty string -");
			return false;
		}
	}


}
