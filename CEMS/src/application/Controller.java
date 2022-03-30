package CEMS.src.application;
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
			ClubDAO clubDao1 = new ClubDAO();
			clubDao1.saveClub(FormHandler.createClubForm(requestType, dataToProcess));
			break;
		case CREATE_CLUB_MEMBER:
			break;
		case CREATE_EMAIL:
			break;
		case CREATE_EVENT:
			break;
		case CREATE_USER:
			//UserDAO userDao1 = new UserDAO();
			//userDao1.saveUser(FormHandler.createUserForm(requestType, dataToProcess));

			break;
		case DELETE_CLUB:
			//needs to call the database

			break;
		case DELETE_EVENT:
			//needs to call the database

			break;
		case DELETE_FROM_DATABASE:
			break;
		case DELETE_USER:
			//needs to call the database

			break;
		case DISPLAY_CALENDAR:
			break;
		case GENERATE_REPORT:

			//send to ReportHandler for creation
			try {
				ReportHandler.generateReport(dataToProcess);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
//		case GENERATE_BUDGET_REPORT:
//			break;
//		case GENERATE_CLUB_REPORT:
//			break;
//		case GENERATE_EVENT_REPORT:
//			break;
//		case GENERATE_EXPENDITURE_REPORT:
//			break;
		case LOGIN_USER:
			break;
		case MODIFY_CLUB://No
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
		case SUBMIT_CLUB_BUDGET:

			sendToDatabase(FormHandler.createClubBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EVENT_BUDGET:
			DAO dao2 = new DAO();
//			dao2.saveEventBudget(FormHandler.createEventBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EXPENDITURE:
			DAO dao1 = new DAO();
//			dao1.saveExpenditure(FormHandler.createExpenditureForm(requestType, dataToProcess));
			break;
		case SEARCH_FOR_USER: //call database, return if found
			break;
		case UPDATE_CLUB_MEMBER:
			FormHandler.updateClubMemberForm(requestType, dataToProcess);
				break;
			
		default: //do nothing
			break;
		
		}
		
	}
	

}
