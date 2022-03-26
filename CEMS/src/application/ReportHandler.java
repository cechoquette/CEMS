package CEMS.src.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReportHandler {

	public static Report generateReport(HashMap<Object, Object> hmData) {


		return null;
	}

	public static void exportToExcel() throws IOException{

		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        String a = "aye";
        String b = "bee";
        String c = "cee";
        String d = "dee";


        Object[][] bookData = {
                {a, "Kathy Serria", 79},
                {b, "Joshua Bloch", 36},
                {c, "Robert martin", 42},
                {d, "Bruce Eckel", 35},
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }


        try {
        	String home = System.getProperty("user.home");
//        	File file = new File( fileName + ".xlsx");
        	FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + "JavaBooks3.xlsx");
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }



	}

	public static void createSamplePDF(List<String[]> valuesToExport, Path filePath) throws Exception{
		 try (PDDocument doc = new PDDocument()) {
		        PDFont font = PDType1Font.HELVETICA;
		        PDPage page = new PDPage();
		        doc.addPage(page);
		        PDPageContentStream content = new PDPageContentStream(doc, page);
		        content.setFont(font, 12);
		        int lines = 1;
		        float pageHeight = page.getMediaBox().getHeight();
		        for (String[] row : valuesToExport) {
		        int startX = 0;
		        for (String column : row) {
		            content.beginText();
		            content.newLineAtOffset(startX, pageHeight - 50 * lines);
		            startX += startX + 100;
		            content.showText(column);
		            content.endText();
		        }
		        ++lines;
		        if (lines > 10) {
		            page = new PDPage();
		            doc.addPage(page);
		            content.close();
		            content = new PDPageContentStream(doc, page);
		            content.setFont(font, 12);
		        }
		        }
		        content.close();
		        doc.save(filePath.toFile());
		    } catch (IOException ex) {
		        //either log exception or rethrow it
		    }
	}


}
