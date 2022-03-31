package CEMS.src.application;

import java.time.LocalDate;
import java.util.List;

public class ClubEventAttendanceReport extends Report{
    //Report shows attendance numbers for given ClubEvent
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private ClubEvent clubEvent;
    private static final ReportType reportType = ReportType.CLUBEVENT_ATTENDANCE;
    private LocalDate today;

    public ClubEventAttendanceReport(ReportFormat reportFormat, ClubEvent clubEvent) {
        this.reportFormat = reportFormat;
        this.clubEvent = clubEvent;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "Event_Attendance_Report_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        Object[][] reportArray = new Object[2][3];;

            reportArray[0][0] = "Club";
            reportArray[0][1] = "Event Name";
            reportArray[0][2] = "Attendance";

            reportArray[1][0] = clubEvent.getClub().toString();
            reportArray[1][1] = clubEvent.getEventName();
            reportArray[1][2] = clubEvent.getAttendance();

        return reportArray;
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
        ClubEventAttendanceReport.reportID = reportID;
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

    public ClubEvent getClubEvent() {
        return clubEvent;
    }

    public void setClubEvent(ClubEvent clubEvent) {
        this.clubEvent = clubEvent;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
