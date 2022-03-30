package CEMS.src.application;

public enum ReportType {

	//Report shows requested Club Budget Details
	CLUB_BUDGET("Club Budget Report"),
	//Report shows requested ClubEvent Budget Details
	CLUBEVENT_BUDGET("Event Budget Report"),
	//Report shows Expenditures in given Timeframe for selected Club, if ALLCLUBS selected, shows Expenditures for all Clubs
	CLUB_EXPENDITURES("Club Expenditures Report"),
	//Report shows Expenditures for specific ClubEvent only
	CLUBEVENT_EXPENDITURES("Event Expenditures Report"),
	//Report shows Financial Situation of given Club (Budget - Expenditures) for beginning of year until given date, if ALLCLUBS selected, shows Financial Situation for all Clubs
	CLUB_FINANCIAL_SITUATION("Club Financial Situation Report"),
	//Report shows Financial Situation of given Event (Budget - Expenditures)
	CLUBEVENT_FINANCIAL_SITUATION("Event Financial Situation Report"),
	//Report shows summary of Club membership numbers, if ALLCLUBS selected, shows numbers for each club
	CLUB_MEMBERSHIP_SUMMARY("Club Membership Summary Report"),
	//Report shows detailed membership of club or all clubs (if selected), including member information
	CLUB_MEMBERSHIP_DETAIL("Club Membership Detailed Report"),
	//Report shows attendance numbers for given ClubEvent
	CLUBEVENT_ATTENDANCE("Event Attendance Report"),
	//Report shows a list of all given Club's ClubEvents
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
