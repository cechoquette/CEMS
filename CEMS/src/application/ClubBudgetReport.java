package CEMS.src.application;


import java.time.LocalDate;


//
public class ClubBudgetReport extends Report{
    //Report shows requested Club Budget Details
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_BUDGET;
    private ClubBudget clubBudget;

    private LocalDate today;

    public ClubBudgetReport(ReportFormat reportFormat, ClubBudget clubBudget) {
        this.reportFormat = reportFormat;
        this.clubBudget = clubBudget;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "Club Budget Report_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        Object[][] reportArray =
            {{"Club: ",  clubBudget.getClub().toString()},
                {"Budget ID: ", String.valueOf(clubBudget.getClubBudgetID())},
                {"Events Venue", clubBudget.getEventsVenue()},
                {"Events Services", clubBudget.getEventsServices()},
                {"Events Refreshments", clubBudget.getEventsRefreshments()},
                {"Events Miscellaneous", clubBudget.getEventsMiscellaneous()},
                {"Events Subtotal", clubBudget.getEventsSubtotal()},
                {"Club Activities Meetings", clubBudget.getClubMeetings()},
                {"Club Activities Space Rental", clubBudget.getClubSpaceRentalOrFees()},
                {"Club Activities Equipment", clubBudget.getClubEquipment()},
                {"Club Activities Other", clubBudget.getClubActivitiesOther()},
                {"Club Activities Subtotal", clubBudget.getClubActivitiesSubtotal()},
                {"Fundraising Costs", clubBudget.getFundraisingCosts()},
                {"Fundraising Income", clubBudget.getFundraisingIncome()},
                {"Fundraising Participant Fees", clubBudget.getFundraisingParticipantFees()},
                {"Fundraising Donations", clubBudget.getFundraisingDonations()},
                {"Fundraising Subtotal", clubBudget.getFundraisingSubtotal()},
                {"Miscellaneous Administrative Fees", clubBudget.getMiscAdminFees()},
                {"Miscellaneous Banking Fees", clubBudget.getMiscBankingFees()},
                {"Miscellaneous Banking Interest", clubBudget.getMiscBankingInterestIncome()},
                {"Miscellaneous Utilities", clubBudget.getMiscUtilities()},
                {"Miscellaneous Other", clubBudget.getMiscOther()},
                {"Miscellaneous Subtotal", clubBudget.getMiscSubtotal()},
                {"Club Budget Subtotal", clubBudget.getClubBudgetSubtotal()},
                {"Club Budget Taxes", clubBudget.getClubBudgetTaxes()},
                {"Club Budget Total", clubBudget.getClubBudgetTotal()}
        };

        return reportArray;
    }

    public static int getCountForIds() {
        return COUNT_FOR_IDS;
    }

    public static void setCountForIds(int countForIds) {
        COUNT_FOR_IDS = countForIds;
    }

    public static int getReportID() {
        return reportID;
    }

    public static void setReportID(int reportID) {
        ClubBudgetReport.reportID = reportID;
    }

    public Timeframe getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(Timeframe timeframe) {
        this.timeframe = timeframe;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ReportFormat getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(ReportFormat reportFormat) {
        this.reportFormat = reportFormat;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
