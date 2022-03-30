package CEMS.src.application;

import java.util.HashMap;

/*
 * Class is responsible for;
 * creating forms
 * 2-way communication with forms
 * 2-way communication with data_processing_controller
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
	public Object[] getData(RequestType requestType, HashMap<Object, Object> hmData) {
		
		
		//call getData() method from Controller
		HashMap<Object, Object> objectsFromDatabase = Controller.getData(requestType, hmData);
		
		//Expected return type is an object //needs to be casted as expected object type by the caller
		//Need to check if it's null at most steps
//		if (objectsFromDatabase == null || objectsFromDatabase[0] == null) {
//			return null;
//		}
//		
		return null;
	}


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
		clubEvent = clubEventForm.getEvent();

		return clubEvent;

	}

	public static void createLoginForm(RequestType requestType, HashMap<Object, Object> hmData){//void method. No such thing as a Login Object
		LoginForm loginForm = new LoginForm(requestType, hmData);//creating a loginForm should call a login() method

	}

///// UPDATE
	public static void updateUserForm(RequestType requestType, HashMap<Object, Object> hmData){
		UserForm userForm = new UserForm(requestType, hmData);
		userForm.updateUser();
		Controller.processRequest(RequestType.UPDATE_CLUB_MEMBER, hmData);//calling update Club Member to kill two birds
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










	//getters and setters

	public static Expenditure getExpenditure() {
		return expenditure;
	}

	public static ClubEventBudget getEventBudget() {
		return clubEventBudget;
	}

	public static ClubBudget getClubBudget() {
		return clubBudget;
	}

	public static Club getClub() {
		return club;
	}

	public static User getUser(){ return user; };
	public static ClubEvent getEvent() { return clubEvent; }

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
