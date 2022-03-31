package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubEventsSummaryReport extends Report {
    //Report shows a list of all given Club's ClubEvents
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENTS_SUMMARY;
    private LocalDate today;
    private ArrayList<ClubEvent> clubEvents;

    public ClubEventsSummaryReport(ReportFormat reportFormat, ArrayList<ClubEvent> clubEvents) {
        this.reportFormat = reportFormat;
        this.clubEvents = clubEvents;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "Events_Summary_Report_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        Object[][] reportArray = new Object[clubEvents.size()+1][5];

        reportArray[0][0] = "Club: ";
        reportArray[0][1] = "Date & Time";
        reportArray[0][2] = "Event Name";
        reportArray[0][3] = "Location";
        reportArray[0][4] = "Description";




        for (int i = 0; i<clubEvents.size(); i++) {
            ClubEvent tempEvent = clubEvents.get(i);

            reportArray[i+1][0] = tempEvent.getClub().toString();
            reportArray[i+1][1] = tempEvent.getEventDateTime();
            reportArray[i+1][2] = tempEvent.getEventName();
            reportArray[i+1][3] = tempEvent.getEventLocation();
            reportArray[i+1][4] = tempEvent.getEventDescription();
        }

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
        ClubEventsSummaryReport.reportID = reportID;
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

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public ArrayList<ClubEvent> getClubEvents() {
        return clubEvents;
    }

    public void setClubEvents(ArrayList<ClubEvent> clubEvents) {
        this.clubEvents = clubEvents;
    }
}
