package ej9Pedidos;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
	  private LocalDate fechaAlta;

	  public LocalDate getFechaAlta() {
	    return this.fechaAlta;
	  }

	public int antiguedad() {
		int añosDesdeFechaAlta = Period
	      .between(getFechaAlta(), LocalDate.now())
	      .getYears();
		return añosDesdeFechaAlta;
	}	
}
