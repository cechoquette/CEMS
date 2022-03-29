package CEMS.src.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
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

		ReportType reportType = (ReportType)hmData.get("ReportType");
		Object object = hmData.get("Object");

		switch(reportType){

			case CLUB_BUDGET:

			case CLUBEVENT_BUDGET: formatClubEventBudgetReport((ClubEventBudget) object);

			case CLUB_EXPENDITURES:

			case CLUBEVENT_EXPENDITURES:

			case CLUB_FINANCIAL_SITUATION:

			case CLUB_MEMBERSHIP_SUMMARY:

			case CLUB_MEMBERSHIP_DETAIL:

			case CLUBEVENT_ATTENDANCE:

			case CLUBEVENTS_SUMMARY:
				break;

			default: break;


		}

		return null;
	}

	public static void exportToExcel(String fileName, Object[][] strings) throws IOException{

		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

//        String a = "aye";
//        String b = "bee";
//        String c = "cee";
//        String d = "dee";
//
//
//        String[][] bookData = {
//                {a, "Kathy Serria", "79.99"},
//                {b, "Joshua Bloch", "36.90"},
//                {c, "Robert martin", "42.04"},
//                {d, "Bruce Eckel", "35.00"},
//        };

        int rowCount = 0;

        for (Object[] strArray : strings) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : strArray) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                }
            }

        }


        try {
        	String home = System.getProperty("user.home");
//        	File file = new File( fileName + ".xlsx");
        	FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + fileName + ".xlsx");
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }



	}

	public static void createSamplePDF(List<String[]> valuesToExport, String fileName) throws Exception{
		 try (PDDocument doc = new PDDocument()) {

//			 = new ArrayList<>();
//			valuesToExport.add(new String[]{"Title1", "Title2", "Title3"});
//			valuesToExport.add(new String[]{"123", "456", "789"});
//			valuesToExport.add(new String[]{"abc", "def", "ghi"});
			String home = System.getProperty("user.home");

			FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + fileName + ".pdf");


			PDFont font = PDType1Font.HELVETICA;
			PDPage page = new PDPage();
			doc.addPage(page);

			PDPageContentStream content = new PDPageContentStream(doc, page);
			content.setFont(font, 12);

			int lines = 1;
			float pageHeight = page.getMediaBox().getHeight();
			for (String[] row : valuesToExport) {

				int startX = 100;
				for (String column : row) {
					content.beginText();
//					content.moveTo(100, 100);
					content.newLineAtOffset(startX, pageHeight - 300 * lines);
					startX += startX + 350;
					content.showText(column);
					content.endText();
				}
				++lines;
				if (lines > 10) {
					lines = 1;
					page = new PDPage();
					doc.addPage(page);
					content.close();
					content = new PDPageContentStream(doc, page);
					content.setFont(font, 12);
				}
			}
			content.close();
			doc.save(outputStream);
		} catch (IOException ex) {
			//either log exception or rethrow it
		}
	}

	public static Object[][] formatClubEventBudgetReport(ClubEventBudget clubEventBudget){

		Object[][] reportArray =
		{{"Club: ", clubEventBudget.getClub().toString()},
			{"Event: ", clubEventBudget.getClubEvent().toString()},
			{"Budget ID: ", String.valueOf(clubEventBudget.getEventBudgetID())},
			{"Venue: ", " "},
				{"Venue Entertainment ", clubEventBudget.getVenueEntertainment()},
			{"Venue Entertainment ", clubEventBudget.getVenueEntertainment()},
			{"Venue Location Rental ", clubEventBudget.getVenueLocationRental()},
			{"Venue Equipment Rental ", clubEventBudget.getVenueEquipmentRental()},
			{"VenueFurnitureRental ", clubEventBudget.getVenueFurnitureRental()},
			{"VenueOther ", clubEventBudget.getVenueOther()},
			{"VenueSubtotal ", clubEventBudget.getVenueSubtotal()},
			{"Services: ", " "},
			{"Services Venue Staff ", clubEventBudget.getServicesVenueStaff()},
			{"Services Security ", clubEventBudget.getServicesSecurity()},
			{"Services AV Tech Staff ", clubEventBudget.getServicesAVTechStaff()},
			{"Services Catering Staff ", clubEventBudget.getServicesCateringStaff()},
			{"Services Bar Staff ", clubEventBudget.getServicesBarStaff()},
			{"Services Volunteers ", clubEventBudget.getServicesVolunteers()},
			{"Services Advertising ", clubEventBudget.getServicesAdvertising()},
			{"Services Social Media ", clubEventBudget.getServicesSocialMedia()},
			{"Services Photography & Videography ", clubEventBudget.getServicesPhotoVideography()},
			{"Services Travel ", clubEventBudget.getServicesTravel()},
			{"Services Gratuities ", clubEventBudget.getServicesGratuities()},
			{"Services Other ", clubEventBudget.getServicesOther()},
			{"Services Subtotal ", clubEventBudget.getServicesSubtotal()},
			{"Refreshments: ", " "},
			{"Refreshments Food ", clubEventBudget.getRefreshmentsFood()},
			{"Refreshments Beverages ", clubEventBudget.getRefreshmentsBeverages()},
			{"Refreshments BarCosts ", clubEventBudget.getRefreshmentsBarCosts()},
			{"Refreshments Other ", clubEventBudget.getRefreshmentsOther()},
			{"Refreshments Subtotal ", clubEventBudget.getRefreshmentsSubtotal()},
			{"Miscellaneous: ", " "},
			{"Miscellaneous PrizesAwards ", clubEventBudget.getMiscPrizesAwards()},
			{"Miscellaneous GiftBags ", clubEventBudget.getMiscGiftBags()},
			{"Miscellaneous ParticipantMaterials ", clubEventBudget.getMiscParticipantMaterials()},
			{"Miscellaneous Decorations ", clubEventBudget.getMiscDecorations()},
			{"Miscellaneous Signage ", clubEventBudget.getMiscSignage()},
			{"Miscellaneous Permits ", clubEventBudget.getMiscPermits()},
			{"Miscellaneous Fees ", clubEventBudget.getMiscFees()},
			{"Miscellaneous Other ", clubEventBudget.getMiscOther()},
			{"Miscellaneous Subtotal ", clubEventBudget.getMiscSubtotal()},
			{"Total: ", " "},
			{"Event Budget Subtotal ", clubEventBudget.getEventBudgetSubtotal()},
			{"Event Budget Taxes ", clubEventBudget.getEventBudgetTaxes()},
			{"Event Budget Total ", clubEventBudget.getEventBudgetTotal()}

		};

		return reportArray;
	}

	public static Object[][] formatClubBudgetReport(ClubBudget clubBudget){
		return null;
	}

	public static Object[][] formatClubExpendituresReport(List<Expenditure> expenditures) {
		return null;
	}

	public static Object[][] formatClubEventExpendituresReport(List<Expenditure> expenditures) {
		return null;
	}

	public static Object[][] formatClubFSReport(List<Expenditure> expenditures) {
		return null;
	}

	public static Object[][] formatMembershipSummaryReport(Club club) {
		return null;
	}

	public static Object[][] formatMembershipDetailReport(Club club) {
		return null;
	}
	public static Object[][] formatClubEventAttendanceReport(ClubEvent clubevent) {
		return null;
	}
	public static Object[][] formatClubEventsSummaryReport(Club club) {//need club, need ALL that club's events
		return null;
	}

}
