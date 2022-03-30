package CEMS.src.application;

public abstract class Report {
	private static int reportID;
	private Timeframe timeframe;
	private String filename;
	private ReportType reportType;
	
	
//	public abstract Report generateReport();


	public abstract Object[][] formatReport();
	
}
