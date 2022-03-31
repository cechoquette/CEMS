package CEMS.src.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReportHandler {


	public static Report generateReport(HashMap<Object, Object> hmData) throws Exception {

		ReportType reportType = (ReportType)hmData.get("ReportType");
		ReportFormat reportFormat = (ReportFormat)hmData.get("ReportFormat");
		Timeframe timeframe = (Timeframe)hmData.get("ReportTimeframe");
		Club reportClub = (Club)hmData.get("ReportClub");

		ClubEvent noneEvent = new ClubEvent("NoneEvent", "Use this Event to avoid Null pointers", Main.ALLCLUBS, LocalDateTime.now(), "Here", "None");

		ClubEvent reportEvent = noneEvent;
		if (hmData.get("ReportEvent") != null) {
			reportEvent = (ClubEvent) hmData.get("ReportEvent");
		}

		//code NEEDS to be modified when Database up and running. Do not initialize.
		Object dataReturnedSingle = new Object();
		List<Object> dataReturnedList;
//		dataReturnedList.add(dataReturnedSingle);

		Object[][] reportFormatted = new Object[0][];
		String reportFileName = "Report";

//		formatClubEventBudgetReport((ClubEventBudget) object);

		switch(reportType){

			case CLUB_BUDGET:

				DAO dao1 = new DAO();
//				dataReturnedSingle = dao1.getClubBudget();//need a ClubBudgetID
				ClubBudgetReport cbReport = new ClubBudgetReport(reportFormat, (ClubBudget)dataReturnedSingle);
				reportFormatted = cbReport.formatReport();
				reportFileName = cbReport.getFilename();

				break;

			case CLUBEVENT_BUDGET:
				DAO dao2 = new DAO();
//				dataReturnedSingle = DAO.getClubEventBudget((ClubEvent)reportClubEvent))

				ClubEventBudgetReport cebReport = new ClubEventBudgetReport(reportFormat, (ClubEventBudget)hmData.get("Budget"));
				reportFormatted = cebReport.formatReport();
				reportFileName = cebReport.getFilename();
				break;

			case CLUB_EXPENDITURES:
//				DAO dao = new DAO();
//				List<Expenditure> dataExpList = dao.getExpenditures();
				ClubExpendituresReport clubExpReport = new ClubExpendituresReport(timeframe, reportFormat, reportClub, (ArrayList<Expenditure>)hmData.get("Expenditures"));
				reportFormatted = clubExpReport.formatReport();
				reportFileName = clubExpReport.getFilename();
				break;

			case CLUBEVENT_EXPENDITURES:
//				DAO dao5 = new DAO();
//				List<Expenditure> dataExpList5 = dao5.getExpenditures();
//				ClubEventExpendituresReport clubEvtExpReport = new ClubEventExpendituresReport(reportFormat, reportEvent, (ArrayList<Expenditure>)dataExpList5);
//				reportFormatted = clubEvtExpReport.formatReport();
//				reportFileName = clubEvtExpReport.getFilename();
				break;


			case CLUB_FINANCIAL_SITUATION:
//				DAO dao2 = new DAO();
//				List<Expenditure> dataExpList2 = dao2.getExpenditures();
//				dataReturnedSingle = dao2.getClubBudget();
//				ClubFinancialReport clubFinReport = new ClubFinancialReport(timeframe, reportFormat, (ClubBudget)dataReturnedSingle, (ArrayList<Expenditure>)dataExpList2);
//				reportFormatted = clubFinReport.formatReport();
//				reportFileName = clubFinReport.getFilename();
				break;

			case CLUBEVENT_FINANCIAL_SITUATION:
//				DAO dao3 = new DAO();
//				List<Expenditure> dataExpList3 = dao3.getExpenditures();
//				dataReturnedSingle = dao3.getClubEventBudget();
//				ClubEventFinancialReport clubEvtFinReport = new ClubEventFinancialReport(reportFormat, (ClubEventBudget)dataReturnedSingle, (ArrayList<Expenditure>)dataExpList3);
//				reportFormatted = clubEvtFinReport.formatReport();
//				reportFileName = clubEvtFinReport.getFilename();
				break;

			case CLUB_MEMBERSHIP_SUMMARY:
//				DAO dao4 = new DAO();
//				dataReturnedSingle = dao4.getClub();//actually, if you have the club already, you don't need to get it again
				ClubMembershipSummaryReport clubMembershipSummaryReport = new ClubMembershipSummaryReport(reportFormat, reportClub);
				reportFormatted = clubMembershipSummaryReport.formatReport();
				reportFileName = clubMembershipSummaryReport.getFilename();
				break;

			case CLUB_MEMBERSHIP_DETAIL:
//				ClubMembershipDetailReport clubMembershipDetailReport = new ClubMembershipDetailReport(reportFormat, reportClub);
//				reportFormatted = clubMembershipSummaryReport.formatReport();
//				reportFileName = clubMembershipSummaryReport.getFilename();
				break;

			case CLUBEVENT_ATTENDANCE: break;

			case CLUBEVENTS_SUMMARY: break;

			default: return null;
		}

		if(reportFormatted != null) {
			if (reportFormat == ReportFormat.EXCEL) {
				exportToExcel(reportFileName, reportFormatted);
			}
			else if (reportFormat == ReportFormat.PDF){
				exportToPDF(reportFileName, reportFormatted);
			}
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

	public static void exportToPDF(String fileName, Object[][] strings) throws Exception{
//		 try (PDDocument doc = new PDDocument()) {
//
////			 = new ArrayList<>();
////			valuesToExport.add(new String[]{"Title1", "Title2", "Title3"});
////			valuesToExport.add(new String[]{"123", "456", "789"});
////			valuesToExport.add(new String[]{"abc", "def", "ghi"});
//			String home = System.getProperty("user.home");
//
//			FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + fileName + ".pdf");
//
//
//			PDFont font = PDType1Font.HELVETICA;
//			PDPage page = new PDPage();
//			doc.addPage(page);
//
//			PDPageContentStream content = new PDPageContentStream(doc, page);
//			content.setFont(font, 12);
//
//			int lines = 1;
//			float pageHeight = page.getMediaBox().getHeight();
//			for (String[] row : valuesToExport) {
//
//				int startX = 100;
//				for (String column : row) {
//					content.beginText();
////					content.moveTo(100, 100);
//					content.newLineAtOffset(startX, pageHeight - 300 * lines);
//					startX += startX + 350;
//					content.showText(column);
//					content.endText();
//				}
//				++lines;
//				if (lines > 10) {
//					lines = 1;
//					page = new PDPage();
//					doc.addPage(page);
//					content.close();
//					content = new PDPageContentStream(doc, page);
//					content.setFont(font, 12);
//				}
//			}
//			content.close();
//			doc.save(outputStream);
//		} catch (IOException ex) {
//			//either log exception or rethrow it
//		}
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

//	public static Object[][] formatClubBudgetReport(ClubBudget clubBudget){
//		return null;
//	}
//
//	public static Object[][] formatClubExpendituresReport(List<Expenditure> expenditures) {
//		return null;
//	}
//
//	public static Object[][] formatClubEventExpendituresReport(List<Expenditure> expenditures) {
//		return null;
//	}
//
//	public static Object[][] formatClubFSReport(List<Expenditure> expenditures) {
//		return null;
//	}
//
//	public static Object[][] formatMembershipSummaryReport(Club club) {
//		return null;
//	}
//
//	public static Object[][] formatMembershipDetailReport(Club club) {
//		return null;
//	}
//	public static Object[][] formatClubEventAttendanceReport(ClubEvent clubevent) {
//		return null;
//	}
//	public static Object[][] formatClubEventsSummaryReport(Club club) {//need club, need ALL that club's events
//		return null;
//	}

}
