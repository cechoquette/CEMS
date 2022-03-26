package CEMS.src.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Timeframe {

	private LocalDate startDate;
	private LocalDate endDate;
	private Period periodBetween;
	private LocalDate today = LocalDateTime.now().toLocalDate();
	
	public LocalDate getToday() {
		return today;
	}
	public void setToday(LocalDate today) {
		this.today = today;
	}
	public Timeframe(){//use if no end date or start date is given. assume end date is current date.
		endDate = today;
	}
	public Timeframe(LocalDate startDate, LocalDate endDate){// use in regular cases, start and end date given
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	Timeframe(LocalDate startDate, Period period){// use if start date and period are given. ex. one week starting april 1st.
		this.startDate = startDate;
		this.periodBetween = period;
	}
	
	Timeframe(LocalDate startDate){//use if no end date is given. assume end date is current date.
		this.startDate = startDate;
		endDate = today;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public Period getPeriodBetween() {
		return periodBetween;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setPeriodBetween(Period periodBetween) {
		this.periodBetween = periodBetween;
	}
	
}
