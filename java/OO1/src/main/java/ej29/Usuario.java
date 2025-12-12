package ej29;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ej16.DateLapse;

public class Usuario {

	private String nombre;
	private LocalDate fechaAlta;
	private List<Actividad> actividades;
	private Plan planActual;
	
	
	public double montoACobrar(DateLapse periodo) {
		int anios = Period.between(fechaAlta, LocalDate.now()).getYears();

		Set<String> ipsRegistradas = new HashSet<>();
		for(Actividad a: actividades ) {
			ipsRegistradas.add(a.getDireccionIp());
		}
		Integer cantidadIps = ipsRegistradas.size();
		
		double totalMontoActividades = 0;
		totalMontoActividades = actividades.stream()
		.filter(a -> periodo.includesDate(a.getFechaInicio()))
		.mapToDouble(a -> a.Costo())
		.sum();
		
		Plan planG = new Grupal(5);
		Plan planI = new Individual(1, 645);
		
		
		return totalMontoActividades + planActual.costoTotal(cantidadIps);
	}
	
	
}
