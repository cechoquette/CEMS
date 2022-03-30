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
