package CEMS.src.application;

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

		dataForBudget.add((Double)hmData.get("ClubBudgetEventsVenue"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsServices"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsRefreshments"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsMiscellaneous"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesMeetings"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesSpaceRental"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesEquipment"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesOther"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingCosts"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingIncome"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingParticipantFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingDonations"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousAdministrativeFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousBankingFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousBankingInterest"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousUtilities"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTotal"));	
		
//		for(int i = 0; i < dataForBudget.size(); i++) {
//			System.out.println(dataForBudget.get(i));
//		}
		
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
