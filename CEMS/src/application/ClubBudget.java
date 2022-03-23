package application;

import java.util.ArrayList;

public class ClubBudget extends Budget{
	
	protected static int COUNT_FOR_IDS = 0;
	private int clubBudgetID;

//	Events

	private double eventsVenue;
	private double eventsServices;
	private double eventsRefreshments;
	private double eventsMiscellaneous;
	private double eventsSubtotal;
	
//	Club Activities
	
	private double clubMeetings;
	private double clubSpaceRentalOrFees;
	private double clubEquipment;
	private double clubActivitiesOther;
	private double clubActivitiesSubtotal;
	
//	Fundraising
	
	private double fundraisingCosts;
	private double fundraisingIncome;
	private double fundraisingParticipantFees;
	private double fundraisingDonations;
	private double fundraisingSubtotal;
	
//	Miscellaneous
	
	private double miscAdminFees;
	private double miscBankingFees;
	private double miscBankingInterestIncome;
	private double miscUtilities;
	private double miscOther;
	private double miscSubtotal;

	private double clubBudgetSubtotal;
	private double clubBudgetTaxes;
	private double clubBudgetTotal;
	
	ClubBudget(ArrayList<Double> filteredData){
		this.clubBudgetID = ++COUNT_FOR_IDS;
		this.eventsVenue = filteredData.get(0);
		this.eventsServices = filteredData.get(1);
		this.eventsRefreshments = filteredData.get(2);
		this.eventsMiscellaneous = filteredData.get(3);
		this.eventsSubtotal = filteredData.get(4);
		
//		Club Activities
		
		this.clubMeetings = filteredData.get(5);
		this.clubSpaceRentalOrFees = filteredData.get(6);
		this.clubEquipment = filteredData.get(7);
		this.clubActivitiesOther = filteredData.get(8);
		this.clubActivitiesSubtotal = filteredData.get(9);
		
//		Fundraising
		
		this.fundraisingCosts = filteredData.get(10);
		this.fundraisingIncome = filteredData.get(11);
		this.fundraisingParticipantFees = filteredData.get(12);
		this.fundraisingDonations = filteredData.get(13);
		this.fundraisingSubtotal = filteredData.get(14);
		
//		Miscellaneous
		
		this.miscAdminFees = filteredData.get(15);
		this.miscBankingFees = filteredData.get(16);
		this.miscBankingInterestIncome = filteredData.get(17);
		this.miscUtilities = filteredData.get(18);

		this.miscOther = filteredData.get(19);
		this.miscSubtotal = filteredData.get(20);

		this.clubBudgetSubtotal = filteredData.get(21);
		this.clubBudgetTaxes = filteredData.get(22);
		this.clubBudgetTotal = filteredData.get(23);
	}
	
	@Override
	public String toString() {
		return 
				
		"ID: " + clubBudgetID + "\n"+
		eventsVenue + "\n" +
		eventsServices + "\n" +
		eventsRefreshments + "\n" +
		eventsMiscellaneous + "\n" +
		eventsSubtotal + "\n" +
		clubMeetings + "\n" +
		clubSpaceRentalOrFees + "\n" +
		clubEquipment + "\n" +
		clubActivitiesOther + "\n" +
		clubActivitiesSubtotal + "\n" +
		fundraisingCosts + "\n" +
		fundraisingIncome + "\n" +
		fundraisingParticipantFees + "\n" +
		fundraisingDonations + "\n" +
		fundraisingSubtotal + "\n" +
		miscAdminFees + "\n" +
		miscBankingFees + "\n" +
		miscBankingInterestIncome + "\n" +
		miscUtilities + "\n" +
		miscOther + "\n" +
		miscSubtotal + "\n" +
		clubBudgetSubtotal + "\n" +
		clubBudgetTaxes + "\n" +
		clubBudgetTotal;
	}
	
	
}
