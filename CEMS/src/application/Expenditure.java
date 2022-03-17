package application;
import java.util.Date;

public class Expenditure {
	protected static int COUNT_FOR_IDS;
	
	private int expenditureID;
	private double amount;
	private double taxAmount;
	private Province province;
	private PaymentMethod paymentMethod;
	private String paymentAccount;
	private String payeeName;
	private String description;
	private Date date;
	private Vendor vendorName;
	private ExpenditureCategory category;
	
	Expenditure(){
		this.expenditureID = ++COUNT_FOR_IDS;
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



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public String getPaymentAccount() {
		return paymentAccount;
	}



	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}



	public String getPayeeName() {
		return payeeName;
	}



	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getVendorName() {
		return vendorName;
	}



	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}
	
}
