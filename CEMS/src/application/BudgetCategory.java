package CEMS.src.application;

public enum BudgetCategory {

    EVENTS_VENUE("Events Venue"),
    EVENTS_SERVICES("Events Services"),
    EVENTS_REFRESHMENTS("Events Refreshments"),
    EVENTS_MISCELLANEOUS("Events Miscellaneous"),
    ACTIVITIES_MEETINGS("Activities Meetings"),
    ACTIVITIES_SPACE_RENTAL("Activities Space Rental"),
    ACTIVITIES_EQUIPMENT("Activities Equipment"),
    ACTIVITIES_OTHER("Activities Other"),
    FUNDRAISING_COSTS("Fundraising Costs"),
    FUNDRAISING_INCOME("Fundraising Income"),
    FUNDRAISING_PARTICIPANT_FEES("Fundraising Participant Fees"),
    FUNDRAISING_DONATIONS("Fundraising Donations"),
    MISCELLANEOUS_ADMIN_FEES("Miscellaneous Administrative Fees"),
    MISCELLANEOUS_BANKING_FEES("Miscellaneous Banking Fees"),
    MISCELLANEOUS_BANKING_INTEREST("Miscellaneous Banking Interest"),
    MISCELLANEOUS_UTILITIES("Miscellaneous Utilities"),
    MISCELLANEOUS_OTHER("Miscellaneous Other");

    private String categoryName;


    BudgetCategory(String categoryName){
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
