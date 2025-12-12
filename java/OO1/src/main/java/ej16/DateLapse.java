package ej16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ej17.DateLapseI;



public class DateLapse implements DateLapseI {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate fromDate , LocalDate toDate ) {
		// TODO Auto-generated constructor stub
		from = fromDate;
		to = toDate;
	}
	
	public LocalDate getFrom() {
		//“Retorna la fecha de inicio del rango”
		return from;
	}

	public LocalDate getTo() {
		//“Retorna la fecha de fin del rango”
		return to;
	}

	public int sizeInDays() {
		//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		Long dias = from.until(to, ChronoUnit.DAYS);
		return dias.intValue() ;
	}

	public boolean includesDate(LocalDate other) {
		//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
		return other.isBefore(to) && other.isAfter(from);
	}


}
