package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubBudgetForm extends Form{
	public static int COUNT_FOR_IDS;
	private static int formID;
	private boolean isFilled;
	private ClubBudget clubBudget;
	private HashMap<Object, Object> hmData;

	ClubBudgetForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.hmData = hmData;
		this.formID = ++COUNT_FOR_IDS;
	}
	
	public ClubBudget createClubBudget(){
		ArrayList<Double> dataForBudget = new ArrayList<Double>();

		dataForBudget.add((Double)hmData.get("ClubBudgetEventsVenue"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsServices"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsRefreshments"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsMiscellaneous"));
		dataForBudget.add((Double)hmData.get("ClubBudgetEventsSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesMeetings"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesSpaceRental"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesEquipment"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesOther"));
		dataForBudget.add((Double)hmData.get("ClubBudgetActivitiesSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingCosts"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingIncome"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingParticipantFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingDonations"));
		dataForBudget.add((Double)hmData.get("ClubBudgetFundraisingSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousAdministrativeFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousBankingFees"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousBankingInterest"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousUtilities"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousOther"));
		dataForBudget.add((Double)hmData.get("ClubBudgetMiscellaneousSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetSubtotal"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTaxes"));
		dataForBudget.add((Double)hmData.get("ClubBudgetTotal"));
		Club clubBudgetClub = (Club)hmData.get("ClubBudgetClub");
		
//		for(int i = 0; i < dataForBudget.size(); i++) {
//			System.out.println(dataForBudget.get(i));
//		}
		
		this.clubBudget = new ClubBudget(dataForBudget, clubBudgetClub);

		//Testing




//		ClubBudgetReport testing:
//		HashMap<Object, Object> dataToSubmit = new HashMap<>();
//		dataToSubmit.put("ReportType", ReportType.CLUB_BUDGET);//ReportType
//		dataToSubmit.put("ReportClub", Main.ALLCLUBS);//Club
//		dataToSubmit.put("ReportTimeframe", new Timeframe());
//		dataToSubmit.put("ReportFormat", ReportFormat.EXCEL);
//		dataToSubmit.put("ReportEvent", null);//can be null
//		dataToSubmit.put("ClubBudget", clubBudget);
//
//		try {
//			ReportHandler.generateReport(dataToSubmit);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		//ClubMembershipSummaryReport testing:
		HashMap<Object, Object> dataToSubmit = new HashMap<>();
		dataToSubmit.put("ReportType", ReportType.CLUB_MEMBERSHIP_SUMMARY);//ReportType
		dataToSubmit.put("ReportClub", Main.ALLCLUBS);//Club
		dataToSubmit.put("ReportTimeframe", new Timeframe());
		dataToSubmit.put("ReportFormat", ReportFormat.EXCEL);
		dataToSubmit.put("ReportEvent", null);//can be null
		dataToSubmit.put("Club", Main.ALLCLUBS);

		try {
			ReportHandler.generateReport(dataToSubmit);
		} catch (Exception e) {
			e.printStackTrace();
		}




		return clubBudget;
	}
	
	public ClubBudget getClubBudget() {
		return clubBudget;
	}

}
