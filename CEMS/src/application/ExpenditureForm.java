package CEMS.src.application;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpenditureForm extends Form{

//	private HashMap<String, Double> formfields;
//	FormField<String, Double> amount;
	private static int formID; //needs to be called from Database, or saved and retrieved at startup
	private boolean isFilled;
	private Expenditure expenditure;
	private HashMap<Object, Object> hmData;
	
	public ExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData){
		this.hmData = hmData;

		this.formID = ++super.COUNT_FOR_IDS;


	}
	
	public Expenditure getExpenditure() {
		return expenditure;
	}
	
	public Expenditure createExpenditure() {
		String description = (String)hmData.get("ExpenditureDescription");
		String accountHolder = (String)hmData.get("ExpenditureAccountHolder");
		String paymentAccount = (String)hmData.get("ExpenditureAccount");
		double amount = (Double)hmData.get("ExpenditureAmount");
		double taxAmount = (Double)hmData.get("ExpenditureTax");
		double total = (Double)hmData.get("ExpenditureTotal");
		Province province = (Province)hmData.get("ExpenditureProvince");
		LocalDate date = (LocalDate)hmData.get("ExpenditureDate");
		Vendor vendorName = (Vendor)hmData.get("ExpenditureVendor");
		ExpenditureCategory category = (ExpenditureCategory)hmData.get("ExpenditureCategory");
		PaymentMethod paymentMethod = (PaymentMethod)hmData.get("ExpenditurePaymentMethod");
		Club club = (Club)hmData.get("ExpenditureClub");
		ClubEvent clubEvent;
		if(hmData.get("ExpenditureEvent") != null) {
			clubEvent = (ClubEvent)hmData.get("ExpenditureEvent");//can be null
		}
		else{
			clubEvent = null;
		}

		/* Keys for HashMap
		ExpenditureDescription
		ExpenditurePayee
		ExpenditureAccount
		ExpenditureAmount
		ExpenditureTax
		ExpenditureProvince
		ExpenditureDate
		ExpenditureVendor
		ExpenditureCategory
		ExpenditurePaymentMethod
		*/
		
		this.expenditure = new Expenditure(description, accountHolder, paymentAccount, amount, taxAmount,
				total, province, date, vendorName, category, paymentMethod, club, clubEvent);

		//Testing

		System.out.println(expenditure);
		System.out.println("FormID: " + formID);
		System.out.println("ExpID: " + expenditure.getExpenditureID());
		System.out.println("Club: " + expenditure.getClub());
		System.out.println("Event: " + expenditure.getEvent());

		ArrayList<Expenditure> al = new ArrayList<>();
		al.add(expenditure);

		HashMap<Object, Object> dataToSubmit = new HashMap<>();
		dataToSubmit.put("ReportType", ReportType.CLUB_EXPENDITURES);//ReportType
		dataToSubmit.put("ReportClub", Main.ALLCLUBS);//Club
		dataToSubmit.put("ReportTimeframe", new Timeframe());
		dataToSubmit.put("ReportFormat", ReportFormat.PDF);
		dataToSubmit.put("ReportEvent", null);//can be null
		dataToSubmit.put("Expenditures", al);

		try {
			ReportHandler.generateReport(dataToSubmit);
		} catch (Exception e) {
			e.printStackTrace();
		}




		return expenditure;
	}
	
	public boolean isFilled() {
		//iterate through all of the fields, check if mandatory fields are filled, then return true or false accordingly
		
		
		return isFilled;
	}

}
