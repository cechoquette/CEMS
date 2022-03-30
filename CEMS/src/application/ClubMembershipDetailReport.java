package CEMS.src.application;

public class ClubMembershipDetailReport extends Report{
    //Report shows detailed membership of club or all clubs (if selected), including member information

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_DETAIL;

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
