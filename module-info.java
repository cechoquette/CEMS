module CEMS {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
    requires org.apache.poi.ooxml;
	requires org.apache.pdfbox;
	requires java.persistence;
    requires org.hibernate.orm.core;
	requires java.sql;
	requires org.mybatis;

	opens CEMS.src.application to javafx.graphics, javafx.fxml,org.hibernate.orm.core;
    opens CEMS.src.controllers to javafx.fxml, javafx.graphics;
}
