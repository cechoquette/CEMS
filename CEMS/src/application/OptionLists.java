package application;


//class to use for storing arrays for drop-down menus, if you do not want to use an enumeration, or for small drop-downs
public class OptionLists {

	public static String[] paymentMethods = {
			"Visa","MasterCard","American Express","Cheque","E-Transfer","Cash","Debit"
	};
	
	public static String[] getClubs() {
		//method to get list of all clubs from database
		//call controller
		String[] clubsTemp = {"Club ABC", "Club 123", "Club XYZ"};
		
		return clubsTemp;
	}
	
	
	
	
}
