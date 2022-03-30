package CEMS.src.application;


import java.time.LocalDate;


//
public class ClubBudgetReport extends Report{
    //Report shows requested Club Budget Details
    public static int COUNT_FOR_IDS;
    private static int reportID;
    private Timeframe timeframe;
    private String filename;
    private ReportFormat reportFormat;
    private static final ReportType reportType = ReportType.CLUB_BUDGET;

    private LocalDate today;

    public ClubBudgetReport() {
        this.today = LocalDate.now();
        this.reportID = ++COUNT_FOR_IDS;
        this.filename = "ClubBudgetReport_" + reportID + "_" + today;
    }

    @Override
    public Object[][] formatReport() {

        return new Object[0][];
    }
}
