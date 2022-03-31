package CEMS.src.application;

import java.time.LocalDate;

public class ClubEventBudgetReport extends Report{
    //Report shows requested ClubEvent Budget Details
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private ClubEventBudget clubEventBudget;
    private static final ReportType reportType = ReportType.CLUBEVENT_BUDGET;
    private LocalDate today;

    public ClubEventBudgetReport(ReportFormat reportFormat, ClubEventBudget clubEventBudget) {
        this.reportFormat = reportFormat;
        this.clubEventBudget = clubEventBudget;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "Event_Budget_Report_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        Object[][] reportArray =
                {{"Club: ", clubEventBudget.getClub().toString()},
                        {"Event: ", clubEventBudget.getClubEvent().toString()},
                        {"Budget ID: ", String.valueOf(clubEventBudget.getEventBudgetID())},
                        {"Venue: ", " "},
                        {"Venue Entertainment ", clubEventBudget.getVenueEntertainment()},
                        {"Venue Location Rental ", clubEventBudget.getVenueLocationRental()},
                        {"Venue Equipment Rental ", clubEventBudget.getVenueEquipmentRental()},
                        {"VenueFurnitureRental ", clubEventBudget.getVenueFurnitureRental()},
                        {"VenueOther ", clubEventBudget.getVenueOther()},
                        {"VenueSubtotal ", clubEventBudget.getVenueSubtotal()},
                        {"Services: ", " "},
                        {"Services Venue Staff ", clubEventBudget.getServicesVenueStaff()},
                        {"Services Security ", clubEventBudget.getServicesSecurity()},
                        {"Services AV Tech Staff ", clubEventBudget.getServicesAVTechStaff()},
                        {"Services Catering Staff ", clubEventBudget.getServicesCateringStaff()},
                        {"Services Bar Staff ", clubEventBudget.getServicesBarStaff()},
                        {"Services Volunteers ", clubEventBudget.getServicesVolunteers()},
                        {"Services Advertising ", clubEventBudget.getServicesAdvertising()},
                        {"Services Social Media ", clubEventBudget.getServicesSocialMedia()},
                        {"Services Photography & Videography ", clubEventBudget.getServicesPhotoVideography()},
                        {"Services Travel ", clubEventBudget.getServicesTravel()},
                        {"Services Gratuities ", clubEventBudget.getServicesGratuities()},
                        {"Services Other ", clubEventBudget.getServicesOther()},
                        {"Services Subtotal ", clubEventBudget.getServicesSubtotal()},
                        {"Refreshments: ", " "},
                        {"Refreshments Food ", clubEventBudget.getRefreshmentsFood()},
                        {"Refreshments Beverages ", clubEventBudget.getRefreshmentsBeverages()},
                        {"Refreshments BarCosts ", clubEventBudget.getRefreshmentsBarCosts()},
                        {"Refreshments Other ", clubEventBudget.getRefreshmentsOther()},
                        {"Refreshments Subtotal ", clubEventBudget.getRefreshmentsSubtotal()},
                        {"Miscellaneous: ", " "},
                        {"Miscellaneous PrizesAwards ", clubEventBudget.getMiscPrizesAwards()},
                        {"Miscellaneous GiftBags ", clubEventBudget.getMiscGiftBags()},
                        {"Miscellaneous ParticipantMaterials ", clubEventBudget.getMiscParticipantMaterials()},
                        {"Miscellaneous Decorations ", clubEventBudget.getMiscDecorations()},
                        {"Miscellaneous Signage ", clubEventBudget.getMiscSignage()},
                        {"Miscellaneous Permits ", clubEventBudget.getMiscPermits()},
                        {"Miscellaneous Fees ", clubEventBudget.getMiscFees()},
                        {"Miscellaneous Other ", clubEventBudget.getMiscOther()},
                        {"Miscellaneous Subtotal ", clubEventBudget.getMiscSubtotal()},
                        {"Total: ", " "},
                        {"Event Budget Subtotal ", clubEventBudget.getEventBudgetSubtotal()},
                        {"Event Budget Taxes ", clubEventBudget.getEventBudgetTaxes()},
                        {"Event Budget Total ", clubEventBudget.getEventBudgetTotal()}

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
        ClubEventBudgetReport.reportID = reportID;
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

    public ClubEventBudget getClubEventBudget() {
        return clubEventBudget;
    }

    public void setClubEventBudget(ClubEventBudget clubEventBudget) {
        this.clubEventBudget = clubEventBudget;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
