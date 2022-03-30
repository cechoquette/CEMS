package CEMS.src.application;

import java.time.LocalDate;

public class ClubMembershipSummaryReport extends Report{
    //Report shows summary of Club membership numbers, if ALLCLUBS selected, shows numbers for each club
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private Club club;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_SUMMARY;
    private LocalDate today;

    public ClubMembershipSummaryReport(ReportFormat reportFormat, Club club) {
        this.reportFormat = reportFormat;
        this.club = club;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "MembershipSummaryReport_" + reportID + "_" + today;
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
        ClubMembershipSummaryReport.reportID = reportID;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
