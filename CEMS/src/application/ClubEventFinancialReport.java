package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubEventFinancialReport extends Report{
    //Report shows Financial Situation of given Event (Budget - Expenditures)
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;//no need
    private String filename;
    private ReportFormat reportFormat;
    private ClubEventBudget clubEventBudget;
    private ArrayList<Expenditure> expenditures;
    private static final ReportType reportType = ReportType.CLUBEVENT_FINANCIAL_SITUATION;
    private LocalDate today;

    public ClubEventFinancialReport(ReportFormat reportFormat, ClubEventBudget clubEventBudget, ArrayList<Expenditure> expenditures) {
        this.reportFormat = reportFormat;
        this.clubEventBudget = clubEventBudget;
        this.expenditures = expenditures;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventFinancialSituationReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
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
        ClubEventFinancialReport.reportID = reportID;
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

    public ArrayList<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(ArrayList<Expenditure> expenditures) {
        this.expenditures = expenditures;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
