package CEMS.src.application;


//
public class ClubBudgetReport extends Report{
    //Report shows requested Club Budget Details

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_BUDGET;



    @Override
    public Object[][] formatReport() {

        return new Object[0][];
    }
}
