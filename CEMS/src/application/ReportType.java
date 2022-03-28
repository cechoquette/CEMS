package CEMS.src.application;

public enum ReportType {

	CLUB_BUDGET("Club Budget Report"),
	CLUBEVENT_BUDGET("Event Budget Report"),
	CLUB_EXPENDITURES("Club Expenditures Report"),
	CLUBEVENT_EXPENDITURES("Event Expenditures Report"),
	CLUB_FINANCIAL_SITUATION("Club Financial Situation Report"),
	CLUB_MEMBERSHIP_SUMMARY("Club Membership Summary Report"),
	CLUB_MEMBERSHIP_DETAIL("Club Membership Detailed Report"),
	CLUBEVENT_ATTENDANCE("Event Attendance Report"),
	CLUBEVENTS_SUMMARY("Club Events Summary Report");
	
	private String typeName;
	
	ReportType(String typeName){
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return typeName;
	}
	

}
