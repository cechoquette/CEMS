package CEMS.src.application;

import java.time.LocalDate;

public class ClubFinancialReport extends Report{
    //Report shows Financial Situation of given Club (Budget - Expenditures) for beginning of year until given date, if ALLCLUBS selected, shows Financial Situation for all Clubs
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_FINANCIAL_SITUATION;
    private LocalDate today;

    public ClubFinancialReport(Timeframe timeframe) {
        this.timeframe = timeframe;
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "ClubExpendituresReport_" + reportID + "_" + this.timeframe;
    }

    @Override
    public Object[][] formatReport() {

        return new Object[0][];
    }
}
