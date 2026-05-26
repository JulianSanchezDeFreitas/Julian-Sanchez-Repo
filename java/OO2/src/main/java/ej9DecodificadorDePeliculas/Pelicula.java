package ej9DecodificadorDePeliculas;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int año;
	private double puntaje;
	private List<Pelicula> similares;
	
	public Pelicula(String titulo, int año, double puntaje, List<Pelicula> similares) {
		this.titulo = titulo;
		this.año = año;
		this.puntaje = puntaje;
		this.similares = similares;
	}
	
	public List<Pelicula> getSimilares() {
		List<Pelicula> s  = new ArrayList<Pelicula>();
		s.addAll(similares);
		return s;
	}
	public int getAño() {
		return this.año;
	}
	
	public double getPuntaje() {
		return puntaje;
	}
	
}
