package CEMS.src.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClubMembershipSummaryReport extends Report{
    //Report shows summary of Club membership numbers, if ALLCLUBS selected, shows numbers for each club
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private Club club;
    private static final ReportType reportType = ReportType.CLUB_MEMBERSHIP_SUMMARY;
    private LocalDate today;

    public ClubMembershipSummaryReport(ReportFormat reportFormat, Club club) {
        this.reportFormat = reportFormat;
        this.club = club;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "Membership_Summary_Report_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {

        Object[][] reportArray;

        List<User> clubUsers = club.getClubUsers();

        if (club == Main.ALLCLUBS){
            Club[] allclubs = OptionLists.getClubs();
            reportArray = new Object[allclubs.length+1][2];

            reportArray[0][0] = "Club Name: ";
            reportArray[0][1] = "Club Members: ";

            for(int i=0; i < allclubs.length; i++){
                reportArray[i+1][0] = allclubs[i].toString();
                reportArray[i+1][1] = String.valueOf(allclubs[i].getClubUsers().size());
            }

        }
        else{
            reportArray = new Object[2][2];
            reportArray[0][0] = "Club Name: ";
            reportArray[0][1] = "Club Members: ";
            reportArray[1][0] = club.toString();//Main.CURRENTUSER.getUserClub().toString();
            reportArray[1][0] = String.valueOf(clubUsers.size());//String.valueOf(Main.CURRENTUSER.getUserClub().getClubUsers().size());
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
        ClubMembershipSummaryReport.reportID = reportID;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
