package application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubBudgetForm extends Form{
	
//	private double subtotal;
//	private double taxes;
//	private double total;
//	
	private static int budgetFormID;
	private boolean isFilled;
	private ClubBudget clubBudget;
	
	ClubBudgetForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.budgetFormID++;
		createClubBudget(hmData);
	}
	
	public void createClubBudget(HashMap<Object, Object> hmData){
		ArrayList<Double> dataForBudget = new ArrayList<Double>();

		dataForBudget.add((Double)hmData.get("EventsVenue"));
		dataForBudget.add((Double)hmData.get("EventsServices"));
		dataForBudget.add((Double)hmData.get("EventsRefreshments"));
		dataForBudget.add((Double)hmData.get("EventsMiscellaneous"));
		dataForBudget.add((Double)hmData.get("EventsSubtotal"));

		dataForBudget.add((Double)hmData.get("ClubActivitiesMeetings"));
		dataForBudget.add((Double)hmData.get("ClubActivitiesSpaceRentalOrFees"));
		dataForBudget.add((Double)hmData.get("ClubActivitiesEquipment"));
		dataForBudget.add((Double)hmData.get("ClubActivitiesOther"));
		dataForBudget.add((Double)hmData.get("ClubActivitesSubtotal"));
		
		dataForBudget.add((Double)hmData.get("FundraisingCosts"));
		dataForBudget.add((Double)hmData.get("FundraisingIncome"));
		dataForBudget.add((Double)hmData.get("FundraisingParticipantFees"));
		dataForBudget.add((Double)hmData.get("FundraisingDonations"));
		dataForBudget.add((Double)hmData.get("FundraisingSubtotal"));
		
		dataForBudget.add((Double)hmData.get("MiscellaneousAdminFees"));
		dataForBudget.add((Double)hmData.get("MiscellaneousBankingFees"));
		dataForBudget.add((Double)hmData.get("MiscellaneousBankingInterestIncome"));
		dataForBudget.add((Double)hmData.get("MiscellaneousUtilities"));
		
		dataForBudget.add((Double)hmData.get("MiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("MiscellaneousSubtotal"));

		dataForBudget.add((Double)hmData.get("ClubBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTotal"));	
		
		this.clubBudget = new ClubBudget(dataForBudget);
		
	}
	
	public ClubBudget getClubBudget() {
		return clubBudget;
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
	
//	@Override
//	public void addField(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Object getField(Object Key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void setField(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public boolean delete(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
