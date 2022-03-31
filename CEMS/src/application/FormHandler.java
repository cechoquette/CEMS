package CEMS.src.application;

import java.security.NoSuchProviderException;
import java.util.HashMap;

/*
 * Class is responsible for;
 * creating Forms which will process incoming Data
 * 2-way communication with Forms
 * 2-way communication with Controller
 * No getData method. Data, including objects for update() methods will be added to the HashMaps from the Controller. Keys will be like "User" or "ClubMember".
 * Do not call DAO from FormHandler
 */

public class FormHandler {
	static HashMap<Object, Object> dataRequested;
	static HashMap<Object, Object> dataToSend;
	static ClubEvent clubEvent;
	static Expenditure expenditure;
	static ClubEventBudget clubEventBudget;
	static ClubBudget clubBudget;
	static Club club;
	static User user;
	static ClubMember clubMember;
//	Email email;
//	LoginSession loginSession;




////// CREATION

	public static Expenditure createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ExpenditureForm expenditureForm = new ExpenditureForm(requestType, hmData);
		expenditure = expenditureForm.createExpenditure();
		return expenditure;
	}
	
	public static ClubEventBudget createEventBudgetForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ClubEventBudgetForm clubEventBudgetForm = new ClubEventBudgetForm(requestType, hmData);
		clubEventBudget = clubEventBudgetForm.createClubEventBudget();

		return clubEventBudget;
	}

	public static ClubBudget createClubBudgetForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ClubBudgetForm clubBudgetForm = new ClubBudgetForm(requestType, hmData);
		clubBudget = clubBudgetForm.createClubBudget();

		return clubBudget;
	}

	public static Club createClubForm(RequestType requestType, HashMap<Object, Object> hmData ){
		ClubForm clubForm = new ClubForm(requestType, hmData);
		club = clubForm.createClub();

		return club;
	}

	public static User createUserForm(RequestType requestType, HashMap<Object, Object> hmData){
		UserForm userForm = new UserForm(requestType, hmData);
		user = userForm.createUser();

		return user;

	}

	public static ClubMember createClubMemberForm(RequestType requestType, HashMap<Object, Object> hmData){
		ClubMemberForm clubMemberForm = new ClubMemberForm(requestType, hmData);
		clubMember = clubMemberForm.createMember();

		return clubMember;
	}

	public static ClubEvent createClubEventForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ClubEventForm clubEventForm = new ClubEventForm(requestType, hmData);
		clubEvent = clubEventForm.createClubEvent();

		return clubEvent;

	}

	public static void createLoginForm(RequestType requestType, HashMap<Object, Object> hmData){//void method. No such thing as a Login Object
		LoginForm loginForm = null;//creating a loginForm should call a login() method
		try {
			loginForm = new LoginForm(requestType, hmData);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		loginForm.logUserIn();

	}

///// UPDATE
	public static void updateUserForm(RequestType requestType, HashMap<Object, Object> hmData){
		UserForm userForm = new UserForm(requestType, hmData);
		userForm.updateUser(Main.CURRENTUSER);
		Controller.processRequest(RequestType.UPDATE_CLUB_MEMBER, hmData);//calling update Club Member with same data to kill two birds
	}

	public static void updateClubEventForm(RequestType requestType, HashMap<Object, Object> hmData){

		ClubEventForm clubEventForm = new ClubEventForm(requestType, hmData);

		if(hmData.get("ClubEvent") != null){
			clubEventForm.updateClubEvent((ClubEvent)hmData.get("ClubEvent"));
		}

	}

	public static void updateClubMemberForm(RequestType requestType, HashMap<Object, Object> hmData){
		ClubMemberForm clubMemberForm = new ClubMemberForm(requestType, hmData);

		if(hmData.get("ClubMember") != null){
			clubMemberForm.updateMember((ClubMember)hmData.get("ClubMember"));
		}


	}

	public static void updateClubForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ClubForm clubForm = new ClubForm(requestType, hmData);

		if (hmData.get("Club") != null) {
			clubForm.updateClub((Club)hmData.get("Club"));
		}
	}









	//getters and setters

	public static Expenditure getExpenditure() { return expenditure; }
	public static ClubEventBudget getEventBudget() { return clubEventBudget; }
	public static ClubBudget getClubBudget() { return clubBudget; }
	public static Club getClub() { return club; }
	public static User getUser(){ return user; };
	public static ClubEvent getEvent() { return clubEvent; }
	public static ClubEvent getClubEvent() { return clubEvent; }
	public static ClubEventBudget getClubEventBudget() { return clubEventBudget; }

	public static HashMap<Object, Object> getDataRequested() {
		return dataRequested;
	}

	public static HashMap<Object, Object> getDataToSend() {
		return dataToSend;
	}







	public static ClubMember getClubMember() {
		return clubMember;
	}
	

	//new comment
	//newest comment
	//newestest comment
	
}
