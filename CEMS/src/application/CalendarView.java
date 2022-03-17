package application;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CalendarView {//extends Application{
	
	private LocalDateTime today = LocalDateTime.now();
	private int currentDisplayMonth = today.getMonthValue();
	private int currentDisplayYear = today.getYear();

	
	//main, start, menubar to test the widget only*******************
	//****************************************************************************
	//****************************************************************************
	
//		public static void main(String[] args) {
//			launch(args);
//		}
//	@Override
//	    public void start(Stage primaryStage) {
//		
//			BorderPane root = new BorderPane();
//			root.setCenter(makeCalendar());
//			
//			root.setTop(getMenuBar());
//			
//		
//			Scene scene = new Scene(root, 1200, 600);
//			primaryStage.setScene(scene);
//	        primaryStage.setTitle("Calendar");
//	        
//	        primaryStage.show();
//	    }
//	
//		public MenuBar getMenuBar() {
//			MainMenu mainMenu = new MainMenu();
//			MenuBar mainMenuBar = mainMenu.createMenu();
//			return mainMenuBar;
//		}
		
	//****************************************************************************
	//****************************************************************************
		
		//TODO change method to count Events from getDailyEvents() method
		//method call should retrieve the number of daily events from database
		public int getNumberOfDailyEvents(int day) {
			int[] days = {
					1,2,4,0,1,3,2,0,1,3,0,1,2,0,1,0,4,0,1,0,1,0,1,0,1,2,0,2,0,4,0,2,0,1,
					1,2,0,0,1,3,2,5,1,0,3,4,1,2,4,1,3,1,2,4,5,1,3,2,5,1,3,4,1,2,4,1,3
					
			};
			
			return days[day];
		}
		
		//TODO method call should retrieve the daily Events from database
//		public Event[] getDailyEvents(Date) {
//			
//			
//			return dailyEvents;
//		}
		
		
		//TODO event Handlers below
		
		
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
			
			
			int calDayHeight = 50;
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
			
			title.setPadding(new Insets(20, 50, 20, 50));
			title.setMaxWidth(425);
			
			
			title.setLeft(leftArrow);
			title.setRight(rightArrow);
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
			rightArrow.setOnMouseClicked(e ->{
				
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
			
			leftArrow.setOnMouseClicked(e ->{
				
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
			int calDayHeight = 50;
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
				
				int numberOfEvents = getNumberOfDailyEvents(calendarDay);
				Label lbDay = new Label();
				FlowPane flEventDots = new FlowPane();
				
				if(i % 7 == 0) {
					xcount = 0;
					ycount++;
				}

				if((i-firstDay+1) <= daysInMonth && i >= firstDay) {
					calendarDay++;
					lbDay.setText(""+calendarDay);
				}
				else {
					numberOfEvents = 0;
					calendarDay = 0;
					lbDay.setText("   ");
				}

			//Styles
				lbDay.setPrefSize(calDayWidth, calDayHeight/2);
				lbDay.setTextAlignment(TextAlignment.CENTER);
				lbDay.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18));
				
				flEventDots.setPrefSize(calDayWidth, calDayHeight/2);
				
				//TODO
				//make a method for this
				for(int j = 0; j<numberOfEvents; j++) {
					flEventDots.getChildren().add(new Circle(2));
				}
				
				calendarBoxes[i].getChildren().addAll(lbDay, flEventDots);
				gpCalendar.add(calendarBoxes[i], xcount, ycount);
				xcount++;
			}
			
			//TODO make handlers for the days
			//involves making method calls to get Events, then call separate method which posts them
			
			
//			day9.setOnMouseClicked(e ->{
//				day9.getChildren().clear();
//				day8.getChildren().get(0);
//			});
			
			return gpCalendar;
		}
		

	

}