package CEMS.src.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Timeframe {

	private LocalDate startDate;
	private LocalDate endDate;
	private Period periodBetween;
	private LocalDate today;

	public Timeframe(){//use if no end date or start date is given. assume end date is current date.
		setToday();
		setStartDate(today);
		setEndDate(today);
	}
	public Timeframe(LocalDate startDate, LocalDate endDate){// use in regular cases, start and end date given
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Timeframe(LocalDate startDate, Period period){// use if start date and period are given. ex. one week starting april 1st.
		super();
		this.startDate = startDate;
		this.periodBetween = period;
	}
	
	public Timeframe(LocalDate startDate){//use if no end date is given. assume end date is current date.
		super();
		this.startDate = startDate;
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday() {
		this.today = LocalDateTime.now().toLocalDate();
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
