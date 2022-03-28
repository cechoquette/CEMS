package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubEventBudgetForm extends Form{

//	private double subtotal;
//	private double taxes;
//	private double total;
	
	private static int budgetFormID;
	private boolean isFilled;
	private ClubEventBudget clubEventBudget;
	
	ClubEventBudgetForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.budgetFormID++;
		createEventBudget(hmData);
	}
	
	public void createEventBudget(HashMap<Object, Object> hmData){
		ArrayList<Double> dataForBudget = new ArrayList<Double>();
		
		dataForBudget.add((Double)hmData.get("EventBudgetVenueEntertainement"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueLocationRental"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueEquipmentRental"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueFurniture"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsFood"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsBeverages"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsBarCosts"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsSubtotal"));
		
		dataForBudget.add((Double)hmData.get("EventBudgetServicesVenueStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSecurity"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesAVStaffTechSupport"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesCateringStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesBarStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesVolunteers"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesAdvertising"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSocialMedia"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesPhotoVideography"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesTravel"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesGratuities"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousPrizesAwards"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousGiftBags"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousParticipantMaterials"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousDecorations"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousSignage"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousPermits"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousFees"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("EventBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("EventBudgetTotal"));
		
		this.clubEventBudget = new ClubEventBudget(dataForBudget);
		
	}
	
	
	public ClubEventBudget getEventBudget() {
		return clubEventBudget;
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
