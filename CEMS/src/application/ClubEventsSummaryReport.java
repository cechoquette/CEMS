package CEMS.src.application;

public class ClubEventsSummaryReport extends Report {
    //Report shows a list of all given Club's ClubEvents

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENTS_SUMMARY;
    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
