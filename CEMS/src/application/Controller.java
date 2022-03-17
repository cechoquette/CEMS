package application;
import java.util.HashMap;

public class Controller {
	
	private HashMap<Object, Object> dataToSend;
	private String confirmation;
	
	
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	public String getConfirmation() {
		return this.confirmation;
	}
	
	public void processRequest(RequestType requestType, HashMap<Object, Object> dataToProcess) {
		
		switch(requestType) {
			case CREATE_CLUB:
				
			case CREATE_EMAIL:
				
			case CREATE_EVENT:
				
			case CREATE_USER:
				
			case LOGIN_USER:
				
			case SUBMIT_BUDGET:
				
			case SUBMIT_EXPENDITURE:  FormHandler.createExpenditureForm(requestType, dataToProcess);//call formHandler
										break;
			case GENERATE_BUDGET_REPORT:
				
			case GENERATE_CLUB_REPORT:
				
			case GENERATE_EVENT_REPORT:
				
			case GENERATE_EXPENDITURE_REPORT: //call reportHandler
												break;
			case DISPLAY_CALENDAR: //retrieve data
				break;
			default:
				break;
		
		}
		
	}
	

}
