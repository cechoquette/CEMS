package CEMS.src.controllers;


import CEMS.src.application.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.layout.BorderPane;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import static CEMS.src.application.Main.defaultPane;

public class ReportRequestUIController {
	HashMap<Object, Object> dataToSubmit;

	
	@FXML
	private BorderPane reportBorderPane;
	@FXML
	private Button btReportBack;
	@FXML
	private Button btReportClear;
	@FXML
	private Button btReportCancel;
	@FXML
	private Button btReportSubmit;
	@FXML
	private ChoiceBox<ReportType> choiceReportSelectType;
	@FXML
	private ChoiceBox<Club> choiceReportSelectClub;
	@FXML
	private ToggleGroup tgReportTimeframe;
	@FXML
	private RadioButton rbReportTimeframeYeartodate;
	@FXML
	private RadioButton rbReportTimeframeCurrentMonth;
	@FXML
	private RadioButton rbReportTimeframeLastMonth;
	@FXML
	private RadioButton rbReportTimeframeCustom;
	@FXML
	private DatePicker dpReportStartDate;
	@FXML
	private DatePicker dpReportEndDate;
	@FXML
	private Label lbReportFrom;
	@FXML
	private Label lbReportTo;
	@FXML
	private ToggleGroup tgReportExport;
	@FXML
	private RadioButton rbReportExportPDF;
	@FXML
	private RadioButton rbReportExportExcel;
	@FXML
	private RadioButton rbReportExportPrint;
	@FXML
	private Label lbReportEvent;
	@FXML
	private ChoiceBox<ClubEvent> choiceReportEvent;


	@FXML
	public void initialize(){
		
		choiceReportSelectType.getItems().addAll(Arrays.asList(ReportType.values()));
//		choiceReportSelectClub.getItems().addAll(Arrays.asList(OptionLists.getClubs()));//use for testing only
		choiceReportSelectClub.getItems().addAll(FXCollections.observableList(OptionLists.getAllClubsList()));
//		choiceReportEvent.getItems().addAll(Arrays.asList(OptionLists.getEvents()));//use for testing only
		choiceReportEvent.getItems().addAll(FXCollections.observableList(OptionLists.getUserEventsList()));

		choiceReportSelectType.setOnAction(
				e -> choiceReportTypeChanged()
		);

		//remove this option for now
		rbReportExportPrint.setVisible(false);

		initializeDates();
		setCustomInvisible();
		setEventsInvisible();
		
	}

	public void setEventsInvisible(){
		choiceReportEvent.setValue(null);
		lbReportEvent.setVisible(false);
		choiceReportEvent.setVisible(false);
	}
	
	public void setCustomInvisible() {
		dpReportStartDate.setValue(null);
		dpReportEndDate.setValue(null);
		lbReportFrom.setVisible(false);
		lbReportTo.setVisible(false);
		dpReportStartDate.setVisible(false);
		dpReportEndDate.setVisible(false);
	}
	
	public void initializeDates() {
		dpReportStartDate.setValue(LocalDate.of(LocalDateTime.now().toLocalDate().getYear(), LocalDateTime.now().toLocalDate().getMonthValue(), 1));
		dpReportEndDate.setValue(LocalDateTime.now().toLocalDate());
	}
	
	public void checkMandatoryFields() {
		
		
	}
	
	public Timeframe getTimeframe() {
		
		Timeframe timeframe = new Timeframe();
		LocalDate start;
		//if year-to-date is selected, set timeframe to Sept 1st of Current Year until today
		if (rbReportTimeframeYeartodate.isSelected()) {
			start = LocalDate.of(timeframe.getToday().getYear(), 9, 1);
			timeframe.setStartDate(start);
			return timeframe;
		}
		//if current month is selected, set timeframe to 1st of current month until today
		if (rbReportTimeframeCurrentMonth.isSelected()) {
			start = LocalDate.of(timeframe.getToday().getYear(), timeframe.getToday().getMonthValue(), 1);
			timeframe.setStartDate(start);
			return timeframe;
		}	
		//if last month is selected, set timeframe to 1st of previous month until last day of previous month
		if (rbReportTimeframeLastMonth.isSelected()) {
			
			start = LocalDate.of(timeframe.getToday().getYear(), timeframe.getToday().getMonthValue()-1>0?timeframe.getToday().getMonthValue()-1:12, 1);
			timeframe.setStartDate(start);
			timeframe.setEndDate(start.withDayOfMonth(start.lengthOfMonth()));
			return timeframe;
		}
		//if custom is selected, set timeframe to start date until end date
		//if startdate not set, use beginning of year, Sept 1st
		//if enddate not set, use today
		if (rbReportTimeframeCustom.isSelected()) {
			if(dpReportStartDate.getValue() != null) {
				timeframe.setStartDate(dpReportStartDate.getValue());
			}else {
				timeframe.setStartDate(LocalDate.of(timeframe.getToday().getYear(), 9, 1));
			}
			
			if(dpReportEndDate.getValue() != null) {
				timeframe.setEndDate(dpReportEndDate.getValue());
			}else {
				timeframe.setEndDate(timeframe.getToday());
			}
			
			return timeframe;
		}
			
		return timeframe;
			
	}
	
	public ReportFormat getFormat() {
		if (rbReportExportPDF.isSelected()) {
			return ReportFormat.PDF;
		}
		if (rbReportExportExcel.isSelected()) {
			return ReportFormat.EXCEL;
		}
		if (rbReportExportPrint.isSelected()) {
			return ReportFormat.PRINT;
		}
		return ReportFormat.EXCEL;
	}
	
	// Event Listener on Button[#btReportBack].onAction
	@FXML
	public void btReportBackClicked(ActionEvent event) {
		//method should return user to dashboard
		Pane menuScreen = ViewBuilder.newScreen("MenuBar");
		Pane home = ViewBuilder.newScreen("HomePage");
		BorderPane homePage = new BorderPane();
		CalendarView calendar = new CalendarView();

		homePage.setTop(home);
		homePage.setCenter(calendar.makeCalendar());

		defaultPane.setTop(menuScreen);
		defaultPane.setCenter(homePage);
	}
	// Event Listener on Button[#btReportClear].onAction
	@FXML
	public void btReportClearClicked(ActionEvent event) {
		choiceReportSelectType.setValue(null);
		choiceReportSelectClub.setValue(null);
		rbReportTimeframeYeartodate.setSelected(false);
		rbReportTimeframeCurrentMonth.setSelected(false);
		rbReportTimeframeLastMonth.setSelected(false);
		rbReportTimeframeCustom.setSelected(false);
		initializeDates();
		rbReportExportPDF.setSelected(false);
		rbReportExportExcel.setSelected(false);
		rbReportExportPrint.setSelected(false);
		setCustomInvisible();
		setEventsInvisible();
	}
	// Event Listener on Button[#btReportCancel].onAction
	@FXML
	public void btReportCancelClicked(ActionEvent event) {
		btReportClearClicked(event);
	}
	// Event Listener on Button[#btReportSubmit].onAction
	@FXML
	public void btReportSubmitClicked(ActionEvent event) {
		checkMandatoryFields();
		getTimeframe();
		dataToSubmit = new HashMap<Object, Object>();
		
		dataToSubmit.put("ReportType", choiceReportSelectType.getValue());//ReportType
		dataToSubmit.put("ReportClub", choiceReportSelectClub.getValue());//Club
		dataToSubmit.put("ReportTimeframe", getTimeframe());
		dataToSubmit.put("ReportFormat", getFormat());
		dataToSubmit.put("ReportEvent", choiceReportEvent.getValue());//can be null


		Controller.processRequest(RequestType.GENERATE_REPORT, dataToSubmit);
	}
	// Event Listener on RadioButton[#rbReportTimeframeYeartodate].onAction
	@FXML
	public void rbReportYearSelected(ActionEvent event) {
		setCustomInvisible();
	}
	// Event Listener on RadioButton[#rbReportTimeframeCurrentMonth].onAction
	@FXML
	public void rbReportCurrentMonthSelected(ActionEvent event) {
		setCustomInvisible();
	}
	// Event Listener on RadioButton[#rbReportTimeframeLastMonth].onAction
	@FXML
	public void rbReportLastMonthSelected(ActionEvent event) {
		setCustomInvisible();
	}
	// Event Listener on RadioButton[#rbReportTimeframeCustom].onAction
	@FXML
	public void rbReportCustomSelected(ActionEvent event) {
		initializeDates();
		lbReportFrom.setVisible(true);
		lbReportTo.setVisible(true);
		dpReportStartDate.setVisible(true);
		dpReportEndDate.setVisible(true);
	}
	public void choiceReportTypeChanged() {


		if (choiceReportSelectType.getValue() != null) {
			if (choiceReportSelectType.getValue() == ReportType.CLUBEVENT_BUDGET ||
					choiceReportSelectType.getValue() == ReportType.CLUBEVENT_ATTENDANCE ||
					choiceReportSelectType.getValue() == ReportType.CLUBEVENT_EXPENDITURES) {
				lbReportEvent.setVisible(true);
				choiceReportEvent.setVisible(true);
			}
			else{
				setEventsInvisible();
			}
		}
		else{
			setEventsInvisible();
		}
	}
}
