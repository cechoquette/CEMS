package CEMS.src.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import static org.apache.pdfbox.pdmodel.common.PDRectangle.POINTS_PER_MM;


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
//		Object dataReturnedSingle = new Object();
//		List<Object> dataReturnedList;
//		dataReturnedList.add(dataReturnedSingle);

		Object[][] reportFormatted = new Object[0][];
		String reportFileName = "Report";
		int reportSize = 1;

//		formatClubEventBudgetReport((ClubEventBudget) object);

		switch(reportType){

			case CLUB_BUDGET:

				DAO dao1 = new DAO();
//				dataReturnedSingle = dao1.getClubBudget();//need a ClubBudgetID
				ClubBudget cBudget = dao1.getClubBudgetByClub(reportClub.toString());
//				ClubBudgetReport cbReport = new ClubBudgetReport(reportFormat, (ClubBudget)hmData.get("ClubBudget"));//test line
				ClubBudgetReport cbReport = new ClubBudgetReport(reportFormat, cBudget);//real line
				reportFormatted = cbReport.formatReport();
				reportFileName = cbReport.getFilename();
				reportSize = 3;
				break;

			case CLUBEVENT_BUDGET:
				DAO dao2 = new DAO();
//				dataReturnedSingle = DAO.getClubEventBudget((ClubEvent)reportClubEvent))
				ClubEventBudget ceBudget = dao2.getClubEventBudget(reportClub.getClubID());
//				ClubEventBudgetReport cebReport = new ClubEventBudgetReport(reportFormat, (ClubEventBudget)hmData.get("Budget"));//test line
				ClubEventBudgetReport cebReport = new ClubEventBudgetReport(reportFormat, ceBudget);//real Line
				reportFormatted = cebReport.formatReport();
				reportFileName = cebReport.getFilename();
				reportSize = 3;
				break;

			case CLUB_EXPENDITURES:
				DAO dao3 = new DAO();
				ArrayList<Expenditure> dataExpList = (ArrayList<Expenditure>)dao3.getAllExpenditureByClub(reportClub.getClubName());
//				ClubExpendituresReport clubExpReport = new ClubExpendituresReport(timeframe, reportFormat, reportClub, (ArrayList<Expenditure>)hmData.get("Expenditures"));//test line
				ClubExpendituresReport clubExpReport = new ClubExpendituresReport(timeframe, reportFormat, reportClub, dataExpList);//real line

				reportFormatted = clubExpReport.formatReport();
				reportFileName = clubExpReport.getFilename();
				reportSize = 1;
				break;

			case CLUBEVENT_EXPENDITURES:
				DAO dao5 = new DAO();
//				ArrayList<Expenditure> ceExpend = (ArrayList<Expenditure>)dao5.getAllExpenditures(reportEvent);
//				ClubEventExpendituresReport clubEvtExpReport = new ClubEventExpendituresReport(reportFormat, reportEvent, ceExpend);//real line
//				reportFormatted = clubEvtExpReport.formatReport();
//				reportFileName = clubEvtExpReport.getFilename();
				reportSize = 1;
				break;


			case CLUB_FINANCIAL_SITUATION://not done****
//				DAO dao2 = new DAO();
//				List<Expenditure> dataExpList2 = dao2.getExpenditures();
//				dataReturnedSingle = dao2.getClubBudget();
//				ClubFinancialReport clubFinReport = new ClubFinancialReport(timeframe, reportFormat, (ClubBudget)dataReturnedSingle, (ArrayList<Expenditure>)dataExpList2);
//				reportFormatted = clubFinReport.formatReport();
//				reportFileName = clubFinReport.getFilename();
				reportSize = 2;
				break;

			case CLUBEVENT_FINANCIAL_SITUATION://not done****
//				DAO dao3 = new DAO();
//				List<Expenditure> dataExpList3 = dao3.getExpenditures();
//				dataReturnedSingle = dao3.getClubEventBudget();
//				ClubEventFinancialReport clubEvtFinReport = new ClubEventFinancialReport(reportFormat, (ClubEventBudget)dataReturnedSingle, (ArrayList<Expenditure>)dataExpList3);
//				reportFormatted = clubEvtFinReport.formatReport();
//				reportFileName = clubEvtFinReport.getFilename();
				reportSize = 2;
				break;

			case CLUB_MEMBERSHIP_SUMMARY:
				ClubMembershipSummaryReport clubMembershipSummaryReport = new ClubMembershipSummaryReport(reportFormat, reportClub);
				System.out.println(reportClub);
				reportFormatted = clubMembershipSummaryReport.formatReport();
				reportFileName = clubMembershipSummaryReport.getFilename();
				reportSize = 3;
				break;

			case CLUB_MEMBERSHIP_DETAIL:
				ClubMembershipDetailReport clubMembershipDetailReport = new ClubMembershipDetailReport(reportFormat, reportClub);
				reportFormatted = clubMembershipDetailReport.formatReport();
				reportFileName = clubMembershipDetailReport.getFilename();
				reportSize = 2;
				break;

			case CLUBEVENT_ATTENDANCE:
				ClubEventAttendanceReport clubEventAttendanceReport = new ClubEventAttendanceReport(reportFormat, reportEvent);
				reportFormatted = clubEventAttendanceReport.formatReport();
				reportFileName = clubEventAttendanceReport.getFilename();
				reportSize = 3;
				break;

			case CLUBEVENTS_SUMMARY:
				DAO dao10 = new DAO();
//				ArrayList<ClubEvent> clubEvents = (ArrayList<ClubEvent>)dao10.getAllClubEvents(reportClub);
//				ClubEventsSummaryReport clubEventsSummaryReport = new ClubEventsSummaryReport(reportFormat, clubEvents);//real code
//				reportFormatted = clubEventsSummaryReport.formatReport();
//				reportFileName = clubEventsSummaryReport.getFilename();
				reportSize = 2;
				break;

			default: return null;
		}

		if(reportFormatted != null) {
			if (reportFormat == ReportFormat.EXCEL) {
				exportToExcel(reportFileName, reportFormatted);
			}
			else if (reportFormat == ReportFormat.PDF){
				exportToPDF(reportFileName, reportFormatted, reportSize);
			}
		}


		return null;
	}
	////PDF METHOD for exporting reports
	//Method exports an Excel document and saves it to User's Downloads folder
	public static void exportToExcel(String fileName, Object[][] strings) throws IOException{

		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

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
        	FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + fileName + ".xlsx");
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }

	}
////PDF METHOD for exporting reports
	public static void exportToPDF(String fileName, Object[][] strings, int size) throws Exception{
		try  {

			PDDocument doc = new PDDocument();
		//			 = new ArrayList<>();
		//			valuesToExport.add(new String[]{"Title1", "Title2", "Title3"});
		//			valuesToExport.add(new String[]{"123", "456", "789"});
		//			valuesToExport.add(new String[]{"abc", "def", "ghi"});
			String home = System.getProperty("user.home");

			FileOutputStream outputStream = new FileOutputStream(home+"/Downloads/" + fileName + ".pdf");

			float POINTS_PER_INCH = 72;
			float POINTS_PER_MM = 1 / (10 * 2.54f) * POINTS_PER_INCH;
			PDFont font = PDType1Font.HELVETICA;
			int newWidth;
			int newHeight;
			switch (size){
				case 2:
					newWidth = 841;
					newHeight = 594;
					break;
				case 3:
					newWidth = 400;
					newHeight = 210;
					break;
				case 1:
				default:
					newWidth = 1189;
					newHeight = 841;
					break;
			}

			PDPage page = new PDPage(new PDRectangle(newWidth * POINTS_PER_MM, newHeight * POINTS_PER_MM));
			doc.addPage(page);

			PDPageContentStream content = new PDPageContentStream(doc, page);
			content.setFont(font, 12);
			content.setLeading(14.5f);


			int lines = 1;
			float pageHeight = page.getMediaBox().getHeight();
			for (Object[] row : strings) {
				content.setFont(PDType1Font.HELVETICA, 12);
				int startX = 25;
				for (Object column : row) {
					content.beginText();
//					content.moveTo(100, 100);
					content.newLineAtOffset(startX, pageHeight - (20 * lines));
					startX += 250;
					if (column instanceof String) {
						if(((String) column).contains("total")
								||((String) column).contains("Total")
								||((String) column).contains(":")
								||((String) column).contains("axes")){
							content.setFont(PDType1Font.HELVETICA_BOLD, 12);
						}
						content.showText((String) column);


					} else if (column instanceof Double) {
						content.showText(String.valueOf(column));
					}
//					content.showText((String) column);
					content.endText();
				}
				++lines;
				if (lines > 50) {
					lines = 1;
					page = new PDPage(new PDRectangle(1189 * POINTS_PER_MM, 841 * POINTS_PER_MM));
					doc.addPage(page);
					content.close();
					content = new PDPageContentStream(doc, page);
					content.setFont(font, 12);
				}
			}
			content.close();
			doc.save(outputStream);
			doc.close();
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
