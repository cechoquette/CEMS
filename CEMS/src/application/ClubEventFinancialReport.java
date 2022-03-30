package CEMS.src.application;

import java.time.LocalDate;

public class ClubEventFinancialReport extends Report{
    //Report shows Financial Situation of given Event (Budget - Expenditures)
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;//no need
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_FINANCIAL_SITUATION;
    private LocalDate today;

    public ClubEventFinancialReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventFinancialSituationReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
