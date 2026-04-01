package ej29;


import java.time.LocalDate;

public abstract class Actividad {
	protected LocalDate fechaInicio;
	protected String direccionIp;
	protected Integer duarcion;
	
	
	public abstract double Costo();
	
	public String getDireccionIp() {
		return direccionIp;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
}
