package application;

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
	static Event event;
	static Expenditure expenditure;
	static EventBudget eventBudget;
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
	
	public static Expenditure createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ExpenditureForm expenditureForm = new ExpenditureForm(requestType, hmData);
		expenditure = expenditureForm.getExpenditure();
		return expenditure;
	}
	
	public static Expenditure getExpenditure() {
		return expenditure;
	}
	
	public static EventForm createEventForm(RequestType requestType, HashMap<Object, Object> hmData) {
		EventForm eventForm = new EventForm();
		
		return eventForm;
	}
	
	public static EventBudget createEventBudgetForm(RequestType requestType, HashMap<Object, Object> hmData) {
		EventBudgetForm eventBudgetForm = new EventBudgetForm(requestType, hmData);
		eventBudget = eventBudgetForm.getEventBudget();
		System.out.println(eventBudget);
		System.out.println("This worked2?");
		return eventBudget;
	}
	public static EventBudget getEventBudget() {
		return eventBudget;
	}
	
	public static ClubBudget createClubBudgetForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ClubBudgetForm clubBudgetForm = new ClubBudgetForm(requestType, hmData);
		clubBudget = clubBudgetForm.getClubBudget();
		System.out.println(clubBudget);
		System.out.println("This worked?");
		return clubBudget;
	}
	public static ClubBudget getClubBudget() {
		return clubBudget;
	}

	public static HashMap<Object, Object> getDataRequested() {
		return dataRequested;
	}

	public static HashMap<Object, Object> getDataToSend() {
		return dataToSend;
	}

	public static Event getEvent() {
		return event;
	}

	public static Club getClub() {
		return club;
	}

	public static User getUser() {
		return user;
	}

	public static ClubMember getClubMember() {
		return clubMember;
	}
	
//	
//	public static EmailForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
//	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
//	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
//	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
//	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
//	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
//	
	//new comment
	//newest comment
	//newestest comment
	
}
