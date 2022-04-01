package CEMS.src.application;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="ClubBudget")
public class ClubBudget extends Budget{
	
	public static int COUNT_FOR_IDS = 0;
	@Id
	@Column(name="club_budget_id")
	private int clubBudgetID = 0;
	@ManyToOne
	private Club club;

//	Events
	@Column(name="events_venue")
	private double eventsVenue;
	@Column(name="events_services")
	private double eventsServices;
	@Column(name="event_refreshments")
	private double eventsRefreshments;
	@Column(name="events_miscellaneous")
	private double eventsMiscellaneous;
	@Column(name="eventsSubtotal")
	private double eventsSubtotal;
	
//	Club Activities
	@Column(name="clubMeetings")
	private double clubMeetings;
	@Column(name="clubSpaceRentalOrFees")
	private double clubSpaceRentalOrFees;
	@Column(name="club_equipment")
	private double clubEquipment;
	@Column(name="club_activities_other")
	private double clubActivitiesOther;
	@Column(name="club_activities_subtotal")
	private double clubActivitiesSubtotal;
	
//	Fundraising
	@Column(name="fundraising_costs")
	private double fundraisingCosts;
	@Column(name="fundraising_income")
	private double fundraisingIncome;
	@Column(name="fundraising_participant_fees")
	private double fundraisingParticipantFees;
	@Column(name="fundraising_donations")
	private double fundraisingDonations;
	@Column(name="fundraising_subtotal")
	private double fundraisingSubtotal;
	
//	Miscellaneous
	@Column(name="misc_admin_fees")
	private double miscAdminFees;
	@Column(name="misc_banking_fees")
	private double miscBankingFees;
	@Column(name="misc_banking_interest_income")
	private double miscBankingInterestIncome;
	@Column(name="misc_utilities")
	private double miscUtilities;
	@Column(name="misc_other")
	private double miscOther;
	@Column(name="misc_subtotal")
	private double miscSubtotal;

	@Column(name="club_budget_subtotal")
	private double clubBudgetSubtotal;
	@Column(name="club_budget_taxes")
	private double clubBudgetTaxes;
	@Column(name="club_budget_total")
	private double clubBudgetTotal;

	public ClubBudget(){}

	ClubBudget(ArrayList<Double> filteredData, Club club){
		this.clubBudgetID = ++COUNT_FOR_IDS;
		this.club = club;
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

	public static int getCountForIds() {
		return COUNT_FOR_IDS;
	}

	public static void setCountForIds(int countForIds) {
		COUNT_FOR_IDS = countForIds;
	}

	public int getClubBudgetID() {
		return clubBudgetID;
	}

	public void setClubBudgetID(int clubBudgetID) {
		this.clubBudgetID = clubBudgetID;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public double getClubBudgetTotal() {
		return clubBudgetTotal;
	}

	public void setClubBudgetTotal(double clubBudgetTotal) {
		this.clubBudgetTotal = clubBudgetTotal;
	}

	public double getEventsVenue() {
		return eventsVenue;
	}

	public void setEventsVenue(double eventsVenue) {
		this.eventsVenue = eventsVenue;
	}

	public double getEventsServices() {
		return eventsServices;
	}

	public void setEventsServices(double eventsServices) {
		this.eventsServices = eventsServices;
	}

	public double getEventsRefreshments() {
		return eventsRefreshments;
	}

	public void setEventsRefreshments(double eventsRefreshments) {
		this.eventsRefreshments = eventsRefreshments;
	}

	public double getEventsMiscellaneous() {
		return eventsMiscellaneous;
	}

	public void setEventsMiscellaneous(double eventsMiscellaneous) {
		this.eventsMiscellaneous = eventsMiscellaneous;
	}

	public double getEventsSubtotal() {
		return eventsSubtotal;
	}

	public void setEventsSubtotal(double eventsSubtotal) {
		this.eventsSubtotal = eventsSubtotal;
	}

	public double getClubMeetings() {
		return clubMeetings;
	}

	public void setClubMeetings(double clubMeetings) {
		this.clubMeetings = clubMeetings;
	}

	public double getClubSpaceRentalOrFees() {
		return clubSpaceRentalOrFees;
	}

	public void setClubSpaceRentalOrFees(double clubSpaceRentalOrFees) {
		this.clubSpaceRentalOrFees = clubSpaceRentalOrFees;
	}

	public double getClubEquipment() {
		return clubEquipment;
	}

	public void setClubEquipment(double clubEquipment) {
		this.clubEquipment = clubEquipment;
	}

	public double getClubActivitiesOther() {
		return clubActivitiesOther;
	}

	public void setClubActivitiesOther(double clubActivitiesOther) {
		this.clubActivitiesOther = clubActivitiesOther;
	}

	public double getClubActivitiesSubtotal() {
		return clubActivitiesSubtotal;
	}

	public void setClubActivitiesSubtotal(double clubActivitiesSubtotal) {
		this.clubActivitiesSubtotal = clubActivitiesSubtotal;
	}

	public double getFundraisingCosts() {
		return fundraisingCosts;
	}

	public void setFundraisingCosts(double fundraisingCosts) {
		this.fundraisingCosts = fundraisingCosts;
	}

	public double getFundraisingIncome() {
		return fundraisingIncome;
	}

	public void setFundraisingIncome(double fundraisingIncome) {
		this.fundraisingIncome = fundraisingIncome;
	}

	public double getFundraisingParticipantFees() {
		return fundraisingParticipantFees;
	}

	public void setFundraisingParticipantFees(double fundraisingParticipantFees) {
		this.fundraisingParticipantFees = fundraisingParticipantFees;
	}

	public double getFundraisingDonations() {
		return fundraisingDonations;
	}

	public void setFundraisingDonations(double fundraisingDonations) {
		this.fundraisingDonations = fundraisingDonations;
	}

	public double getFundraisingSubtotal() {
		return fundraisingSubtotal;
	}

	public void setFundraisingSubtotal(double fundraisingSubtotal) {
		this.fundraisingSubtotal = fundraisingSubtotal;
	}

	public double getMiscAdminFees() {
		return miscAdminFees;
	}

	public void setMiscAdminFees(double miscAdminFees) {
		this.miscAdminFees = miscAdminFees;
	}

	public double getMiscBankingFees() {
		return miscBankingFees;
	}

	public void setMiscBankingFees(double miscBankingFees) {
		this.miscBankingFees = miscBankingFees;
	}

	public double getMiscBankingInterestIncome() {
		return miscBankingInterestIncome;
	}

	public void setMiscBankingInterestIncome(double miscBankingInterestIncome) {
		this.miscBankingInterestIncome = miscBankingInterestIncome;
	}

	public double getMiscUtilities() {
		return miscUtilities;
	}

	public void setMiscUtilities(double miscUtilities) {
		this.miscUtilities = miscUtilities;
	}

	public double getMiscOther() {
		return miscOther;
	}

	public void setMiscOther(double miscOther) {
		this.miscOther = miscOther;
	}

	public double getMiscSubtotal() {
		return miscSubtotal;
	}

	public void setMiscSubtotal(double miscSubtotal) {
		this.miscSubtotal = miscSubtotal;
	}

	public double getClubBudgetSubtotal() {
		return clubBudgetSubtotal;
	}

	public void setClubBudgetSubtotal(double clubBudgetSubtotal) {
		this.clubBudgetSubtotal = clubBudgetSubtotal;
	}

	public double getClubBudgetTaxes() {
		return clubBudgetTaxes;
	}

	public void setClubBudgetTaxes(double clubBudgetTaxes) {
		this.clubBudgetTaxes = clubBudgetTaxes;
	}
}
