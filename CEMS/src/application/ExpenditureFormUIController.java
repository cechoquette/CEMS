package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	private TextField tfExpenditurePayee;
	@FXML
	private TextField tfExpenditureAccount;
	@FXML
	private TextField tfExpenditureAmount;
	@FXML
	private TextField tfExpenditureTax;
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
	public void initialize(){
		choiceExpenditureProvince.getItems().addAll(Arrays.asList(Province.values()));
		comboExpenditureVendor.getItems().addAll(Arrays.asList(Vendor.values()));
		choiceExpenditureCategory.getItems().addAll(Arrays.asList(ExpenditureCategory.values()));
		choicePaymentMethod.getItems().addAll(Arrays.asList(PaymentMethod.values()));
		
		
		
//		btExpenditureClear.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
//
//				tfExpenditureDescription.setText("");
//				tfExpenditurePayee.setText("");
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
	
	
	public void checkMandatoryFields() {
		//mandatoryFields: All 
		
		if(!InputValidation.validateText(tfExpenditureDescription)) {
			tfExpenditureDescription.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		else {
			tfExpenditureDescription.setStyle(null);
		}
		if(tfExpenditurePayee.getText() == "") {
			tfExpenditurePayee.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(tfExpenditureAccount.getText() == "") {
			tfExpenditureAccount.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(tfExpenditureAmount.getText() == "") {
			tfExpenditureAmount.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
//		if(tfExpenditureTax.getText() == "") { //not necessary
//			
//		}
		if(choiceExpenditureProvince.getValue() == null) {
			choiceExpenditureProvince.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(dpExpenditureDate.getValue() == null) {
			dpExpenditureDate.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(comboExpenditureVendor.getValue() == null) {
			comboExpenditureVendor.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(choiceExpenditureCategory.getValue() == null) {
			choiceExpenditureCategory.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		if(choicePaymentMethod.getValue() == null) {
			choicePaymentMethod.setStyle("-fx-text-box-border: red ;-fx-focus-color: red ;-fx-control-inner-background: #fabdb9");
		}
		
		
		
//		tfExpenditurePayee.getText()
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

		
//		dataToSubmit = new HashMap<Object, Object>();
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
//		dataToSubmit.put("ExpenditurePayee", tfExpenditurePayee.getText());
//		dataToSubmit.put("ExpenditureAccount", tfExpenditureAccount.getText());
//		dataToSubmit.put("ExpenditureAmount", tfExpenditureAmount.getText());
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
//		dataToSubmit.put("ExpenditureDescription", tfExpenditureDescription.getText());
	}
	
	@FXML
	public void btCancelExpenditureClicked(ActionEvent event) {
		
	}

	
	
	@FXML
	public void btClearExpenditureClicked(ActionEvent event) {
		tfExpenditureDescription.setText("");
		tfExpenditurePayee.setText("");
		tfExpenditureAccount.setText("");
		tfExpenditureAmount.setText("");
		tfExpenditureTax.setText("");
		choiceExpenditureProvince.setValue(null);
		dpExpenditureDate.setValue(null);
		comboExpenditureVendor.setValue(null);
		choiceExpenditureCategory.setValue(null);
		choicePaymentMethod.setValue(null);
		
		
	}
	
	
	
	@FXML
	public void btBackExpenditureClicked(ActionEvent event) {
		
	}
	
	
	
	
	
	
	
	@FXML
	public void dpExpenditureDateChanged(ActionEvent event) {
		
	}
	

	@FXML
	public void tfExpenditureDescriptionChanged (ActionEvent event) {
//		tfExpenditureDescription.setStyle(null);
	}


	
	
}
