package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubEventExpendituresReport extends Report{
    //Report shows Expenditures for specific ClubEvent only

    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private ClubEvent clubEvent;
    private ArrayList<Expenditure> expenditures;
    private static final ReportType reportType = ReportType.CLUBEVENT_EXPENDITURES;
    private LocalDate today;

    public ClubEventExpendituresReport(ReportFormat reportFormat, ClubEvent clubEvent, ArrayList<Expenditure> expenditures) {
        this.reportFormat = reportFormat;
        this.clubEvent = clubEvent;
        this.expenditures = expenditures;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventBudgetReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        Object[][] reportArray = new Object[expenditures.size() + 5][14];

        reportArray[0][0] = "Expenditure_ID";
        reportArray[0][1] = "Club";
        reportArray[0][2] = "Club_Event";
        reportArray[0][3] = "Description";
        reportArray[0][4] = "Vendor_Name";
        reportArray[0][5] = "Category";
        reportArray[0][6] = "Account_Holder";
        reportArray[0][7] = "Payment_Account";
        reportArray[0][8] = "Payment_Method";
        reportArray[0][9] = "Province";
        reportArray[0][10] = "Date";
        reportArray[0][11] = "Subtotal";
        reportArray[0][12] = "Taxes";
        reportArray[0][13] = "Total";


        for (int i = 1; i < expenditures.size()+1; i++){

            reportArray[i][0] = (Integer)expenditures.get(i-1).getExpenditureID();
            reportArray[i][1] = expenditures.get(i-1).getClub().toString();
            if (expenditures.get(i-1).getEvent() != null)
                reportArray[i][2] = expenditures.get(i-1).getEvent();
            else
                reportArray[i][2] = "N/A";
            reportArray[i][3] = expenditures.get(i-1).getDescription();
            reportArray[i][4] = expenditures.get(i-1).getVendorName().toString();
            reportArray[i][5] = expenditures.get(i-1).getCategory().toString();
            reportArray[i][6] = expenditures.get(i-1).getAccountHolder();
            reportArray[i][7] = expenditures.get(i-1).getPaymentAccount();
            reportArray[i][8] = expenditures.get(i-1).getPaymentMethod().toString();
            reportArray[i][9] = expenditures.get(i-1).getProvince().toString();
            reportArray[i][10] = expenditures.get(i-1).getDate().toString();
            reportArray[i][11] = String.valueOf(expenditures.get(i-1).getAmount());
            reportArray[i][12] = String.valueOf(expenditures.get(i-1).getTaxAmount());
            reportArray[i][13] = String.valueOf(expenditures.get(i-1).getTotal());
        }

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
        ClubEventExpendituresReport.reportID = reportID;
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

    public ClubEvent getClubEvent() {
        return clubEvent;
    }

    public void setClubEvent(ClubEvent clubEvent) {
        this.clubEvent = clubEvent;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
