package application;
import java.util.HashMap;

public class Controller {
	
	private static HashMap<Object, Object> dataToSend;
	private static String confirmation;
	
	
	public static void setConfirmation(String confirmationValue) {
		confirmation = confirmationValue;
	}
	
	public static String getConfirmation() {
		return confirmation;
	}
	
	public static Object[] getData(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		//calls DataBaseController to give back an array of stored objects
		
		return null;
	}
	
	public static void processRequest(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		
		switch(requestType) {
			case CREATE_CLUB:
				
			case CREATE_EMAIL:
				
			case CREATE_EVENT:
				
			case CREATE_USER:
				
			case LOGIN_USER:
				
			case SUBMIT_BUDGET:
				
			case SUBMIT_EXPENDITURE:  FormHandler.createExpenditureForm(requestType, dataToProcess);//call formHandler
										break;
			case GENERATE_BUDGET_REPORT:
				
			case GENERATE_CLUB_REPORT:
				
			case GENERATE_EVENT_REPORT:
				
			case GENERATE_EXPENDITURE_REPORT: //call reportHandler
												break;
			case DISPLAY_CALENDAR: //retrieve data
				break;
			default:
				break;
		
		}
		
	}
	

}
