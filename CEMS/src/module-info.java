module CEMS {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires org.apache.poi.ooxml;
	requires org.apache.pdfbox;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}