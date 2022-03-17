package application;
import java.time.LocalDate;
import java.util.Date;

public class Expenditure {
	protected static int COUNT_FOR_IDS;
	
	private int expenditureID;
	private String description;
	private String accountHolder;
	private String paymentAccount;
	private double amount;
	private double taxAmount;
	private double total;
	private Province province;
	private LocalDate date;
	private Vendor vendorName;
	private ExpenditureCategory category;
	private PaymentMethod paymentMethod;
	
	Expenditure(String description, String accountHolder, String paymentAccount, double amount, double taxAmount, double total, Province province, LocalDate date, Vendor vendorName, ExpenditureCategory category, PaymentMethod paymentMethod){
		this.expenditureID = ++COUNT_FOR_IDS;

		this.description = description;
		this.accountHolder = accountHolder;
		this.paymentAccount = paymentAccount;
		this.amount = amount;
		this.taxAmount = taxAmount;
		this.total = total;
		this.province = province;
		this.date = date;
		this.vendorName = vendorName;
		this.category = category;
		this.paymentMethod = paymentMethod;
		
	}

	public static int getCOUNT_FOR_IDS() {
		return COUNT_FOR_IDS;
	}



	public static void setCOUNT_FOR_IDS(int cOUNT_FOR_IDS) {
		COUNT_FOR_IDS = cOUNT_FOR_IDS;
	}



	public int getExpenditureID() {
		return expenditureID;
	}



	public void setExpenditureID(int expenditureID) {
		this.expenditureID = expenditureID;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public double getTaxAmount() {
		return taxAmount;
	}



	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}



	public Province getProvince() {
		return province;
	}



	public void setProvince(Province province) {
		this.province = province;
	}



	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public String getPaymentAccount() {
		return paymentAccount;
	}



	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}



	public String getAccountHolder() {
		return accountHolder;
	}



	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) { 
		this.date = date;
	}



	public Vendor getVendorName() {
		return vendorName;
	}



	public void setVendorName(Vendor vendorName) {
		this.vendorName = vendorName;
	}



	public ExpenditureCategory getCategory() {
		return category;
	}



	public void setCategory(ExpenditureCategory category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return 
				"Description: \t" + description + 
				"\nAmount: \t" + String.format("%.2f", amount) + 
				"\nTax Amount: \t" + String.format("%.2f", taxAmount) +
				"\nProvince: \t" + province + 
				"\nTotal: \t\t" + String.format("%.2f", total) +
				"\nDate: \t\t" + date +
				"\nCategory: \t" + category +
				"\nVendor Name: \t" + vendorName +
				"\nPayment Method: " + paymentMethod + 
				"\nAccount Holder: " + accountHolder +
				"\nPayment Account: " + paymentAccount; 
	}
	
}
