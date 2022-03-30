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
        this.filename = "ClubBudgetReport_" + reportID + "_" + today;
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
