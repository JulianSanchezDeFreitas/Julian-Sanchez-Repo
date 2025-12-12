package ej17;

import java.time.LocalDate;

public class DateLapse2 implements DateLapseI {
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse2(LocalDate fromDate, int size){
		from = fromDate;
		sizeInDays = size;
	}
	
	public LocalDate getFrom() {
		return from;
	}
	
	public LocalDate getTo() {
		return from.plusDays(sizeInDays);
	}
	
	public int sizeInDays() {
		return sizeInDays;
	}
	
	public boolean includesDate(LocalDate other) {
		return other.isBefore(this.getTo()) && other.isAfter(from);
	}
}
