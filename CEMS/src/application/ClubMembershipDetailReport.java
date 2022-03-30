package CEMS.src.application;

import java.time.LocalDate;

public class ClubMembershipDetailReport extends Report{
    //Report shows detailed membership of club or all clubs (if selected), including member information
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_DETAIL;
    private LocalDate today;

    public ClubMembershipDetailReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "MembershipDetailedReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
