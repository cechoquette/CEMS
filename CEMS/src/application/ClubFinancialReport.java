package CEMS.src.application;

public class ClubFinancialReport extends Report{
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportType reportType;
    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
