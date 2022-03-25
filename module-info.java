module CEMS {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
    requires org.apache.poi.ooxml;
	requires org.apache.pdfbox;

	
	opens application to javafx.graphics, javafx.fxml;
    opens controllers to javafx.fxml, javafx.graphics;
}
