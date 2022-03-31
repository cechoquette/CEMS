package CEMS.src.application;
public enum RequestType {

	CREATE_USER("Create User"),
	GET_USER("Get User"), // Retrieve the User from DB (CURRENTUSER)
	MODIFY_USER("Modify User"),
	MODIFY_USER_PERMISSION("Modify User Permission"),
	DELETE_USER("Delete User"),
	SUBMIT_EXPENDITURE("Submit Expenditure"),
	SUBMIT_CLUB_BUDGET("Submit Club Budget"),
	SUBMIT_EVENT_BUDGET("Submit Event Budget"),
	LOGIN_USER("Login"),
	PASSWORD_RESET("Reset Password"),
	PASSWORD_RETRIEVE("Retrieve Forgotten Password"),
	CREATE_EVENT("Create Event"),
	MODIFY_EVENT("Modify Event"),
	DELETE_EVENT("Delete Event"),
	CREATE_EMAIL("Create Email"),
	CREATE_CLUB("Create Club"),
	MODIFY_CLUB("Modify Club"),
	DELETE_CLUB("Delete Club"),
	CREATE_CLUB_MEMBER("Create Club Member"),
	DISPLAY_CALENDAR("Display Calendar"),
	GENERATE_REPORT("Generate Report"),
	GENERATE_EVENT_REPORT("Generate Event Report"),
	GENERATE_CLUB_REPORT("Generate Club Report"),
	GENERATE_BUDGET_REPORT("Generate Budget Report"),
	GENERATE_EXPENDITURE_REPORT("Generate Expenditure Report"),
	REQUEST_DATA_FROM_DATABASE("Request Data"),//use if searching if something is in Database, and want data returned
	STORE_DATA_IN_DATABASE("Store Data"),
	QUERY_DATABASE("Query Database"),//use if searching if something is in Database, not to return data
	DELETE_FROM_DATABASE("Delete from Database"),
	SEARCH_FOR_USER("Search for User"),
	UPDATE_CLUB_MEMBER("Update Club Member"),
	DELETE_CLUB_MEMBER("Delete Club Member"),
	GET_CLUB_MEMBER("Get Club Member from Database");
	
	
	
	
	
	private String name = "";
	
	RequestType(String name){
		this.name = name;
	};
}
