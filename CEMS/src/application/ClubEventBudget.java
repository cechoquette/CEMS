package CEMS.src.application;

import java.util.ArrayList;

public class ClubEventBudget extends Budget{
	public static int COUNT_FOR_IDS;
	private int eventBudgetID;
	private Club club;
	private ClubEvent clubEvent;

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

	public ClubEventBudget(){}
	
	public ClubEventBudget(ArrayList<Double> sortedData, Club club, ClubEvent clubEvent){
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

		this.club = club;
		this.clubEvent = clubEvent;

	}

	public static int getCountForIds() {
		return COUNT_FOR_IDS;
	}

	public static void setCountForIds(int countForIds) {
		COUNT_FOR_IDS = countForIds;
	}

	public int getEventBudgetID() {
		return eventBudgetID;
	}

	public void setEventBudgetID(int eventBudgetID) {
		this.eventBudgetID = eventBudgetID;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public ClubEvent getClubEvent() {
		return clubEvent;
	}

	public void setClubEvent(ClubEvent clubEvent) {
		this.clubEvent = clubEvent;
	}

	public double getVenueEntertainment() {
		return venueEntertainment;
	}

	public void setVenueEntertainment(double venueEntertainment) {
		this.venueEntertainment = venueEntertainment;
	}

	public double getVenueLocationRental() {
		return venueLocationRental;
	}

	public void setVenueLocationRental(double venueLocationRental) {
		this.venueLocationRental = venueLocationRental;
	}

	public double getVenueEquipmentRental() {
		return venueEquipmentRental;
	}

	public void setVenueEquipmentRental(double venueEquipmentRental) {
		this.venueEquipmentRental = venueEquipmentRental;
	}

	public double getVenueFurnitureRental() {
		return venueFurnitureRental;
	}

	public void setVenueFurnitureRental(double venueFurnitureRental) {
		this.venueFurnitureRental = venueFurnitureRental;
	}

	public double getVenueOther() {
		return venueOther;
	}

	public void setVenueOther(double venueOther) {
		this.venueOther = venueOther;
	}

	public double getVenueSubtotal() {
		return venueSubtotal;
	}

	public void setVenueSubtotal(double venueSubtotal) {
		this.venueSubtotal = venueSubtotal;
	}

	public double getServicesVenueStaff() {
		return servicesVenueStaff;
	}

	public void setServicesVenueStaff(double servicesVenueStaff) {
		this.servicesVenueStaff = servicesVenueStaff;
	}

	public double getServicesSecurity() {
		return servicesSecurity;
	}

	public void setServicesSecurity(double servicesSecurity) {
		this.servicesSecurity = servicesSecurity;
	}

	public double getServicesAVTechStaff() {
		return servicesAVTechStaff;
	}

	public void setServicesAVTechStaff(double servicesAVTechStaff) {
		this.servicesAVTechStaff = servicesAVTechStaff;
	}

	public double getServicesCateringStaff() {
		return servicesCateringStaff;
	}

	public void setServicesCateringStaff(double servicesCateringStaff) {
		this.servicesCateringStaff = servicesCateringStaff;
	}

	public double getServicesBarStaff() {
		return servicesBarStaff;
	}

	public void setServicesBarStaff(double servicesBarStaff) {
		this.servicesBarStaff = servicesBarStaff;
	}

	public double getServicesVolunteers() {
		return servicesVolunteers;
	}

	public void setServicesVolunteers(double servicesVolunteers) {
		this.servicesVolunteers = servicesVolunteers;
	}

	public double getServicesAdvertising() {
		return servicesAdvertising;
	}

	public void setServicesAdvertising(double servicesAdvertising) {
		this.servicesAdvertising = servicesAdvertising;
	}

	public double getServicesSocialMedia() {
		return servicesSocialMedia;
	}

	public void setServicesSocialMedia(double servicesSocialMedia) {
		this.servicesSocialMedia = servicesSocialMedia;
	}

	public double getServicesPhotoVideography() {
		return servicesPhotoVideography;
	}

	public void setServicesPhotoVideography(double servicesPhotoVideography) {
		this.servicesPhotoVideography = servicesPhotoVideography;
	}

	public double getServicesTravel() {
		return servicesTravel;
	}

	public void setServicesTravel(double servicesTravel) {
		this.servicesTravel = servicesTravel;
	}

	public double getServicesGratuities() {
		return servicesGratuities;
	}

	public void setServicesGratuities(double servicesGratuities) {
		this.servicesGratuities = servicesGratuities;
	}

	public double getServicesOther() {
		return servicesOther;
	}

	public void setServicesOther(double servicesOther) {
		this.servicesOther = servicesOther;
	}

	public double getServicesSubtotal() {
		return servicesSubtotal;
	}

	public void setServicesSubtotal(double servicesSubtotal) {
		this.servicesSubtotal = servicesSubtotal;
	}

	public double getRefreshmentsFood() {
		return refreshmentsFood;
	}

	public void setRefreshmentsFood(double refreshmentsFood) {
		this.refreshmentsFood = refreshmentsFood;
	}

	public double getRefreshmentsBeverages() {
		return refreshmentsBeverages;
	}

	public void setRefreshmentsBeverages(double refreshmentsBeverages) {
		this.refreshmentsBeverages = refreshmentsBeverages;
	}

	public double getRefreshmentsBarCosts() {
		return refreshmentsBarCosts;
	}

	public void setRefreshmentsBarCosts(double refreshmentsBarCosts) {
		this.refreshmentsBarCosts = refreshmentsBarCosts;
	}

	public double getRefreshmentsOther() {
		return refreshmentsOther;
	}

	public void setRefreshmentsOther(double refreshmentsOther) {
		this.refreshmentsOther = refreshmentsOther;
	}

	public double getRefreshmentsSubtotal() {
		return refreshmentsSubtotal;
	}

	public void setRefreshmentsSubtotal(double refreshmentsSubtotal) {
		this.refreshmentsSubtotal = refreshmentsSubtotal;
	}

	public double getMiscPrizesAwards() {
		return MiscPrizesAwards;
	}

	public void setMiscPrizesAwards(double miscPrizesAwards) {
		MiscPrizesAwards = miscPrizesAwards;
	}

	public double getMiscGiftBags() {
		return MiscGiftBags;
	}

	public void setMiscGiftBags(double miscGiftBags) {
		MiscGiftBags = miscGiftBags;
	}

	public double getMiscParticipantMaterials() {
		return MiscParticipantMaterials;
	}

	public void setMiscParticipantMaterials(double miscParticipantMaterials) {
		MiscParticipantMaterials = miscParticipantMaterials;
	}

	public double getMiscDecorations() {
		return MiscDecorations;
	}

	public void setMiscDecorations(double miscDecorations) {
		MiscDecorations = miscDecorations;
	}

	public double getMiscSignage() {
		return MiscSignage;
	}

	public void setMiscSignage(double miscSignage) {
		MiscSignage = miscSignage;
	}

	public double getMiscPermits() {
		return MiscPermits;
	}

	public void setMiscPermits(double miscPermits) {
		MiscPermits = miscPermits;
	}

	public double getMiscFees() {
		return MiscFees;
	}

	public void setMiscFees(double miscFees) {
		MiscFees = miscFees;
	}

	public double getMiscOther() {
		return MiscOther;
	}

	public void setMiscOther(double miscOther) {
		MiscOther = miscOther;
	}

	public double getMiscSubtotal() {
		return MiscSubtotal;
	}

	public void setMiscSubtotal(double miscSubtotal) {
		MiscSubtotal = miscSubtotal;
	}

	public double getEventBudgetSubtotal() {
		return EventBudgetSubtotal;
	}

	public void setEventBudgetSubtotal(double eventBudgetSubtotal) {
		EventBudgetSubtotal = eventBudgetSubtotal;
	}

	public double getEventBudgetTaxes() {
		return EventBudgetTaxes;
	}

	public void setEventBudgetTaxes(double eventBudgetTaxes) {
		EventBudgetTaxes = eventBudgetTaxes;
	}

	public double getEventBudgetTotal() {
		return EventBudgetTotal;
	}

	public void setEventBudgetTotal(double eventBudgetTotal) {
		EventBudgetTotal = eventBudgetTotal;
	}
}
