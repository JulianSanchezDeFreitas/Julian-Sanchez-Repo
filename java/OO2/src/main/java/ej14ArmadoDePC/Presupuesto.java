package ej14ArmadoDePC;

import java.time.LocalDate;

public class Presupuesto {
	
	private static final double IVA = 1.21;
	private String nombre;
	private LocalDate fecha;
	private Equipo equipo;
	
	public Presupuesto(String nombre, LocalDate fecha, Equipo equipo) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.equipo = equipo;
	}
	
	public double calcularPrecio() {
		return equipo.calcularPrecio() * IVA;
	}
	
	
}
