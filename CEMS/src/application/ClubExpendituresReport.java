package CEMS.src.application;

public class ClubExpendituresReport extends Report{
    //Report shows Expenditures in given Timeframe for selected Club, if ALLCLUBS selected, shows Expenditures for all Clubs

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_EXPENDITURES;
    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
