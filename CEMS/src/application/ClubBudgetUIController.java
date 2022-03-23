package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

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
	public void initialize(){
		clubBudgetBorderPane.setTop(new MainMenu().createMenu());
	}

	// Event Listener on Button[#btClubBudgetBack].onAction
	@FXML
	public void btClubBudgetBackClicked(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btClubBudgetClear].onAction
	@FXML
	public void btClubBudgetClearClicked(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btClubBudgetCancel].onAction
	@FXML
	public void btClubBudgetCancelClicked(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btClubBudgetSubmit].onAction
	@FXML
	public void btClubBudgetSubmitClicked(ActionEvent event) {
		// TODO Autogenerated
	}

}
