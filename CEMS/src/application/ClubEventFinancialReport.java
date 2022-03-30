package CEMS.src.application;

public class ClubEventFinancialReport extends Report{
    //Report shows Financial Situation of given Event (Budget - Expenditures)

    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_FINANCIAL_SITUATION;
    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
