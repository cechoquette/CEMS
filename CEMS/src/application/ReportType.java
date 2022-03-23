package application;

public enum ReportType {

	CLUB_BUDGET("Club Budget Report"),
	EVENT_BUDGET("Event Budget Report"),
	CLUB_EXPENDITURES("Club Expenditures Report"),
	EVENT_EXPENDITURES("Event Expenditures Report"),
	CLUB_MEMBERSHIP_SUMMARY("Club Membership Summary Report"),
	CLUB_MEMBERSHIP_DETAIL("Club Membership Detailed Report"),
	EVENT_ATTENDANCE("Event Attendance Report");
	
	private String typeName;
	
	ReportType(String typeName){
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return typeName;
	}
	

}
