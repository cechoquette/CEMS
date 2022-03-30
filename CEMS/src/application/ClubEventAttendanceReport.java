package CEMS.src.application;

public class ClubEventAttendanceReport extends Report{
    //Report shows attendance numbers for given ClubEvent

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_ATTENDANCE;

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
