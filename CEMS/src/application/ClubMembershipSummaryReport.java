package CEMS.src.application;

public class ClubMembershipSummaryReport extends Report{
    //Report shows summary of Club membership numbers, if ALLCLUBS selected, shows numbers for each club

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_SUMMARY;

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
