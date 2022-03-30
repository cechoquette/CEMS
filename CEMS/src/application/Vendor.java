package CEMS.src.application;

public enum Vendor {
	
	//TODO LONG LIST
	
	AMAZON("Amazon"),
	CATERING_CO("Catering Co."),
	COUNTRY_WIDE("Country Wide Furnishing"),
	FURNITURE_GALLERY("The Furniture Gallery");

	private String vendorName;
	
	Vendor(String vendorName){
		this.vendorName = vendorName;
	}
	@Override
	public String toString() {
		return vendorName;
	}

}
