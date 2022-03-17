package application;

public enum PaymentMethod {
	
	VISA("Visa"), 
	MASTERCARD("MasterCard"),
	AMEX("American Express"),
	CHEQUE("Cheque"),
	ETRANSFER("E-Transfer"),
	CASH("Cash"),
	DEBIT("Debit");
	
	private String methodName;
	
	PaymentMethod(String methodName){
		this.methodName = methodName;
	}
	@Override
	public String toString() {
		return methodName;
	}
}
