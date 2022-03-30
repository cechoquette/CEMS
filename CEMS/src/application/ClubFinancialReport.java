package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubFinancialReport extends Report{
    //Report shows Financial Situation of given Club (Budget - Expenditures) for beginning of year until given date, if ALLCLUBS selected, shows Financial Situation for all Clubs
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private ClubBudget clubBudget;
    private ArrayList<Expenditure> expenditures;
    private static final ReportType reportType = ReportType.CLUB_FINANCIAL_SITUATION;
    private LocalDate today;

    public ClubFinancialReport(Timeframe timeframe, ReportFormat reportFormat, ClubBudget clubBudget, ArrayList<Expenditure> expenditures) {
        this.reportFormat = reportFormat;
        this.timeframe = timeframe;
        this.clubBudget = clubBudget;
        this.expenditures = expenditures;
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
        ClubFinancialReport.reportID = reportID;
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

    public ClubBudget getClubBudget() {
        return clubBudget;
    }

    public void setClubBudget(ClubBudget clubBudget) {
        this.clubBudget = clubBudget;
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
