package CEMS.src.application;

import java.time.LocalDate;

public class ClubEventAttendanceReport extends Report{
    //Report shows attendance numbers for given ClubEvent
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_ATTENDANCE;
    private LocalDate today;

    public ClubEventAttendanceReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventAttendanceReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
