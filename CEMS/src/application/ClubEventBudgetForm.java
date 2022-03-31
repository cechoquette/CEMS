package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubEventBudgetForm extends Form{
	public static int COUNT_FOR_IDS;
	private static int formID;
	private boolean isFilled;
	private ClubEventBudget clubEventBudget;
	private HashMap<Object, Object> hmData;

	ClubEventBudgetForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.hmData = hmData;
		this.formID = ++COUNT_FOR_IDS;
	}
	
	public ClubEventBudget createClubEventBudget(){
		ArrayList<Double> dataForBudget = new ArrayList<Double>();
		
		dataForBudget.add((Double)hmData.get("EventBudgetVenueEntertainment"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueLocationRental"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueEquipmentRental"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueFurniture"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetVenueSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsFood"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsBeverages"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsBarCosts"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetRefreshmentsSubtotal"));
		
		dataForBudget.add((Double)hmData.get("EventBudgetServicesVenueStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSecurity"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesAVStaffTechSupport"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesCateringStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesBarStaff"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesVolunteers"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesAdvertising"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSocialMedia"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesPhotoVideography"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesTravel"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesGratuities"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetServicesSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousPrizesAwards"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousGiftBags"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousParticipantMaterials"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousDecorations"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousSignage"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousPermits"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousFees"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("EventBudgetMiscellaneousSubtotal"));

		dataForBudget.add((Double)hmData.get("EventBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("EventBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("EventBudgetTotal"));

		Club club = (Club)hmData.get("EventBudgetClub");
		ClubEvent clubEvent = (ClubEvent)hmData.get("EventBudgetEvent");

		
		this.clubEventBudget = new ClubEventBudget(dataForBudget, club, clubEvent);

		//Testing

		HashMap<Object, Object> dataToSubmit = new HashMap<>();
		dataToSubmit.put("ReportType", ReportType.CLUBEVENT_BUDGET);//ReportType
		dataToSubmit.put("ReportClub", Main.ALLCLUBS);//Club
		dataToSubmit.put("ReportTimeframe", new Timeframe());
		dataToSubmit.put("ReportFormat", ReportFormat.EXCEL);
		dataToSubmit.put("ReportEvent", null);//can be null
		dataToSubmit.put("Budget", this.clubEventBudget);

		try {
			ReportHandler.generateReport(dataToSubmit);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return clubEventBudget;

	}

	public ClubEventBudget getClubEventBudget() {
		return clubEventBudget;
	}

}
