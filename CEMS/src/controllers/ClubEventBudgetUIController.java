package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.HashMap;

import javafx.event.ActionEvent;

import javafx.scene.layout.BorderPane;

public class ClubEventBudgetUIController {
	HashMap<Object, Object> dataToSubmit;
	
	@FXML
	private BorderPane eventBudgetBorderPane;
	@FXML
	private Button btEventBudgetBack;
	@FXML
	private Button btEventBudgetClear;
	@FXML
	private Button btEventBudgetCancel;
	@FXML
	private Button btEventBudgetSubmit;
	@FXML
	private TextField tfEventBudgetVenueEntertain;
	@FXML
	private TextField tfEventBudgetVenueLocation;
	@FXML
	private TextField tfEventBudgetVenueEquipRent;
	@FXML
	private TextField tfEventBudgetVenueFurniture;
	@FXML
	private TextField tfEventBudgetVenueOther;
	@FXML
	private TextField tfEventBudgetVenueSubtotal;
	@FXML
	private TextField tfEventBudgetRefreshFood;
	@FXML
	private TextField tfEventBudgetRefreshBeverage;
	@FXML
	private TextField tfEventBudgetRefreshBar;
	@FXML
	private TextField tfEventBudgetRefreshOther;
	@FXML
	private TextField tfEventBudgetRefreshSubtotal;
	@FXML
	private TextField tfEventBudgetServicesVenue;
	@FXML
	private TextField tfEventBudgetServicesSecurity;
	@FXML
	private TextField tfEventBudgetServicesAVTech;
	@FXML
	private TextField tfEventBudgetServicesCatering;
	@FXML
	private TextField tfEventBudgetServicesBar;
	@FXML
	private TextField tfEventBudgetServicesVolunteers;
	@FXML
	private TextField tfEventBudgetServicesAdvertising;
	@FXML
	private TextField tfEventBudgetServicesSocial;
	@FXML
	private TextField tfEventBudgetServicesPhoto;
	@FXML
	private TextField tfEventBudgetServicesTravel;
	@FXML
	private TextField tfEventBudgetServicesGratuities;
	@FXML
	private TextField tfEventBudgetServicesOther;
	@FXML
	private TextField tfEventBudgetServicesSubtotal;
	@FXML
	private TextField tfEventBudgetMiscPrizes;
	@FXML
	private TextField tfEventBudgetMiscGiftBags;
	@FXML
	private TextField tfEventBudgetMiscMaterials;
	@FXML
	private TextField tfEventBudgetMiscDeco;
	@FXML
	private TextField tfEventBudgetMiscSignage;
	@FXML
	private TextField tfEventBudgetMiscPermits;
	@FXML
	private TextField tfEventBudgetMiscFees;
	@FXML
	private TextField tfEventBudgetMiscOther;
	@FXML
	private TextField tfEventBudgetMiscSubtotal;
	@FXML
	private TextField tfEventBudgetSubtotal;
	@FXML
	private TextField tfEventBudgetTaxes;
	@FXML
	private TextField tfEventBudgetTotal;
	@FXML
	private ChoiceBox<Club> choiceClubEventBudgetClub;
	@FXML
	private ChoiceBox<ClubEvent> choiceClubEventBudgetEvent;

	
	@FXML
	public void initialize(){
		eventBudgetBorderPane.setTop(new MainMenu().createMenu());

		//TODO initialize club & event lists
		
		//setting uneditable fields to blue
		tfEventBudgetVenueSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetRefreshSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetServicesSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetMiscSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetTaxes.setStyle("-fx-control-inner-background: #cce0ff");
		tfEventBudgetTotal.setStyle("-fx-control-inner-background: #cce0ff");
	}

	// Event Listener on Button[#btEventBudgetBack].onAction
	@FXML
	public void btEventBudgetBackClicked(ActionEvent event) {
		//this method should return user to dashboard
		
		
	}
	// Event Listener on Button[#btEventBudgetClear].onAction
	@FXML
	public void btEventBudgetClearClicked(ActionEvent event) {
		
		tfEventBudgetVenueEntertain.setText("");
		tfEventBudgetVenueLocation.setText("");
		tfEventBudgetVenueEquipRent.setText("");
		tfEventBudgetVenueFurniture.setText("");
		tfEventBudgetVenueOther.setText("");
		tfEventBudgetVenueSubtotal.setText("");
		tfEventBudgetRefreshFood.setText("");
		tfEventBudgetRefreshBeverage.setText("");
		tfEventBudgetRefreshBar.setText("");
		tfEventBudgetRefreshOther.setText("");
		tfEventBudgetRefreshSubtotal.setText("");
		tfEventBudgetServicesVenue.setText("");
		tfEventBudgetServicesSecurity.setText("");
		tfEventBudgetServicesAVTech.setText("");
		tfEventBudgetServicesCatering.setText("");
		tfEventBudgetServicesBar.setText("");
		tfEventBudgetServicesVolunteers.setText("");
		tfEventBudgetServicesAdvertising.setText("");
		tfEventBudgetServicesSocial.setText("");
		tfEventBudgetServicesPhoto.setText("");
		tfEventBudgetServicesTravel.setText("");
		tfEventBudgetServicesGratuities.setText("");
		tfEventBudgetServicesOther.setText("");
		tfEventBudgetServicesSubtotal.setText("");
		tfEventBudgetMiscPrizes.setText("");
		tfEventBudgetMiscGiftBags.setText("");
		tfEventBudgetMiscMaterials.setText("");
		tfEventBudgetMiscDeco.setText("");
		tfEventBudgetMiscSignage.setText("");
		tfEventBudgetMiscPermits.setText("");
		tfEventBudgetMiscFees.setText("");
		tfEventBudgetMiscOther.setText("");
		tfEventBudgetMiscSubtotal.setText("");
		tfEventBudgetSubtotal.setText("");
		tfEventBudgetTaxes.setText("");
		tfEventBudgetTotal.setText("");
		choiceClubEventBudgetClub.setValue(null);
		choiceClubEventBudgetEvent.setValue(null);
		
		setSubtotalsBaseline();
	}
	// Event Listener on Button[#btEventBudgetCancel].onAction
	@FXML
	public void btEventBudgetCancelClicked(ActionEvent event) {
		btEventBudgetClearClicked(event);
	}
	// Event Listener on Button[#btEventBudgetSubmit].onAction
	@FXML
	public void btEventBudgetSubmitClicked(ActionEvent event) {
		checkMandatoryFields();
		calculateSubtotals();
		
		dataToSubmit = new HashMap<Object, Object>();
		
		dataToSubmit.put("EventBudgetVenueEntertainement", Double.parseDouble(tfEventBudgetVenueEntertain.getText()));
		dataToSubmit.put("EventBudgetVenueLocationRental", Double.parseDouble(tfEventBudgetVenueLocation.getText()));
		dataToSubmit.put("EventBudgetVenueEquipmentRental", Double.parseDouble(tfEventBudgetVenueEquipRent.getText()));
		dataToSubmit.put("EventBudgetVenueFurniture", Double.parseDouble(tfEventBudgetVenueFurniture.getText()));
		dataToSubmit.put("EventBudgetVenueOther", Double.parseDouble(tfEventBudgetVenueOther.getText()));
		dataToSubmit.put("EventBudgetVenueSubtotal", Double.parseDouble(tfEventBudgetVenueSubtotal.getText()));
		dataToSubmit.put("EventBudgetRefreshmentsFood", Double.parseDouble(tfEventBudgetRefreshFood.getText()));
		dataToSubmit.put("EventBudgetRefreshmentsBeverages", Double.parseDouble(tfEventBudgetRefreshBeverage.getText()));
		dataToSubmit.put("EventBudgetRefreshmentsBarCosts", Double.parseDouble(tfEventBudgetRefreshBar.getText()));
		dataToSubmit.put("EventBudgetRefreshmentsOther", Double.parseDouble(tfEventBudgetRefreshOther.getText()));
		dataToSubmit.put("EventBudgetRefreshmentsSubtotal", Double.parseDouble(tfEventBudgetRefreshSubtotal.getText()));
		dataToSubmit.put("EventBudgetServicesVenueStaff", Double.parseDouble(tfEventBudgetServicesVenue.getText()));
		dataToSubmit.put("EventBudgetServicesSecurity", Double.parseDouble(tfEventBudgetServicesSecurity.getText()));
		dataToSubmit.put("EventBudgetServicesAVStaffTechSupport", Double.parseDouble(tfEventBudgetServicesAVTech.getText()));
		dataToSubmit.put("EventBudgetServicesCateringStaff", Double.parseDouble(tfEventBudgetServicesCatering.getText()));
		dataToSubmit.put("EventBudgetServicesBarStaff", Double.parseDouble(tfEventBudgetServicesBar.getText()));
		dataToSubmit.put("EventBudgetServicesVolunteers", Double.parseDouble(tfEventBudgetServicesVolunteers.getText()));
		dataToSubmit.put("EventBudgetServicesAdvertising", Double.parseDouble(tfEventBudgetServicesAdvertising.getText()));
		dataToSubmit.put("EventBudgetServicesSocialMedia", Double.parseDouble(tfEventBudgetServicesSocial.getText()));
		dataToSubmit.put("EventBudgetServicesPhotoVideography", Double.parseDouble(tfEventBudgetServicesPhoto.getText()));
		dataToSubmit.put("EventBudgetServicesTravel", Double.parseDouble(tfEventBudgetServicesTravel.getText()));
		dataToSubmit.put("EventBudgetServicesGratuities", Double.parseDouble(tfEventBudgetServicesGratuities.getText()));
		dataToSubmit.put("EventBudgetServicesOther", Double.parseDouble(tfEventBudgetServicesOther.getText()));
		dataToSubmit.put("EventBudgetServicesSubtotal", Double.parseDouble(tfEventBudgetServicesSubtotal.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousPrizesAwards", Double.parseDouble(tfEventBudgetMiscPrizes.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousGiftBags", Double.parseDouble(tfEventBudgetMiscGiftBags.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousParticipantMaterials", Double.parseDouble(tfEventBudgetMiscMaterials.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousDecorations", Double.parseDouble(tfEventBudgetMiscDeco.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousSignage", Double.parseDouble(tfEventBudgetMiscSignage.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousPermits", Double.parseDouble(tfEventBudgetMiscPermits.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousFees", Double.parseDouble(tfEventBudgetMiscFees.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousOther", Double.parseDouble(tfEventBudgetMiscOther.getText()));
		dataToSubmit.put("EventBudgetMiscellaneousSubtotal", Double.parseDouble(tfEventBudgetMiscSubtotal.getText()));
		dataToSubmit.put("EventBudgetSubtotal", Double.parseDouble(tfEventBudgetSubtotal.getText()));
		dataToSubmit.put("EventBudgetTaxes", Double.parseDouble(tfEventBudgetTaxes.getText()));
		dataToSubmit.put("EventBudgetTotal", Double.parseDouble(tfEventBudgetTotal.getText()));
		//No null values expected
		dataToSubmit.put("EventBudgetClub", choiceClubEventBudgetClub.getValue());
		dataToSubmit.put("EventBudgetEvent", choiceClubEventBudgetEvent.getValue());

		Controller.processRequest(RequestType.SUBMIT_EVENT_BUDGET, dataToSubmit);
		btEventBudgetClearClicked(event);
		btEventBudgetBackClicked(event);
	}
	
	public void checkMandatoryFields() {

		//at least one field must be > 0
		//club and event must not be null
		choiceClubEventBudgetClub.getValue();
		choiceClubEventBudgetEvent.getValue();


		if(tfEventBudgetVenueEntertain.getText() == "")
		tfEventBudgetVenueEntertain.setText("0.00");
		if(tfEventBudgetVenueLocation.getText() == "")
		tfEventBudgetVenueLocation.setText("0.00");
		if(tfEventBudgetVenueEquipRent.getText() == "")
		tfEventBudgetVenueEquipRent.setText("0.00");
		if(tfEventBudgetVenueFurniture.getText() == "")
		tfEventBudgetVenueFurniture.setText("0.00");
		if(tfEventBudgetVenueOther.getText() == "")
		tfEventBudgetVenueOther.setText("0.00");
		
		if(tfEventBudgetRefreshFood.getText() == "")
		tfEventBudgetRefreshFood.setText("0.00");
		if(tfEventBudgetRefreshBeverage.getText() == "")
		tfEventBudgetRefreshBeverage.setText("0.00");
		if(tfEventBudgetRefreshBar.getText() == "")
		tfEventBudgetRefreshBar.setText("0.00");
		if(tfEventBudgetRefreshOther.getText() == "")
		tfEventBudgetRefreshOther.setText("0.00");
		
		if(tfEventBudgetServicesVenue.getText() == "")
		tfEventBudgetServicesVenue.setText("0.00");
		if(tfEventBudgetServicesSecurity.getText() == "")
		tfEventBudgetServicesSecurity.setText("0.00");
		if(tfEventBudgetServicesAVTech.getText() == "")
		tfEventBudgetServicesAVTech.setText("0.00");
		if(tfEventBudgetServicesCatering.getText() == "")
		tfEventBudgetServicesCatering.setText("0.00");
		if(tfEventBudgetServicesBar.getText() == "")
		tfEventBudgetServicesBar.setText("0.00");
		if(tfEventBudgetServicesVolunteers.getText() == "")
		tfEventBudgetServicesVolunteers.setText("0.00");
		if(tfEventBudgetServicesAdvertising.getText() == "")
		tfEventBudgetServicesAdvertising.setText("0.00");
		if(tfEventBudgetServicesSocial.getText() == "")
		tfEventBudgetServicesSocial.setText("0.00");
		if(tfEventBudgetServicesPhoto.getText() == "")
		tfEventBudgetServicesPhoto.setText("0.00");
		if(tfEventBudgetServicesTravel.getText() == "")
		tfEventBudgetServicesTravel.setText("0.00");
		if(tfEventBudgetServicesGratuities.getText() == "")
		tfEventBudgetServicesGratuities.setText("0.00");
		if(tfEventBudgetServicesOther.getText() == "")
		tfEventBudgetServicesOther.setText("0.00");
		
		if(tfEventBudgetMiscPrizes.getText() == "")
		tfEventBudgetMiscPrizes.setText("0.00");
		if(tfEventBudgetMiscGiftBags.getText() == "")
		tfEventBudgetMiscGiftBags.setText("0.00");
		if(tfEventBudgetMiscMaterials.getText() == "")
		tfEventBudgetMiscMaterials.setText("0.00");
		if(tfEventBudgetMiscDeco.getText() == "")
		tfEventBudgetMiscDeco.setText("0.00");
		if(tfEventBudgetMiscSignage.getText() == "")
		tfEventBudgetMiscSignage.setText("0.00");
		if(tfEventBudgetMiscPermits.getText() == "")
		tfEventBudgetMiscPermits.setText("0.00");
		if(tfEventBudgetMiscFees.getText() == "")
		tfEventBudgetMiscFees.setText("0.00");
		if(tfEventBudgetMiscOther.getText() == "")
		tfEventBudgetMiscOther.setText("0.00");
		
	}
	
	public void calculateSubtotals() {
		double venueSubtotal =  
			Double.parseDouble(tfEventBudgetVenueEntertain.getText()) +
			Double.parseDouble(tfEventBudgetVenueLocation.getText()) +
			Double.parseDouble(tfEventBudgetVenueEquipRent.getText()) +
			Double.parseDouble(tfEventBudgetVenueFurniture.getText()) +
			Double.parseDouble(tfEventBudgetVenueOther.getText());
	
		tfEventBudgetVenueSubtotal.setText(String.format("%.2f", venueSubtotal));
		
		
		double refreshmentsSubtotal =  
				Double.parseDouble(tfEventBudgetRefreshFood.getText()) +
				Double.parseDouble(tfEventBudgetRefreshBeverage.getText()) +
				Double.parseDouble(tfEventBudgetRefreshBar.getText()) +
				Double.parseDouble(tfEventBudgetRefreshOther.getText());
				
				
				
		tfEventBudgetRefreshSubtotal.setText(String.format("%.2f", refreshmentsSubtotal));
				
		double servicesSubtotal =  
				Double.parseDouble(tfEventBudgetServicesVenue.getText()) +
				Double.parseDouble(tfEventBudgetServicesSecurity.getText()) +
				Double.parseDouble(tfEventBudgetServicesAVTech.getText()) +
				Double.parseDouble(tfEventBudgetServicesCatering.getText()) +
				Double.parseDouble(tfEventBudgetServicesBar.getText()) +
				Double.parseDouble(tfEventBudgetServicesVolunteers.getText()) +
				Double.parseDouble(tfEventBudgetServicesAdvertising.getText()) +
				Double.parseDouble(tfEventBudgetServicesSocial.getText()) +
				Double.parseDouble(tfEventBudgetServicesPhoto.getText()) +
				Double.parseDouble(tfEventBudgetServicesTravel.getText()) +
				Double.parseDouble(tfEventBudgetServicesGratuities.getText()) +
				Double.parseDouble(tfEventBudgetServicesOther.getText());
		
		tfEventBudgetServicesSubtotal.setText(String.format("%.2f", servicesSubtotal));
		
		double miscellaneousSubtotal =  
				Double.parseDouble(tfEventBudgetMiscPrizes.getText()) +
				Double.parseDouble(tfEventBudgetMiscGiftBags.getText()) +
				Double.parseDouble(tfEventBudgetMiscMaterials.getText()) +
				Double.parseDouble(tfEventBudgetMiscDeco.getText()) +
				Double.parseDouble(tfEventBudgetMiscSignage.getText()) +
				Double.parseDouble(tfEventBudgetMiscPermits.getText()) +
				Double.parseDouble(tfEventBudgetMiscFees.getText()) +
				Double.parseDouble(tfEventBudgetMiscOther.getText());

		tfEventBudgetMiscSubtotal.setText(String.format("%.2f", miscellaneousSubtotal));
		
		double fullBudgetSubtotal = venueSubtotal + refreshmentsSubtotal + servicesSubtotal + miscellaneousSubtotal;
				
		
		tfEventBudgetSubtotal.setText(String.format("%.2f", fullBudgetSubtotal));
		
		double taxes = Province.ONTARIO.getTaxRate()*fullBudgetSubtotal;
		double total = fullBudgetSubtotal + taxes;
		
		tfEventBudgetTaxes.setText(String.format("%.2f", taxes));
		tfEventBudgetTotal.setText(String.format("%.2f", total));
		 
	}
	
	public void setSubtotalsBaseline() {
		tfEventBudgetVenueSubtotal.setText("0.00");
		tfEventBudgetRefreshSubtotal.setText("0.00");
		tfEventBudgetServicesSubtotal.setText("0.00");
		tfEventBudgetMiscSubtotal.setText("0.00");
		tfEventBudgetSubtotal.setText("0.00");
		tfEventBudgetTaxes.setText("0.00");
		tfEventBudgetTotal.setText("0.00");
	}
}
