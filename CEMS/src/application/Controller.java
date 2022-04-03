package CEMS.src.application;
import CEMS.src.controllers.LoginPageUIController;
import com.mysql.cj.log.Log;

import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public static HashMap<Object, Object> processRequest(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		
		switch(requestType) {
		case CHECK_FOR_EVENTS:
			DAO dao21 = new DAO();
			Timeframe timeframe = (Timeframe)dataToProcess.get("Timeframe");
			//Code for calling the Database
//			Boolean isThereAnEvent = dao21.getClubEvent(timeframe) == null? false: true;
//			dataToProcess.put("CheckForEvent", isThereAnEvent);


			//This code is For Luke's CalendarUIController -->
//			LocalDate date = LocalDate.of(2022, 3, 25);//Comment//assume this is taken from a field
//			Timeframe timeframe = new Timeframe(date, date);//Comment//for a single day, give the same day twice
//
//			HashMap<Object, Object> dataToSend = new HashMap<Object, Object>();
//			dataToSend.put("Timeframe", timeframe);//Comment//Use this specific key
//			//Comment//Use this Boolean for your method. ex. if(checkForEvent) { //put a little dot };
//			Boolean checkForEvent = (Boolean)Controller.processRequest(RequestType.CHECK_FOR_EVENTS, dataToSend).get("CheckForEvent");

				break;
		case GET_EVENT_BY_ID:
			DAO lostcount = new DAO();
			ClubEvent clubEvent = lostcount.getClubEvent((Integer)dataToProcess.get("EventID"));
			dataToProcess.put("ClubEvent", clubEvent);
			break;
		case GET_EVENTS:
			DAO dao22 = new DAO();
			Timeframe timeframe2 = (Timeframe)dataToProcess.get("Timeframe");
//			Code for calling the Database
			LocalDateTime start = (LocalDateTime)dataToProcess.get("StartDate");
			LocalDateTime end = (LocalDateTime)dataToProcess.get("EndDate");
			Club clubtoget = (Club)dataToProcess.get("CalendarClubAffiliation");
			ArrayList<ClubEvent> clubEvents = (ArrayList<ClubEvent>) dao22.getClubEventByDateAndClub(start, end, clubtoget.getClubName());
			dataToProcess.put("MonthlyEvents", clubEvents);


//			//This code is For Luke's CalendarUIController --> Not ready
//			LocalDate startDate = LocalDate.of(2022, 3, 25);//Comment//assume this is taken from a field
//			LocalDate endDate = LocalDate.of(2022, 3, 25);//Comment//assume this is taken from a field
//			Timeframe timeframe3 = new Timeframe(date, date);//Comment//for a single day, give the same day twice
//
//			HashMap<Object, Object> dataToSend = new HashMap<Object, Object>();
//			dataToSend.put("Timeframe", timeframe3);//Comment//Use this specific key
//			//Comment//Use this Boolean for your method. ex. if(checkForEvent) { //put a little dot };
//			Boolean checkForEvent = (Boolean)Controller.processRequest(RequestType.CHECK_FOR_EVENTS, dataToSend).get("CheckForEvent");
//			ArrayList<ClubEvent> dailyEvents = (ArrayList<ClubEvent>)Controller.processRequest(RequestType.GET_EVENTS, hashmap).get("DailyEvents");
				break;

		case CREATE_CLUB:
			DAO dao1 = new DAO();
			dao1.addClub(FormHandler.createClubForm(requestType, dataToProcess));
			break;

		case SEND_EVENT_EMAIL:
			//Not a DAO task

			//call MailUtil
			try {
				MailUtil.sendNewEvent(dataToProcess);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case SEND_UPDATE_EMAIL:
			//Not a DAO task

			//call MailUtil
			try {
				MailUtil.sendEventUpdate(dataToProcess);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case SEND_REQUEST_ACCESS:
			//Not a DAO task

			//call MailUtil
			try {
				MailUtil.sendRequestAccess(dataToProcess);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case CREATE_EVENT:
			DAO dao3 = new DAO();
			ClubEvent clubEvent2 = FormHandler.createClubEventForm(requestType, dataToProcess);
			dao3.addClubEvent(clubEvent2);
			dataToProcess.put("ClubEvent", clubEvent2);
			break;
		case CREATE_USER:
			DAO dao4 = new DAO();

			dao4.addUser(FormHandler.createUserForm(requestType, dataToProcess));

			break;
		case DELETE_CLUB://method doesn't exist
			//Not a FormHandler task
			DAO dao5 = new DAO();
//			dao5.deleteClub(((Club)dataToProcess.get("Club")).getClubID());
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
		case GENERATE_REPORT://ReportHandler calls its own DAO methods

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
			FormHandler.createLoginForm(requestType, dataToProcess);
			break;
		case GET_USER: // get user based on email address for logins
			DAO dao18 = new DAO();
			User currentUser = dao18.getUser((String)dataToProcess.get("LoginUserEmail"));
			PasswordUtil.setCurrentUser(currentUser);
			break;
		case GET_USER_FORGOT_PASS: // get user based on email address for logins
			DAO dao28 = new DAO();
			User forgotUser = dao28.getUser((String)dataToProcess.get("ForgotPasswordEmail"));
			PasswordUtil.setCurrentUser(forgotUser);
			break;
		case GET_USER_UPDATE_USER: // get user based on email address for logins
			DAO dao31 = new DAO();
			User updateUser = dao31.getUser((String)dataToProcess.get("UpdateUserEmail"));
			if(updateUser != null) {
				dataToProcess.put("User", updateUser);
			}//this could end up being null, do a null check on the receiving end
			break;
		case SEARCH_FOR_USER: //call database, return if found
			DAO dao24 = new DAO();
			User userSearch = dao24.getUser(((String)dataToProcess.get("DeleteSearchEmail")));//Changed this. DAO takes a String email.
			if(userSearch != null){
				dataToProcess.put("User", userSearch);
			}//this could end up being null, do a null check on the receiving end
			break;
		case SEARCH_FOR_USER_USERMGMT: //call database, return if found
			DAO dao26 = new DAO();
			User userMgmtSearch = dao26.getUser(((String)dataToProcess.get("UserManagementSearchEmail")));//Changed this. DAO takes a String email.
			if(userMgmtSearch != null){
				dataToProcess.put("User", userMgmtSearch);
			}//this could end up being null, do a null check on the receiving end
			break;
		case SEARCH_FOR_USER_UPDATE: //call database, return if found
			DAO dao27 = new DAO();
			User userUpdateSearch = dao27.getUser(((String)dataToProcess.get("UpdateUserPermissionSearchEmail")));//Changed this. DAO takes a String email.
			if(userUpdateSearch != null){
				dataToProcess.put("User", userUpdateSearch);
			}//this could end up being null, do a null check on the receiving end
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
			System.out.println((ClubEvent)dataToProcess.get("ClubEvent") + " Controller line 231");
			break;
		case MODIFY_USER: // Updating users details
			DAO dao10 = new DAO();
			FormHandler.updateUserForm(requestType, dataToProcess);
			dao10.updateUser(Main.CURRENTUSER);
			break;
		case MODIFY_USER_PERMISSION: // Updating a users permissions (SuperAdmin only)
			DAO dao19 = new DAO();
			FormHandler.updateUserPermissionForm(requestType, dataToProcess);
			dao19.updateUser((User)dataToProcess.get("User")); // modify the user searched for's permission
			break;
		case PASSWORD_RESET:
			DAO dao25 = new DAO();
			FormHandler.updatePasswordResetForm(requestType, dataToProcess);
			dao25.updateUser(Main.CURRENTUSER);
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
			System.out.println("Yes Controller");
			DAO dao13 = new DAO();
			Expenditure expenditure = FormHandler.createExpenditureForm(requestType, dataToProcess);
//			dao13.addExpenditure(FormHandler.createExpenditureForm(requestType, dataToProcess));
			dao13.addExpenditure(expenditure);
			System.out.println(expenditure + " Printing from Controller");
			break;
			

		default: //do nothing
			break;
		
		}


		return dataToProcess;
		
	}
	

}
