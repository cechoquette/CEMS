package application;
public enum RequestType {

	CREATE_USER("Create User"),
	SUBMIT_EXPENDITURE("Submit Expenditure"),
	SUBMIT_BUDGET("Submit Budget"),
	LOGIN_USER("Login"),
	CREATE_EVENT("Create Event"),
	CREATE_EMAIL("Create Email"),
	CREATE_CLUB("Create Club"),
	DISPLAY_CALENDAR("Display Calendar"),
	GENERATE_EVENT_REPORT("Generate Event Report"),
	GENERATE_CLUB_REPORT("Generate Club Report"),
	GENERATE_BUDGET_REPORT("Generate Budget Report"),
	GENERATE_EXPENDITURE_REPORT("Generate Expenditure Report");
	
	
	
	private String name = "";
	
	RequestType(String name){
		this.name = name;
	};
}
