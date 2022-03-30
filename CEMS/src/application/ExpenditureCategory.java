package CEMS.src.application;

public enum ExpenditureCategory {
		
	EVENTS_VENUE_ENTERTAINMENT("Events Venue Entertainment", BudgetCategory.EVENTS_VENUE),
	EVENTS_VENUE_LOCATION_RENTAL("Events Venue Location Rental", BudgetCategory.EVENTS_VENUE),
	EVENTS_VENUE_EQUIPMENT_RENTAL("Events Venue Equipment Rental", BudgetCategory.EVENTS_VENUE),
	EVENTS_VENUE_FURNITURE("Events Venue Furniture", BudgetCategory.EVENTS_VENUE),
	EVENTS_VENUE_OTHER("Events Venue Other", BudgetCategory.EVENTS_VENUE),

	EVENTS_REFRESHMENTS_FOOD("Events Refreshments Food", BudgetCategory.EVENTS_REFRESHMENTS),
	EVENTS_REFRESHMENTS_BEVERAGES("Events Refreshments Beverages", BudgetCategory.EVENTS_REFRESHMENTS),
	EVENTS_REFRESHMENTS_BAR_COSTS("Events Refreshments Bar Costs", BudgetCategory.EVENTS_REFRESHMENTS),
	EVENTS_REFRESHMENTS_OTHER("Events Refreshments Other", BudgetCategory.EVENTS_REFRESHMENTS),


	EVENTS_SERVICES_VENUE_STAFF("Events Services Venue Staff", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_SECURITY("Events Services Security", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_AV_TECH("Events Services AV Staff Tech Support", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_CATERING("Events Services Catering Staff", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_BAR_STAFF("Events Services Bar Staff", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_VOLUNTEERS("Events Services Volunteers", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_ADVERTISING("Events Services Advertising", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_SOCIAL_MEDIA("Events Services Social Media", BudgetCategory.EVENTS_SERVICES),
	EVENTS_SERVICES_PHOTOGRAPHY_VIDEOGRAPHY("Events Services Photography & Videography", BudgetCategory.EVENTS_SERVICES),
	SERVICES_TRAVEL("Events Services Travel", BudgetCategory.EVENTS_SERVICES),
	SERVICES_GRATUITIES("Events Services Gratuities", BudgetCategory.EVENTS_SERVICES),
	SERVICES_OTHER("Events Services Other", BudgetCategory.EVENTS_SERVICES),
	
	
	MISCELLANEOUS_PRIZES_AWARDS("Events Miscellaneous Prizes Awards", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_GIFT_BAGS("Events Miscellaneous Gift Bags", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_PARTICIPANT_MATERIALS("Events Miscellaneous Participant Materials", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_DECORATIONS("Events Miscellaneous Decorations", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_SIGNAGE("Events Miscellaneous Signage", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_PERMITS("Events Miscellaneous Permits", BudgetCategory.EVENTS_MISCELLANEOUS),
	MISCELLANEOUS_FEES("Events Miscellaneous Fees", BudgetCategory.EVENTS_MISCELLANEOUS),
	EVENTS_MISCELLANEOUS_OTHER("Events Events Miscellaneous Other", BudgetCategory.EVENTS_MISCELLANEOUS),
	
	ACTIVITIES_MEETINGS("Activities Meetings", BudgetCategory.ACTIVITIES_MEETINGS),
	ACTIVITIES_SPACE_RENTAL("Activities Space Rental", BudgetCategory.ACTIVITIES_SPACE_RENTAL),
	ACTIVITIES_EQUIPMENT("Activities Equipment", BudgetCategory.ACTIVITIES_EQUIPMENT),
	ACTIVITIES_OTHER("Activities Other", BudgetCategory.ACTIVITIES_OTHER),
	FUNDRAISING_COSTS("Fundraising Costs", BudgetCategory.FUNDRAISING_COSTS),
	FUNDRAISING_INCOME("Fundraising Income", BudgetCategory.FUNDRAISING_INCOME),
	FUNDRAISING_PARTICIPANT_FEES("Fundraising Participant Fees", BudgetCategory.FUNDRAISING_PARTICIPANT_FEES),
	FUNDRAISING_DONATIONS("Fundraising Donations", BudgetCategory.FUNDRAISING_DONATIONS),
	MISCELLANEOUS_ADMIN_FEES("Miscellaneous Administrative Fees", BudgetCategory.MISCELLANEOUS_ADMIN_FEES),
	MISCELLANEOUS_BANKING_FEES("Miscellaneous Banking Fees", BudgetCategory.MISCELLANEOUS_BANKING_FEES),
	MISCELLANEOUS_BANKING_INTEREST("Miscellaneous Banking Interest", BudgetCategory.MISCELLANEOUS_BANKING_INTEREST),
	MISCELLANEOUS_UTILITIES("Miscellaneous Utilities", BudgetCategory.MISCELLANEOUS_UTILITIES),
	MISCELLANEOUS_OTHER("Budget Miscellaneous Other", BudgetCategory.MISCELLANEOUS_OTHER);

	
	private String categoryName;
	private BudgetCategory budgetCategory;

	ExpenditureCategory(String category, BudgetCategory budgetCategory){
		this.categoryName = category;
		this.budgetCategory = budgetCategory;
	}

	public BudgetCategory getBudgetCategory(){
		return budgetCategory;
	}

	@Override
	public String toString() {
		return categoryName;
	}


}
