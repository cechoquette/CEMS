package CEMS.src.application;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CalendarView {

	private LocalDateTime today = LocalDateTime.now();
	private int currentDisplayMonth = today.getMonthValue();
	private int currentDisplayYear = today.getYear();
	public CalendarView() {}

	//****************************************************************************
	//****************************************************************************

	//TODO change method to count Events from getDailyEvents() method
	//method call should retrieve the number of daily events from database
	public int getNumberOfDailyEvents(int day) {
		int[] days = {
				1,2,4,0,1,3,2,0,1,3,0,1,12,0,1,0,4,0,1,0,1,0,1,0,1,2,0,2,0,45,0,2,0,1,
				1,2,0,0,1,3,2,5,1,0,3,4,1,2,4,1,3,1,2,4,1,1,3,2,5,1,3,4,1,2,4,1,3

		};

		return days[day];
	}

	//TODO method call should retrieve the daily Events from database
//		public Event[] getDailyEvents(Date) {
//
//
//			return dailyEvents;
//		}

	//method returns an int value for the number of days in any given month
	public int getCurrentMonthLength(int month) {
		//1 is Jan, 12 is Dec
		switch (month) {
			case 1: case 3: case 5: case 7: case 8:	case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				if(isLeapYear(currentDisplayYear))
					return 29;
				else
					return 28;
			default: return 0;
		}
	}
	//method for whether given year is a leap year
	public boolean isLeapYear(int year) {
		boolean leap = false;
		// if the year is divisible by 4
		if (year % 4 == 0)
		{
			// if the year is a century
			if (year % 100 == 0)
			{
				// if year is divided by 400
				// then it is a leap year
				if (year % 400 == 0)
				{
					leap = true;
				}
				else
				{
					leap = false;
				}
			}
			// if the year is not a century
			else
			{
				leap = true;
			}
		}
		else
		{
			leap = false;
		}
		return leap;
	}
	//method returns String value of given month
	public String getCurrentMonth(int month) {
		//assume you're given 1-12 for months
		String[] months = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
		return months[month];
	}
	//method returns an int value of the first weekday of any given month
	public int getFirstWeekday(int month, int year) {
		//assume you're given 1-12 for months
		//return 0 for Monday, 6 for Sunday
		String date;
		int realMonth = month;
		if (realMonth < 10) {
			date = "" + year + "-0" + realMonth + "-" + "01";
		}
		else {
			date = "" + year + "-" + realMonth + "-" + "01";
		}

		DayOfWeek day = LocalDate.parse(date).getDayOfWeek();
		return day.getValue()-1;//returns 0-6, regular values 1(Monday) to 7(Sunday)
	}

	public String getCalendarTitle(int month, int year) {
		String calendarTitle = getCurrentMonth(month) + ", " + year;

		return calendarTitle;
	}


	//Method return a VBox which contains a full calendar widget: Title, Weekdays, Calendar Days
	//With Event Handlers for the Right/Left Arrows and each calendar day
	public VBox makeCalendar() {

		int calDayWidth = 50;

		VBox vbMainCalendar = new VBox();

		//Create the top part: arrow, "Month, Year", arrow
		Label calendarTitle = new Label();
		calendarTitle.setText(getCurrentMonth(currentDisplayMonth) + ", " + currentDisplayYear);
		BorderPane title = new BorderPane();

		Polygon rightArrow = new Polygon();
		rightArrow.getPoints().addAll( new Double[] {
				0.0, 0.0,
				0.0, 10.0,
				8.0, 5.0
		});
		Polygon leftArrow = new Polygon();
		leftArrow.getPoints().addAll( new Double[] {
				0.0, 0.0,
				0.0, 10.0,
				-8.0, 5.0
		});

		Button rightButton = new Button();
		rightButton.setGraphic(rightArrow);
		Button leftButton = new Button();
		leftButton.setGraphic(leftArrow);

		title.setPadding(new Insets(20, 50, 20, 50));
		title.setMaxWidth(425);


		title.setLeft(leftButton);
		title.setRight(rightButton);
		title.setCenter(calendarTitle);


		//Create the weekdays part
		Label monday = new Label("Mon");
		Label tuesday = new Label("Tues");
		Label wednesday = new Label("Wed");
		Label thursday = new Label("Thurs");
		Label friday = new Label("Fri");
		Label saturday = new Label("Sat");
		Label sunday = new Label("Sun");

		Label[] weekdays = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};


		for(Label weekday: weekdays) {
			weekday.setPrefWidth(calDayWidth);
			weekday.setTextAlignment(TextAlignment.CENTER);
		}
		HBox hbWeekdays = new HBox(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
		hbWeekdays.setPadding(new Insets(0, 50, 0, 50));


		//Call method makeDAtes to get the days portion
		GridPane calendarDays = makeDates(currentDisplayMonth, currentDisplayYear);
		//Add all 3 parts to the calendar
		vbMainCalendar.getChildren().addAll(title, hbWeekdays, calendarDays);


		//Left and Right Arrow Event Handlers
		rightButton.setOnMouseClicked(e ->{

			if ((this.currentDisplayMonth + 1) < 12) {

				currentDisplayMonth++;
			}
			else {
				this.currentDisplayMonth = 0;
				currentDisplayYear++;
			}
			title.setCenter(new Label(getCalendarTitle(currentDisplayMonth, currentDisplayYear)));

			vbMainCalendar.getChildren().clear();
			vbMainCalendar.getChildren().addAll(title, hbWeekdays, makeDates(currentDisplayMonth, currentDisplayYear));
		});

		leftButton.setOnMouseClicked(e ->{

			if ((this.currentDisplayMonth - 1) >= 0) {

				currentDisplayMonth--;
			}
			else {
				this.currentDisplayMonth = 11;
				currentDisplayYear--;
			}
			title.setCenter(new Label(getCalendarTitle(currentDisplayMonth, currentDisplayYear)));

			vbMainCalendar.getChildren().clear();
			vbMainCalendar.getChildren().addAll(title, hbWeekdays, makeDates(currentDisplayMonth, currentDisplayYear));
		});

		return vbMainCalendar;
	}

	public GridPane makeDates(int currentDisplayMonth, int currentDisplayYear) {
		int calDayHeight = 75;
		int calDayWidth = 50;

		GridPane gpCalendar = new GridPane();

		gpCalendar.setPadding(new Insets(20, 50, 20, 50));

		VBox day1 = new VBox();
		VBox day2 = new VBox();
		VBox day3 = new VBox();
		VBox day4 = new VBox();
		VBox day5 = new VBox();
		VBox day6 = new VBox();
		VBox day7 = new VBox();
		VBox day8 = new VBox();
		VBox day9 = new VBox();
		VBox day10 = new VBox();
		VBox day11 = new VBox();
		VBox day12 = new VBox();
		VBox day13 = new VBox();
		VBox day14 = new VBox();
		VBox day15 = new VBox();
		VBox day16 = new VBox();
		VBox day17 = new VBox();
		VBox day18 = new VBox();
		VBox day19 = new VBox();
		VBox day20 = new VBox();
		VBox day21 = new VBox();
		VBox day22 = new VBox();
		VBox day23 = new VBox();
		VBox day24 = new VBox();
		VBox day25 = new VBox();
		VBox day26 = new VBox();
		VBox day27 = new VBox();
		VBox day28 = new VBox();
		VBox day29 = new VBox();
		VBox day30 = new VBox();
		VBox day31 = new VBox();
		VBox day32 = new VBox();
		VBox day33 = new VBox();
		VBox day34 = new VBox();
		VBox day35 = new VBox();
		VBox day36 = new VBox();
		VBox day37 = new VBox();
		VBox day38 = new VBox();
		VBox day39 = new VBox();
		VBox day40 = new VBox();
		VBox day41 = new VBox();
		VBox day42 = new VBox();

		VBox[] calendarBoxes =
				{day1, day2, day3, day4, day5, day6, day7,
						day8, day9, day10, day11, day12, day13, day14,
						day15, day16, day17, day18, day19, day20, day21,
						day22, day23, day24, day25, day26, day27, day28,
						day29, day30, day31, day32, day33, day34, day35,
						day36, day37, day38, day39, day40, day41, day42};

		int xcount = -1;
		int ycount = 0;
		int firstDay = getFirstWeekday(currentDisplayMonth, currentDisplayYear);
		int calendarDay = 0;
		int daysInMonth = getCurrentMonthLength(currentDisplayMonth);

		for (int i = 0; i<calendarBoxes.length; i++) {
			calendarBoxes[i].setPrefSize(calDayWidth, calDayHeight);
			Label lbDay = new Label();
			LocalDate selectedDate = LocalDate.of(currentDisplayYear, currentDisplayMonth, 2);

			/* ****TODO: Test Code Segment to be replaced on putting it into the application**** */
//            EventsBoolean eventsBoolean = new EventsBoolean(selectedDate);
//            boolean[] trueFalseList = eventsBoolean.getEventsArray();
			/* ****TODO: Replace the above with this for the controller call**** *
			 * Boolean checkForEvent = (Boolean)Controller.processRequest(RequestType.CHECK_FOR_EVENTS, dataToSend).get("CheckForEvent");
			 * ***************************************************************** */

			if((i-firstDay+1) <= daysInMonth && i >= firstDay) {
				calendarDay++;
				lbDay.setText(""+calendarDay);
				calendarBoxes[i].setUserData(calendarDay);
			}
			else {
				calendarBoxes[i].setUserData(null);
				calendarDay = 0;
				lbDay.setText("   ");
			}

			boolean eventsExist = false;
//            if (calendarBoxes[i].getUserData() != null) {
//                eventsExist = trueFalseList[calendarDay - 1];
//            }

			FlowPane flEventDots = new FlowPane();

			if(i % 7 == 0) {
				xcount = 0;
				ycount++;
			}

			//Styles
			lbDay.setPrefSize(calDayWidth, calDayHeight/2);
			lbDay.setTextAlignment(TextAlignment.CENTER);
			lbDay.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18));

			flEventDots.setPrefSize(calDayWidth, calDayHeight/2);

			//TODO
			//make a method for this
//            if (eventsExist) {
//                flEventDots.getChildren().add(new Circle(2));
//            }

			calendarBoxes[i].getChildren().addAll(lbDay, flEventDots);
			gpCalendar.add(calendarBoxes[i], xcount, ycount);
			xcount++;
		}

		for (int i = 0; i < calendarBoxes.length; i++) {
			int dayOfMonth;
			if (calendarBoxes[i].getUserData() != null) {
				dayOfMonth = (int) calendarBoxes[i].getUserData();
			}
			else
				dayOfMonth = 1000;
			calendarBoxes[i].setOnMouseClicked(e -> {
				showEvents(dayOfMonth, currentDisplayMonth, currentDisplayYear);
			});
		}

		return gpCalendar;
	}

	private void showEvents (int day, int month, int year) {

		LocalDate selectedDate = LocalDate.of(year, month, day);
		Dialog<ScrollPane> eventsOfTheDay = new Dialog<>();
		eventsOfTheDay.setResizable(false);

		eventsOfTheDay.setTitle("Events for " + getCurrentMonth(month) + " " + day + ", " + year);
		//TODO
		/* *** Get the events, add in the below code to send request to the controller
		 *
		 * ArrayList<ClubEvent> dailyEvents = (ArrayList<ClubEvent>)Controller.processRequest(RequestType.GET_EVENTS, hashmap).get("DailyEvents");
		 *
		 *  *** */
		//Test Code Section - to be removed when porting over
		//ArrayList<ClubEvent> dailyEvents = CreateEvents.makeNewEvents(selectedDate);

		//End of test code section

		VBox eventHolder = new VBox();
//        for (int i = 0; i < dailyEvents.size(); i++) {
//            eventHolder.getChildren().add(createEventPane(dailyEvents.get(i).getEventName(), dailyEvents.get(i).getEventLocation(), dailyEvents.get(i).getEventDateTime(), dailyEvents.get(i).getEventID()));
//        }

		eventsOfTheDay.getDialogPane().setExpandableContent(eventHolder);
		//eventsOfTheDay.getDialogPane().getScene().getWindow().sizeToScene();
		Window window = eventsOfTheDay.getDialogPane().getScene().getWindow();
		window.setOnCloseRequest(event -> window.hide());
		eventsOfTheDay.showAndWait();
	}

	private GridPane createEventPane (String name, String location, LocalDateTime time, int eventIdNum) {
		//Initialize containers and set parameters
		GridPane event = new GridPane();
		event.setHgap(20);
		VBox eventDetails = new VBox();
		VBox editEvent = new VBox();
		editEvent.setPadding(new Insets(10));
		event.setPrefWidth(400);
		event.setMinWidth(400);
		event.setStyle("-fx-border-color: black; -fx-padding: 10");

		//Event Name
		HBox nameBox = new HBox();
		Label eventDeclaration = new Label("Event: ");
		eventDeclaration.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
		Label eventName = new Label(name);
		eventName.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
		nameBox.getChildren().addAll(eventDeclaration, eventName);

		//Event Location
		HBox locationBox = new HBox();
		Label locationDeclaration = new Label("Location: ");
		locationDeclaration.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
		Label eventLocation = new Label(location);
		eventLocation.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
		locationBox.getChildren().addAll(locationDeclaration, eventLocation);

		//Event Location
		HBox timeBox = new HBox();
		Label timeDeclaration = new Label("Time of Event: ");
		timeDeclaration.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
		Label eventTime = new Label(time.format(DateTimeFormatter.ofPattern("hh:mm")));
		eventTime.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
		timeBox.getChildren().addAll(timeDeclaration, eventTime);

		//Add Event details to VBox
		eventDetails.getChildren().addAll(nameBox, locationBox, timeBox);
		eventDetails.setStyle("-fx-padding: 10;");

		//Create Event Edit Button and Add it
		Button editButton = new Button("Edit Event");
		editButton.setOnMouseClicked(e -> {
			EventID.getInstance().setID((Integer)eventIdNum);
			Stage stage = (Stage) editButton.getScene().getWindow();
			stage.close();

			try {
				Parent  fxmlFile = FXMLLoader.load(CalendarView.class.getResource("hello-view.fxml"));
				Scene scene = new Scene(fxmlFile);
				stage.setScene(scene);
				stage.show();
			} catch (IOException ex) {
				System.out.println("Can't find it");
				//ex.printStackTrace();
			}

		});

		//TODO: Add event handler
		editEvent.getChildren().add(editButton);
		editButton.setLayoutX(editEvent.getWidth()-editButton.getWidth());
		editEvent.setAlignment(Pos.CENTER);

		//Add everything to the GridPane
		GridPane.setConstraints(eventDetails, 0, 0);
		GridPane.setConstraints(editEvent, 1, 0);
		event.getChildren().addAll(eventDetails, editEvent);

		return event;
	}
}
