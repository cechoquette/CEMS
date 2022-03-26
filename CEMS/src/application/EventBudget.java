package CEMS.src.application;

import java.util.ArrayList;

public class EventBudget extends Budget{
	protected static int COUNT_FOR_IDS;
	private int eventBudgetID;

//	Venue

	private double venueEntertainment;
	private double venueLocationRental;
	private double venueEquipmentRental;
	private double venueFurnitureRental;
	private double venueOther;
	private double venueSubtotal;

//	Services

	private double servicesVenueStaff;
	private double servicesSecurity;
	private double servicesAVTechStaff;
	private double servicesCateringStaff;
	private double servicesBarStaff;
	private double servicesVolunteers;
	private double servicesAdvertising;
	private double servicesSocialMedia;
	private double servicesPhotoVideography;
	private double servicesTravel;
	private double servicesGratuities;
	private double servicesOther;
	private double servicesSubtotal;

//	Refreshments

	private double refreshmentsFood;
	private double refreshmentsBeverages;
	private double refreshmentsBarCosts;
	private double refreshmentsOther;
	private double refreshmentsSubtotal;

//	Miscellaneous

	private double MiscPrizesAwards;
	private double MiscGiftBags;
	private double MiscParticipantMaterials;
	private double MiscDecorations;
	private double MiscSignage;
	private double MiscPermits;
	private double MiscFees;
	private double MiscOther;
	private double MiscSubtotal;

	private double EventBudgetSubtotal;
	private double EventBudgetTaxes;
	private double EventBudgetTotal;
	
	EventBudget(ArrayList<Double> sortedData){
		this.eventBudgetID = COUNT_FOR_IDS++;
		
		this.venueEntertainment = sortedData.get(0);
		this.venueLocationRental = sortedData.get(1);
		this.venueEquipmentRental = sortedData.get(2);
		this.venueFurnitureRental = sortedData.get(3);
		this.venueOther = sortedData.get(4);
		this.venueSubtotal = sortedData.get(5);

//		Services

		this.servicesVenueStaff = sortedData.get(6);
		this.servicesSecurity = sortedData.get(7);
		this.servicesAVTechStaff = sortedData.get(8);
		this.servicesCateringStaff = sortedData.get(9);
		this.servicesBarStaff = sortedData.get(10);
		this.servicesVolunteers = sortedData.get(11);
		this.servicesAdvertising = sortedData.get(12);
		this.servicesSocialMedia = sortedData.get(13);
		this.servicesPhotoVideography = sortedData.get(14);
		this.servicesTravel = sortedData.get(15);
		this.servicesGratuities = sortedData.get(16);
		this.servicesOther = sortedData.get(17);
		this.servicesSubtotal = sortedData.get(18);

//		Refreshments

		this.refreshmentsFood = sortedData.get(19);
		this.refreshmentsBeverages = sortedData.get(20);
		this.refreshmentsBarCosts = sortedData.get(21);
		this.refreshmentsOther = sortedData.get(22);
		this.refreshmentsSubtotal = sortedData.get(23);

//		Miscellaneous

		this.MiscPrizesAwards = sortedData.get(24);
		this.MiscGiftBags = sortedData.get(25);
		this.MiscParticipantMaterials = sortedData.get(26);
		this.MiscDecorations = sortedData.get(27);
		this.MiscSignage = sortedData.get(28);
		this.MiscPermits = sortedData.get(29);
		this.MiscFees = sortedData.get(30);
		this.MiscOther = sortedData.get(31);
		this.MiscSubtotal = sortedData.get(32);

		this.EventBudgetSubtotal = sortedData.get(33);
		this.EventBudgetTaxes = sortedData.get(34);
		this.EventBudgetTotal = sortedData.get(35);
	}
	
}
