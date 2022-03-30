package CEMS.src.application;

import java.time.LocalDate;

public class ClubMembershipSummaryReport extends Report{
    //Report shows summary of Club membership numbers, if ALLCLUBS selected, shows numbers for each club
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_SUMMARY;
    private LocalDate today;

    public ClubMembershipSummaryReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "MembershipSummaryReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
