package CEMS.src.application;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="ClubEventBudget")
public class ClubEventBudget extends Budget{
	public static int COUNT_FOR_IDS;

	@Id
	@Column(name="event_budget_id")
	private int eventBudgetID;
	@ManyToOne
	private Club club;
	@ManyToOne
	private ClubEvent clubEvent;

//	Venue
	@Column(name="venue_entertainment")
	private double venueEntertainment;
	@Column(name="venue_location_rental")
	private double venueLocationRental;
	@Column(name="venue_equipment_rental")
	private double venueEquipmentRental;
	@Column(name="venue_furniture_rental ")
	private double venueFurnitureRental;
	@Column(name="venue_venue_other")
	private double venueOther;
	@Column(name="venue_subtotal")
	private double venueSubtotal;

//	Services
	@Column(name="services_venue_staff")
	private double servicesVenueStaff;
	@Column(name="service_security")
	private double servicesSecurity;
	@Column(name="services_AVTechStaff")
	private double servicesAVTechStaff;
	@Column(name="services_catering_staff")
	private double servicesCateringStaff;
	@Column(name="services_bar_staff ")
	private double servicesBarStaff;
	@Column(name="services_volunteers")
	private double servicesVolunteers;
	@Column(name="services_advertising")
	private double servicesAdvertising;
	@Column(name="services_social_media")
	private double servicesSocialMedia;
	@Column(name="services_photo_videography")
	private double servicesPhotoVideography;
	@Column(name="services_travel")
	private double servicesTravel;
	@Column(name="services_gratuities")
	private double servicesGratuities;
	@Column(name="services_other")
	private double servicesOther;
	@Column(name="services_subtotal")
	private double servicesSubtotal;

//	Refreshments
@Column(name="refreshments_food")
	private double refreshmentsFood;
	@Column(name="refreshments_beverages ")
	private double refreshmentsBeverages;
	@Column(name="refreshments_bar_costs")
	private double refreshmentsBarCosts;
	@Column(name="refreshments_other")
	private double refreshmentsOther;
	@Column(name="refreshments_subtotal")
	private double refreshmentsSubtotal;

//	Miscellaneous
	@Column(name="misc_prizes_awards")
	private double MiscPrizesAwards;
	@Column(name="misc_giftbags")
	private double MiscGiftBags;
	@Column(name="misc_participant_materials")
	private double MiscParticipantMaterials;
	@Column(name="misc_decorations")
	private double MiscDecorations;
	@Column(name="misc_signage")
	private double MiscSignage;
	@Column(name="misc_permits ")
	private double MiscPermits;
	@Column(name="misc_fees")
	private double MiscFees;
	@Column(name="misc_other")
	private double MiscOther;
	@Column(name="misc_subtotal")
	private double MiscSubtotal;

	@Column(name="event_budget_subtotal")
	private double EventBudgetSubtotal;
	@Column(name="event_budget_taxes")
	private double EventBudgetTaxes;
	@Column(name="event_budget_total")
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
