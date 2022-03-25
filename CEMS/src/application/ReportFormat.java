package CEMS.src.application;

public enum ReportFormat {
	EXCEL("Excel"),
	PDF("PDF"),
	PRINT("Print");
	
	String formatName;
	
	ReportFormat(String formatName){
		this.formatName = formatName;
	}
}
