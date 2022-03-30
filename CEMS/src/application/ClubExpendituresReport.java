package CEMS.src.application;

import java.time.LocalDate;

public class ClubExpendituresReport extends Report{
    //Report shows Expenditures in given Timeframe for selected Club, if ALLCLUBS selected, shows Expenditures for all Clubs
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_EXPENDITURES;
    private LocalDate today;

    public ClubExpendituresReport() {
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}