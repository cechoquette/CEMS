package application;

import java.util.ArrayList;
import java.util.HashMap;

public class EventBudgetForm extends Form{

//	private double subtotal;
//	private double taxes;
//	private double total;
	
	private static int budgetFormID;
	private boolean isFilled;
	private EventBudget eventBudget;
	
	EventBudgetForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.budgetFormID++;
		createEventBudget(hmData);
	}
	
	public void createEventBudget(HashMap<Object, Object> hmData){
		ArrayList<Double> dataForBudget = new ArrayList<Double>();
		
		dataForBudget.add((Double)hmData.get("VenueEntertainment"));
		dataForBudget.add((Double)hmData.get("VenueLocationRental"));
		dataForBudget.add((Double)hmData.get("VenueEquipmentRental"));
		dataForBudget.add((Double)hmData.get("VenueFurnitureRental"));
		dataForBudget.add((Double)hmData.get("VenueOther"));
		dataForBudget.add((Double)hmData.get("VenueSubtotal"));

		dataForBudget.add((Double)hmData.get("ServicesVenueStaff"));
		dataForBudget.add((Double)hmData.get("ServicesSecurity"));
		dataForBudget.add((Double)hmData.get("ServicesAVTechStaff"));
		dataForBudget.add((Double)hmData.get("ServicesCateringStaff"));
		dataForBudget.add((Double)hmData.get("ServicesBarStaff"));
		dataForBudget.add((Double)hmData.get("ServicesVolunteers"));
		dataForBudget.add((Double)hmData.get("ServicesAdvertising"));
		dataForBudget.add((Double)hmData.get("ServicesSocialMedia"));
		dataForBudget.add((Double)hmData.get("ServicesPhotoVideography"));
		dataForBudget.add((Double)hmData.get("ServicesTravel"));
		dataForBudget.add((Double)hmData.get("ServicesGratuities"));
		dataForBudget.add((Double)hmData.get("ServicesOther"));
		dataForBudget.add((Double)hmData.get("ServicesSubtotal"));

		dataForBudget.add((Double)hmData.get("RefreshmentsFood"));
		dataForBudget.add((Double)hmData.get("RefreshmentsBeverages"));
		dataForBudget.add((Double)hmData.get("RefreshmentsBarCosts"));
		dataForBudget.add((Double)hmData.get("RefreshmentsOther"));
		dataForBudget.add((Double)hmData.get("RefreshmentsSubtotal"));

		dataForBudget.add((Double)hmData.get("MiscellaneousPrizesAwards"));
		dataForBudget.add((Double)hmData.get("MiscellaneousGiftBags"));
		dataForBudget.add((Double)hmData.get("MiscellaneousParticipantMaterials"));
		dataForBudget.add((Double)hmData.get("MiscellaneousDecorations"));
		dataForBudget.add((Double)hmData.get("MiscellaneousSignage"));
		dataForBudget.add((Double)hmData.get("MiscellaneousPermits"));
		dataForBudget.add((Double)hmData.get("MiscellaneousFees"));
		dataForBudget.add((Double)hmData.get("MiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("MiscellaneousSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("EventBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("EventBudgetTotal"));	
		
		this.eventBudget = new EventBudget(dataForBudget);
		
	}
	
	
	public EventBudget getEventBudget() {
		return eventBudget;
	}
	
//	public double getSubtotal() {
//		return subtotal;
//	}
//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}
//	public double getTaxes() {
//		taxes = subtotal * 0.13;
//		return taxes;
//	}
//	public void setTaxes(double taxes) {
//		this.taxes = taxes;
//	}
//	public double getTotal() {
//		total = subtotal + taxes;
//		return total;
//	}
//	public void setTotal(double total) {
//		this.total = total;
//	}


	
	
}
