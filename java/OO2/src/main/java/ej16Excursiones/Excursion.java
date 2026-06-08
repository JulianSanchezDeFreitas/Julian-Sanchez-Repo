package ej16Excursiones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {

	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private EstadoDeExcursion miEstado;
	private List<Usuario> inscriptos;
	private List<Usuario> listaDeEspera;
	
	public void cambioDeEstado(EstadoDeExcursion estado) {
		this.miEstado = estado;
	}
	public void agregarInscripto(Usuario unUsuario) {
		inscriptos.add(unUsuario);
	}
	
	public void agregarAEspera(Usuario unUsuario) {
		listaDeEspera.add(unUsuario);
	}
	
	public void inscribir(Usuario unUsuario) {
		miEstado.inscribir(this, unUsuario);
	}
	
	public String obtenerInformacion() {
		return miEstado.informacion(this);
	}
	
	public List<Usuario> getInscriptos(){
		List<Usuario> inscriptosDupe = new ArrayList<Usuario>();
		inscriptosDupe.addAll(this.inscriptos);
		return inscriptosDupe;
	}
	public boolean tengoCupoMinimo() {
		return this.cupoMinimo == inscriptos.size();
	}
	
	public boolean tengoCupoMaximo() {
		return this.cupoMaximo == inscriptos.size();
	}
}
