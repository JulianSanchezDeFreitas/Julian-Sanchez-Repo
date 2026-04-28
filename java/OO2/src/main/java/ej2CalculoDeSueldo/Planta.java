package ej2CalculoDeSueldo;

import java.time.LocalDate;
import java.time.Period;

public class Planta extends EmpleadoConFamilia {

	private static final int VALOR_ANTIGUEDAD = 2000;
	private static final int SUELDO_BASE = 50000;
	private LocalDate dia_alta;	

	public Planta(boolean casado, int hijos, LocalDate dia_alta) {
		super(casado, hijos);
		this.dia_alta = dia_alta;
	}

	public LocalDate getDiaAlta() {
		return dia_alta;
	}

	public void setDiaAlta(LocalDate dia_alta) {
		this.dia_alta = dia_alta;
	}

	public int antiguedad() {
		return Period.between(this.getDiaAlta(), LocalDate.now()).getYears();
	}
	@Override
	protected double sueldoBasico() {
		return SUELDO_BASE;
	}

	@Override
	public double adicional() {
		return super.adicional() + (antiguedad() * VALOR_ANTIGUEDAD);
	}

}
