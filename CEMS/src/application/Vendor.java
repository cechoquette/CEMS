package application;

public enum Vendor {
	
	//TODO LONG LIST
	
	AMAZON("Amazon"),
	CATERING_CO("Catering Co.");

	private String vendorName;
	
	Vendor(String vendorName){
		this.vendorName = vendorName;
	}
	@Override
	public String toString() {
		return vendorName;
	}

}
