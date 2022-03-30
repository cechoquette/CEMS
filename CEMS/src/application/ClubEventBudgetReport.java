package CEMS.src.application;

import java.time.LocalDate;

public class ClubEventBudgetReport extends Report{
    //Report shows requested ClubEvent Budget Details
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUBEVENT_BUDGET;
    private LocalDate today;

    public ClubEventBudgetReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "EventBudgetReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {
        return new Object[0][];
    }
}
