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
        this.filename = "EventBudgetReport_" + reportID + "_" + today;
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
