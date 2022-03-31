package CEMS.src.application;
import java.security.NoSuchProviderException;
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
			DAO dao1 = new DAO();
			dao1.addClub(FormHandler.createClubForm(requestType, dataToProcess));
			break;
		case CREATE_CLUB_MEMBER:
			DAO dao2 = new DAO();
//			dao2.addClubMember(FormHandler.createClubMemberForm(requestType, dataToProcess));
			break;
		case CREATE_EMAIL:
			//Not a DAO task
			break;
		case CREATE_EVENT:
			DAO dao3 = new DAO();
			dao3.addClubEvent(FormHandler.createClubEventForm(requestType, dataToProcess));
			break;
		case CREATE_USER:
			DAO dao4 = new DAO();
			dao4.addUser(FormHandler.createUserForm(requestType, dataToProcess));

			break;
		case DELETE_CLUB:
			//Not a FormHandler task
			DAO dao5 = new DAO();
//			dao5.deleteClub(((Club)dataToProcess.get("Club")).getClubID());
			break;
		case DELETE_CLUB_MEMBER:
			DAO dao15 = new DAO();
			dao15.deleteClubMember(((ClubMember)dataToProcess.get("ClubMember")).getStudentID());
			break;
		case DELETE_EVENT:
			//needs to call the database
			DAO dao6 = new DAO();
			dao6.deleteClubEvent(((ClubEvent)dataToProcess.get("ClubEvent")).getEventID());
			break;
		case DELETE_FROM_DATABASE:
			break;
		case DELETE_USER:
			//needs to call the database
			DAO dao7 = new DAO();
			dao7.deleteUser(((User)dataToProcess.get("User")).getStudentID());
			break;
		case DISPLAY_CALENDAR:
			//remove
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
		case GET_CLUB_MEMBER:
			DAO dao16 = new DAO();
//			dao16.getClubMember()
			break;
		case LOGIN_USER:
			FormHandler.createLoginForm(requestType, dataToProcess);
			break;
		case GET_USER: // get user based on email address for logins
			DAO dao18 = new DAO();
			dao18.getUser(((String)dataToProcess.get("UserEmail")));//Changed this. DAO takes a String email.
			break;
		case MODIFY_CLUB:
			DAO dao8 = new DAO();
			FormHandler.updateClubForm(requestType, dataToProcess);
			dao8.updateClub((Club)dataToProcess.get("Club"));
			break;
		case MODIFY_EVENT:
			DAO dao9 = new DAO();
			FormHandler.updateClubEventForm(requestType, dataToProcess);
			dao9.updateClubEvent((ClubEvent)dataToProcess.get("ClubEvent"));
			break;
		case MODIFY_USER: // Updating users details
			DAO dao10 = new DAO();
			FormHandler.updateUserForm(requestType, dataToProcess);
			dao10.updateUser(Main.CURRENTUSER);
			break;
		case MODIFY_USER_PERMISSION: // Updating a users permissions (SuperAdmin only)
			DAO dao19 = new DAO();
			FormHandler.updateUserPermissionForm(requestType, dataToProcess);
			dao19.updateUser(Main.CURRENTUSER);
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
			DAO dao11 = new DAO();
			dao11.addClubBudget(FormHandler.createClubBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EVENT_BUDGET:
			DAO dao12 = new DAO();
			dao12.addClubEventBudget(FormHandler.createEventBudgetForm(requestType, dataToProcess));
			break;
		case SUBMIT_EXPENDITURE:
			DAO dao13 = new DAO();
			dao13.addExpenditure(FormHandler.createExpenditureForm(requestType, dataToProcess));
			break;
		case SEARCH_FOR_USER: //call database, return if found
			DAO dao20 = new DAO();
//			dao20.getUser();
			break;
		case UPDATE_CLUB_MEMBER:
			DAO dao14 = new DAO();
			FormHandler.updateClubMemberForm(requestType, dataToProcess);
//			dao14.updateClubMember((ClubMember)dataToProcess.get("ClubMember"));
			break;
			
		default: //do nothing
			break;
		
		}
		
	}
	

}
