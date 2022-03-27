package CEMS.src.application;
import java.time.LocalDate;
import java.util.HashMap;

public class ExpenditureForm extends Form{

//	private HashMap<String, Double> formfields;
//	FormField<String, Double> amount;
	private static int formID; //needs to be called from Database, or saved and retrieved at startup
	private boolean isFilled;
	private Expenditure expenditure;
	
	public ExpenditureForm(RequestType requestType, HashMap<Object, Object> hmData){
//		this.formfields = new HashMap<String, Double>();
		this.formID = ++super.COUNT_FOR_IDS;
		createExpenditure(hmData);
		
		System.out.println(expenditure);
		System.out.println(formID);
		System.out.println(expenditure.getExpenditureID());
	}
	
	public Expenditure getExpenditure() {
		return expenditure;
	}
	
	private void createExpenditure(HashMap<Object, Object> hmData) {
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
		
		this.expenditure = new Expenditure(description, accountHolder, paymentAccount, amount, taxAmount, total, province, date, vendorName, category, paymentMethod);
	}
	
//	
//	@SuppressWarnings("rawtypes")
//	@Override
//	public void addField(HashMap<Object, Object> requestData) {
//		
////		formfields.put((String)formfield.getKey(), (Double)formfield.getValue());
//		
//	}
//
//	@Override
//	public Object getField(Object key) {
//		return null;
//	}
//
//	@SuppressWarnings("rawtypes")
//	@Override
//	public void setField(HashMap<Object, Object> requestData) {
//		//Check if field already has a value, if it does, replace with new data
////		if(formfields.get(formfield.getKey()) != null) {
////			formfields.remove(formfield.getKey());
////		}
////		addField(formfield);
//		
//	}
	
	public boolean isFilled() {
		//iterate through all of the fields, check if mandatory fields are filled, then return true or false accordingly
		
		
		return isFilled;
	}

//
//	@Override
//	protected boolean delete(HashMap<Object, Object> requestData) {
//		//Expenditures cannot be deleted
//		return false;
//	}

}
