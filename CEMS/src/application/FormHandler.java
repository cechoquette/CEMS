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
		Object[] objectsFromDatabase = Controller.getData(requestType, hmData);
		
		//Expected return type is an object //needs to be casted as expected object type by the caller
		//Need to check if it's null at most steps
		if (objectsFromDatabase == null || objectsFromDatabase[0] == null) {
			return null;
		}
		
		return null;
	}
	
	public static ExpenditureForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
		ExpenditureForm expenditureForm = new ExpenditureForm(requestType, hmData);
		expenditure = expenditureForm.getExpenditure();
		return expenditureForm;
	}
	
	public static Expenditure getExpenditure() {
		return expenditure;
	}
	
	public static EventForm createEventForm(RequestType requestType, HashMap<Object, Object> hmData) {
		EventForm eventForm = new EventForm();
		
		return eventForm;
	}
	
//	public static EventForm createExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData) {
//		ExpenditureForm expenditureForm = new ExpenditureForm();
//		
//		return expenditureForm;
//	}
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
