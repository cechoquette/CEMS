package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubMembershipDetailReport extends Report{
    //Report shows detailed membership of club or all clubs (if selected), including member information
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;

    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_DETAIL;
    private LocalDate today;
    private Club club;

    public ClubMembershipDetailReport(ReportFormat reportFormat, Club club) {
        this.reportFormat = reportFormat;
        this.club = club;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "MembershipDetailedReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        ArrayList<User> clubUsers = (ArrayList<User>) club.getClubUsers();




        Object[][] reportArray = new Object[clubUsers.size()+1][5];

        reportArray[0][0] = "Club: ";
        reportArray[0][1] = "First Name";
        reportArray[0][2] = "Last Name";
        reportArray[0][3] = "Email";
        reportArray[0][4] = "Student ID";




        for (int i = 0; i<clubUsers.size(); i++){
            User tempUser = clubUsers.get(i);

            reportArray[i+1][0] = tempUser.getUserClub().toString();
            reportArray[i+1][1] = tempUser.getFirstName();
            reportArray[i+1][2] = tempUser.getLastName();
            reportArray[i+1][3] = tempUser.getEmail();
            reportArray[i+1][4] = tempUser.getStudentID();


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
        ClubMembershipDetailReport.reportID = reportID;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
