package CEMS.src.application;

import java.time.LocalDate;

public class ClubEventsSummaryReport extends Report {
    //Report shows a list of all given Club's ClubEvents
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENTS_SUMMARY;
    private LocalDate today;

    public ClubEventsSummaryReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventsSummaryReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
