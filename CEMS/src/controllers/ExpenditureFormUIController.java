package controllers;

import application.*;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;


public class ExpenditureFormUIController{
	HashMap<Object, Object> dataToSubmit;
	
	@FXML
	private Button btExpenditureBack;
	@FXML
	private Button btExpenditureClear;
	@FXML
	private Button btExpenditureCancel;
	@FXML
	private Button btExpenditureSubmit;
	@FXML
	private TextField tfExpenditureDescription;
	@FXML
	private TextField tfExpenditureAccountHolder;
	@FXML
	private TextField tfExpenditureAccount;
	@FXML
	private TextField tfExpenditureAmount;
	@FXML
	private TextField tfExpenditureTax;
	@FXML
	private TextField tfExpenditureTotal;
	@FXML
	private ChoiceBox<Province> choiceExpenditureProvince;
	@FXML
	private DatePicker dpExpenditureDate;
	@FXML
	private ComboBox<Vendor> comboExpenditureVendor;
	@FXML
	private ChoiceBox<ExpenditureCategory> choiceExpenditureCategory;
	@FXML
	private ChoiceBox<PaymentMethod> choicePaymentMethod;
	@FXML 
	private BorderPane expenditureBorderPane;
	
	
	@FXML
	public void initialize(){
		choiceExpenditureProvince.getItems().addAll(Arrays.asList(Province.values()));
		comboExpenditureVendor.getItems().addAll(Arrays.asList(Vendor.values()));
		choiceExpenditureCategory.getItems().addAll(Arrays.asList(ExpenditureCategory.values()));
		choicePaymentMethod.getItems().addAll(Arrays.asList(PaymentMethod.values()));

		tfExpenditureTax.setStyle("-fx-control-inner-background: #cce0ff");
		tfExpenditureTotal.setStyle("-fx-control-inner-background: #cce0ff");
		
		expenditureBorderPane.setTop(new MainMenu().createMenu());
		
//		btExpenditureClear.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
//
//				tfExpenditureDescription.setText("");
//				tfExpenditureAccountHolder.setText("");
//				tfExpenditureAccount.setText("");
//				tfExpenditureAmount.setText("");
//				tfExpenditureTax.setText("");
//				choiceExpenditureProvince.setValue(null);
//				dpExpenditureDate.setValue(null);
//				comboExpenditureVendor.setValue(null);
//				choiceExpenditureCategory.setValue(null);
//				choicePaymentMethod.setValue(null);
//
//		});


	}
	
	public void calculateTaxes() {
		double subtotal =  Double.parseDouble(tfExpenditureAmount.getText());
		
		double taxes = choiceExpenditureProvince.getValue().getTaxRate()*subtotal;
		
		double total = subtotal + taxes;
		
		tfExpenditureTax.setText("" + taxes);
		tfExpenditureTotal.setText("" + total);
		 
	}
	
	public void checkMandatoryFields() {
		//mandatoryFields: All 

		if(InputValidation.validateText(tfExpenditureAmount)) {
			calculateTaxes();// would rather find a way to call this as an on change to the amount, along with checking it's a double, etc.
		}
		
//		if(!InputValidation.validateText(tfExpenditureDescription)) {
//			tfExpenditureDescription.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		else {
//			tfExpenditureDescription.setStyle(null);
//		}
//		if(tfExpenditureAccountHolder.getText() == "") {
//			tfExpenditureAccountHolder.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(tfExpenditureAccount.getText() == "") {
//			tfExpenditureAccount.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(tfExpenditureAmount.getText() == "") {
//			tfExpenditureAmount.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
////		if(tfExpenditureTax.getText() == "") { //not necessary
////			
////		}
//		if(choiceExpenditureProvince.getValue() == null) {
//			choiceExpenditureProvince.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(dpExpenditureDate.getValue() == null) {
//			dpExpenditureDate.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(comboExpenditureVendor.getValue() == null) {
//			comboExpenditureVendor.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(choiceExpenditureCategory.getValue() == null) {
//			choiceExpenditureCategory.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
//		if(choicePaymentMethod.getValue() == null) {
//			choicePaymentMethod.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
//		}
		
		
//		tfExpenditureDescription.getText()
//		tfExpenditureAccountHolder.getText()
//		tfExpenditureAccount.getText()
//		tfExpenditureAmount.getText()
//		tfExpenditureTax.getText()
//		choiceExpenditureProvince.getValue()
//		dpExpenditureDate.getValue()
//		comboExpenditureVendor.getValue()
//		choiceExpenditureCategory.getValue()
//		choicePaymentMethod.getValue();
	}


	@FXML
	public void btSubmitExpenditureClicked(ActionEvent event) {
		
		//check mandatory fields are filled
		checkMandatoryFields();

		
		dataToSubmit = new HashMap<Object, Object>();
		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
		dataToSubmit.put("ExpenditureAccountHolder", tfExpenditureAccountHolder.getText());
		dataToSubmit.put("ExpenditureAccount", tfExpenditureAccount.getText());
		dataToSubmit.put("ExpenditureAmount", Double.parseDouble(tfExpenditureAmount.getText()));
		dataToSubmit.put("ExpenditureTax", Double.parseDouble(tfExpenditureTax.getText()));
		dataToSubmit.put("ExpenditureTotal", Double.parseDouble(tfExpenditureTotal.getText()));
		dataToSubmit.put("ExpenditureProvince", choiceExpenditureProvince.getValue());
		dataToSubmit.put("ExpenditureDate", dpExpenditureDate.getValue());
		dataToSubmit.put("ExpenditureVendor", comboExpenditureVendor.getValue());
		dataToSubmit.put("ExpenditureCategory", choiceExpenditureCategory.getValue());
		dataToSubmit.put("ExpenditurePaymentMethod", choicePaymentMethod.getValue());
		
		Controller.processRequest(RequestType.SUBMIT_EXPENDITURE, dataToSubmit);
		
//		tfExpenditureDescription.getText()
//		tfExpenditureAccountHolder.getText()
//		tfExpenditureAccount.getText()
//		tfExpenditureAmount.getText()
//		tfExpenditureTax.getText()
//		choiceExpenditureProvince.getValue()
//		dpExpenditureDate.getValue()
//		comboExpenditureVendor.getValue()
//		choiceExpenditureCategory.getValue()
//		choicePaymentMethod.getValue();
		
		btClearExpenditureClicked(event);
	}
	
	@FXML
	public void btCancelExpenditureClicked(ActionEvent event) {
		//calls clear then send back to dashboard?
	}

	
	
	@FXML
	public void btClearExpenditureClicked(ActionEvent event) {
		tfExpenditureDescription.setText("");
		tfExpenditureAccountHolder.setText("");
		tfExpenditureAccount.setText("");
		tfExpenditureAmount.setText("");
		tfExpenditureTax.setText("");
		tfExpenditureTotal.setText("");
		choiceExpenditureProvince.setValue(null);
		dpExpenditureDate.setValue(null);
		comboExpenditureVendor.setValue(null);
		choiceExpenditureCategory.setValue(null);
		choicePaymentMethod.setValue(null);
		
		
	}
	
	
	
	@FXML
	public void btBackExpenditureClicked(ActionEvent event) {
		//sends back to dashboard
	}
	
	@FXML
	public void dpExpenditureDateChanged(ActionEvent event) {
		
	}
	
	@FXML
	public void tfExpenditureDescriptionChanged (ActionEvent event) {
//		tfExpenditureDescription.setStyle(null);
	}


	
	
}
