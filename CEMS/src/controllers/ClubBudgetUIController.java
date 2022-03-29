package CEMS.src.controllers;

import CEMS.src.application.*;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.HashMap;

import javafx.event.ActionEvent;

import javafx.scene.layout.BorderPane;

public class ClubBudgetUIController {
	HashMap<Object, Object> dataToSubmit;
	
	@FXML
	private BorderPane clubBudgetBorderPane;
	@FXML
	private Button btClubBudgetBack;
	@FXML
	private Button btClubBudgetClear;
	@FXML
	private Button btClubBudgetCancel;
	@FXML
	private Button btClubBudgetSubmit;
	@FXML
	private TextField tfClubBudgetEventsVenue;
	@FXML
	private TextField tfClubBudgetEventsServices;
	@FXML
	private TextField tfClubBudgetEventsRefreshments;
	@FXML
	private TextField tfClubBudgetEventsMisc;
	@FXML
	private TextField tfClubBudgetEventsSubtotal;
	@FXML
	private TextField tfClubBudgetActivitiesMeetings;
	@FXML
	private TextField tfClubBudgetActivitiesSpace;
	@FXML
	private TextField tfClubBudgetActivitiesEquipment;
	@FXML
	private TextField tfClubBudgetActivitiesOther;
	@FXML
	private TextField tfClubBudgetActivitiesSubtotal;
	@FXML
	private TextField tfClubBudgetFundraisingCosts;
	@FXML
	private TextField tfClubBudgetFundraisingIncome;
	@FXML
	private TextField tfClubBudgetFundraisingParticipant;
	@FXML
	private TextField tfClubBudgetFundraisingDonations;
	@FXML
	private TextField tfClubBudgetFundraisingSubtotal;
	@FXML
	private TextField tfClubBudgetMiscAdminFees;
	@FXML
	private TextField tfClubBudgetMiscBankFees;
	@FXML
	private TextField tfClubBudgetMiscBankInterest;
	@FXML
	private TextField tfClubBudgetMiscUtilities;
	@FXML
	private TextField tfClubBudgetMiscOther;
	@FXML
	private TextField tfClubBudgetMiscSubtotal;
	@FXML
	private TextField tfClubBudgetSubtotal;
	@FXML
	private TextField tfClubBudgetTaxes;
	@FXML
	private TextField tfClubBudgetTotal;
	@FXML
	private ChoiceBox<Club> choiceClubBudgetClub;
	
	@FXML
	public void initialize(){
		clubBudgetBorderPane.setTop(new MainMenu().createMenu());

		//choiceClubBudgetClub set up fields
		
		//setting uneditable fields to blue
		tfClubBudgetEventsSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetActivitiesSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetFundraisingSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetMiscSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetSubtotal.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetTaxes.setStyle("-fx-control-inner-background: #cce0ff");
		tfClubBudgetTotal.setStyle("-fx-control-inner-background: #cce0ff");
	}

	// Event Listener on Button[#btClubBudgetBack].onAction
	@FXML
	public void btClubBudgetBackClicked(ActionEvent event) {
		//method should return user to dashboard
	}
	// Event Listener on Button[#btClubBudgetClear].onAction
	@FXML
	public void btClubBudgetClearClicked(ActionEvent event) {
		//method sets all fields to blank. and calls subtotalsBaseline
		tfClubBudgetEventsVenue.setText("");
		tfClubBudgetEventsServices.setText("");
		tfClubBudgetEventsRefreshments.setText("");
		tfClubBudgetEventsMisc.setText("");
		tfClubBudgetEventsSubtotal.setText("");
		tfClubBudgetActivitiesMeetings.setText("");
		tfClubBudgetActivitiesSpace.setText("");
		tfClubBudgetActivitiesEquipment.setText("");
		tfClubBudgetActivitiesOther.setText("");
		tfClubBudgetActivitiesSubtotal.setText("");
		tfClubBudgetFundraisingCosts.setText("");
		tfClubBudgetFundraisingIncome.setText("");
		tfClubBudgetFundraisingParticipant.setText("");
		tfClubBudgetFundraisingDonations.setText("");
		tfClubBudgetFundraisingSubtotal.setText("");
		tfClubBudgetMiscAdminFees.setText("");
		tfClubBudgetMiscBankFees.setText("");
		tfClubBudgetMiscBankInterest.setText("");
		tfClubBudgetMiscUtilities.setText("");
		tfClubBudgetMiscOther.setText("");
		tfClubBudgetMiscSubtotal.setText("");
		tfClubBudgetSubtotal.setText("");
		tfClubBudgetTaxes.setText("");
		tfClubBudgetTotal.setText("");
		choiceClubBudgetClub.setValue(null);
		
		setSubtotalsBaseline();
	}
	// Event Listener on Button[#btClubBudgetCancel].onAction
	@FXML
	public void btClubBudgetCancelClicked(ActionEvent event) {
		btClubBudgetClearClicked(event);
	}
	// Event Listener on Button[#btClubBudgetSubmit].onAction
	@FXML
	public void btClubBudgetSubmitClicked(ActionEvent event) {
		checkMandatoryFields();
		calculateSubtotals();
		
		dataToSubmit = new HashMap<Object, Object>();

		dataToSubmit.put("ClubBudgetEventsVenue", Double.parseDouble(tfClubBudgetEventsVenue.getText()));
		dataToSubmit.put("ClubBudgetEventsServices", Double.parseDouble(tfClubBudgetEventsServices.getText()));
		dataToSubmit.put("ClubBudgetEventsRefreshments", Double.parseDouble(tfClubBudgetEventsRefreshments.getText()));
		dataToSubmit.put("ClubBudgetEventsMiscellaneous", Double.parseDouble(tfClubBudgetEventsMisc.getText()));
		dataToSubmit.put("ClubBudgetEventsSubtotal", Double.parseDouble(tfClubBudgetEventsSubtotal.getText()));
		dataToSubmit.put("ClubBudgetActivitiesMeetings", Double.parseDouble(tfClubBudgetActivitiesMeetings.getText()));
		dataToSubmit.put("ClubBudgetActivitiesSpaceRental", Double.parseDouble(tfClubBudgetActivitiesSpace.getText()));
		dataToSubmit.put("ClubBudgetActivitiesEquipment", Double.parseDouble(tfClubBudgetActivitiesEquipment.getText()));
		dataToSubmit.put("ClubBudgetActivitiesOther", Double.parseDouble(tfClubBudgetActivitiesOther.getText()));
		dataToSubmit.put("ClubBudgetActivitiesSubtotal", Double.parseDouble(tfClubBudgetActivitiesSubtotal.getText()));
		dataToSubmit.put("ClubBudgetFundraisingCosts", Double.parseDouble(tfClubBudgetFundraisingCosts.getText()));
		dataToSubmit.put("ClubBudgetFundraisingIncome", Double.parseDouble(tfClubBudgetFundraisingIncome.getText()));
		dataToSubmit.put("ClubBudgetFundraisingParticipantFees", Double.parseDouble(tfClubBudgetFundraisingParticipant.getText()));
		dataToSubmit.put("ClubBudgetFundraisingDonations", Double.parseDouble(tfClubBudgetFundraisingDonations.getText()));
		dataToSubmit.put("ClubBudgetFundraisingSubtotal", Double.parseDouble(tfClubBudgetFundraisingSubtotal.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousAdministrativeFees", Double.parseDouble(tfClubBudgetMiscAdminFees.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousBankingFees", Double.parseDouble(tfClubBudgetMiscBankFees.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousBankingInterest", Double.parseDouble(tfClubBudgetMiscBankInterest.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousUtilities", Double.parseDouble(tfClubBudgetMiscUtilities.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousOther", Double.parseDouble(tfClubBudgetMiscOther.getText()));
		dataToSubmit.put("ClubBudgetMiscellaneousSubtotal", Double.parseDouble(tfClubBudgetMiscSubtotal.getText()));
		dataToSubmit.put("ClubBudgetSubtotal", Double.parseDouble(tfClubBudgetSubtotal.getText()));
		dataToSubmit.put("ClubBudgetTaxes", Double.parseDouble(tfClubBudgetTaxes.getText()));
		dataToSubmit.put("ClubBudgetTotal", Double.parseDouble(tfClubBudgetTotal.getText()));
		dataToSubmit.put("ClubBudgetClub", choiceClubBudgetClub.getValue());

		Controller.processRequest(RequestType.SUBMIT_CLUB_BUDGET, dataToSubmit);
		btClubBudgetClearClicked(event);
		btClubBudgetBackClicked(event);
	}
	
	public void checkMandatoryFields() {
		if(tfClubBudgetEventsVenue.getText() == "")
		tfClubBudgetEventsVenue.setText("0.00");
		if(tfClubBudgetEventsServices.getText() == "")
		tfClubBudgetEventsServices.setText("0.00");
		if(tfClubBudgetEventsRefreshments.getText() == "")
		tfClubBudgetEventsRefreshments.setText("0.00");
		if(tfClubBudgetEventsMisc.getText() == "")
		tfClubBudgetEventsMisc.setText("0.00");
		if(tfClubBudgetEventsSubtotal.getText() == "")
		tfClubBudgetEventsSubtotal.setText("0.00");
		if(tfClubBudgetActivitiesMeetings.getText() == "")
		tfClubBudgetActivitiesMeetings.setText("0.00");
		if(tfClubBudgetActivitiesSpace.getText() == "")
		tfClubBudgetActivitiesSpace.setText("0.00");
		if(tfClubBudgetActivitiesEquipment.getText() == "")
		tfClubBudgetActivitiesEquipment.setText("0.00");
		if(tfClubBudgetActivitiesOther.getText() == "")
		tfClubBudgetActivitiesOther.setText("0.00");
		if(tfClubBudgetActivitiesSubtotal.getText() == "")
		tfClubBudgetActivitiesSubtotal.setText("0.00");
		if(tfClubBudgetFundraisingCosts.getText() == "")
		tfClubBudgetFundraisingCosts.setText("0.00");
		if(tfClubBudgetFundraisingIncome.getText() == "")
		tfClubBudgetFundraisingIncome.setText("0.00");
		if(tfClubBudgetFundraisingParticipant.getText() == "")
		tfClubBudgetFundraisingParticipant.setText("0.00");
		if(tfClubBudgetFundraisingDonations.getText() == "")
		tfClubBudgetFundraisingDonations.setText("0.00");
		if(tfClubBudgetFundraisingSubtotal.getText() == "")
		tfClubBudgetFundraisingSubtotal.setText("0.00");
		if(tfClubBudgetMiscAdminFees.getText() == "")
		tfClubBudgetMiscAdminFees.setText("0.00");
		if(tfClubBudgetMiscBankFees.getText() == "")
		tfClubBudgetMiscBankFees.setText("0.00");
		if(tfClubBudgetMiscBankInterest.getText() == "")
		tfClubBudgetMiscBankInterest.setText("0.00");
		if(tfClubBudgetMiscUtilities.getText() == "")
		tfClubBudgetMiscUtilities.setText("0.00");
		if(tfClubBudgetMiscOther.getText() == "")
		tfClubBudgetMiscOther.setText("0.00");
		if(tfClubBudgetMiscSubtotal.getText() == "")
		tfClubBudgetMiscSubtotal.setText("0.00");
		if(tfClubBudgetSubtotal.getText() == "")
		tfClubBudgetSubtotal.setText("0.00");
		if(tfClubBudgetTaxes.getText() == "")
		tfClubBudgetTaxes.setText("0.00");
		if(tfClubBudgetTotal.getText() == "")
		tfClubBudgetTotal.setText("0.00");
		
	}
	
	public void calculateSubtotals() {

		double eventsSubtotal =  
			Double.parseDouble(tfClubBudgetEventsVenue.getText()) +
			Double.parseDouble(tfClubBudgetEventsServices.getText()) +
			Double.parseDouble(tfClubBudgetEventsRefreshments.getText()) +
			Double.parseDouble(tfClubBudgetEventsMisc.getText());
	
		tfClubBudgetEventsSubtotal.setText(String.format("%.2f", eventsSubtotal));

		double clubActivitiesSubtotal =  
				Double.parseDouble(tfClubBudgetActivitiesMeetings.getText()) +
				Double.parseDouble(tfClubBudgetActivitiesSpace.getText()) +
				Double.parseDouble(tfClubBudgetActivitiesEquipment.getText()) +
				Double.parseDouble(tfClubBudgetActivitiesOther.getText());

		tfClubBudgetActivitiesSubtotal.setText(String.format("%.2f", clubActivitiesSubtotal));
				
		double fundraisingSubtotal =  
				Double.parseDouble(tfClubBudgetFundraisingCosts.getText()) +
				Double.parseDouble(tfClubBudgetFundraisingIncome.getText()) +
				Double.parseDouble(tfClubBudgetFundraisingParticipant.getText()) +
				Double.parseDouble(tfClubBudgetFundraisingDonations.getText());

		tfClubBudgetFundraisingSubtotal.setText(String.format("%.2f", fundraisingSubtotal));
		
		double miscellaneousSubtotal =  
				Double.parseDouble(tfClubBudgetMiscAdminFees.getText()) +
				Double.parseDouble(tfClubBudgetMiscBankFees.getText()) +
				Double.parseDouble(tfClubBudgetMiscBankInterest.getText()) +
				Double.parseDouble(tfClubBudgetMiscUtilities.getText()) +
				Double.parseDouble(tfClubBudgetMiscOther.getText());

		tfClubBudgetMiscSubtotal.setText(String.format("%.2f", miscellaneousSubtotal));
		
		double fullBudgetSubtotal = eventsSubtotal + clubActivitiesSubtotal + fundraisingSubtotal + miscellaneousSubtotal;

		tfClubBudgetSubtotal.setText(String.format("%.2f", fullBudgetSubtotal));
		
		double taxes = Province.ONTARIO.getTaxRate()*fullBudgetSubtotal;
		double total = fullBudgetSubtotal + taxes;
		
		tfClubBudgetTaxes.setText(String.format("%.2f", taxes));
		tfClubBudgetTotal.setText(String.format("%.2f", total));
		
	}
	
	public void setSubtotalsBaseline() {
		//sets all sub totals & totals to 0.00
		tfClubBudgetEventsSubtotal.setText("0.00");
		tfClubBudgetActivitiesSubtotal.setText("0.00");
		tfClubBudgetFundraisingSubtotal.setText("0.00");
		tfClubBudgetMiscSubtotal.setText("0.00");
		tfClubBudgetSubtotal.setText("0.00");
		tfClubBudgetTaxes.setText("0.00");
		tfClubBudgetTotal.setText("0.00");

	}

}
