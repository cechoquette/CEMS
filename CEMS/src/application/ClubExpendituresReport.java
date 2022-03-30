package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubExpendituresReport extends Report{
    //Report shows Expenditures in given Timeframe for selected Club, if ALLCLUBS selected, shows Expenditures for all Clubs
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private ArrayList<Expenditure> expenditures;
    private Club club;
    private static final ReportType reportType = ReportType.CLUB_EXPENDITURES;
    private LocalDate today;

    public ClubExpendituresReport(Timeframe timeframe, ReportFormat reportFormat, Club club, ArrayList<Expenditure> expenditures) {
        this.reportFormat = reportFormat;
        this.expenditures = expenditures;
        this.club = club;
        this.timeframe = timeframe;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "ClubExpendituresReport_" + reportID + "_" + this.timeframe;
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
        ClubExpendituresReport.reportID = reportID;
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
