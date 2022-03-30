package CEMS.src.application;

public class ClubEventBudgetReport extends Report{
    //Report shows requested ClubEvent Budget Details

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_BUDGET;


    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
