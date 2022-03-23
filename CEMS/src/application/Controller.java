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
	
	public static HashMap<Object, Object> getData(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		//calls DataBaseController to give back an array of stored objects
		
		return null;
	}
	
	public static HashMap<Object, Object> getData(RequestType requestType) {
		//calls DataBaseController to give back an array of stored objects
		
		return null;
	}
	
	public static void sendToDatabase(Object objToSend) {
		//call database controller
	}
	
	public static void processRequest(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		
		switch(requestType) {
		case CREATE_CLUB:
			break;
		case CREATE_CLUB_MEMBER:
			break;
		case CREATE_EMAIL:
			break;
		case CREATE_EVENT:
			break;
		case CREATE_USER:
			break;
		case DELETE_CLUB:
			break;
		case DELETE_EVENT:
			break;
		case DELETE_FROM_DATABASE:
			break;
		case DELETE_USER:
			break;
		case DISPLAY_CALENDAR:
			break;
		case GENERATE_REPORT: ReportHandler.generateReport(dataToProcess);
			break;
		case GENERATE_BUDGET_REPORT:
			break;
		case GENERATE_CLUB_REPORT:
			break;
		case GENERATE_EVENT_REPORT:
			break;
		case GENERATE_EXPENDITURE_REPORT: 
			break;
		case LOGIN_USER:
			break;
		case MODIFY_CLUB:
			break;
		case MODIFY_EVENT:
			break;
		case MODIFY_USER:
			break;
		case PASSWORD_RESET:
			break;
		case PASSWORD_RETRIEVE:
			break;
		case QUERY_DATABASE:
			break;
		case REQUEST_DATA_FROM_DATABASE:
			break;
		case STORE_DATA_IN_DATABASE:
			break;
		case SUBMIT_CLUB_BUDGET: sendToDatabase(FormHandler.createClubBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EVENT_BUDGET: sendToDatabase(FormHandler.createEventBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EXPENDITURE: sendToDatabase(FormHandler.createExpenditureForm(requestType, dataToProcess));
			break;
			
		default:
			break;
		
		}
		
	}
	

}
