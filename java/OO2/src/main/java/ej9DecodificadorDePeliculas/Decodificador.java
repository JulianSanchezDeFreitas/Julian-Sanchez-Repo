package ej9DecodificadorDePeliculas;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {

	private List<Pelicula> grilla;
	private List<Pelicula> peliculasReproducidas;
	private Sugerente sugerente;
	
	public Decodificador(List<Pelicula> grilla, List<Pelicula> peliculasReproducidas) {
		this.grilla = grilla;
		this.peliculasReproducidas = peliculasReproducidas;
	}
	
	
	public void setSugerente(Sugerente sugerente) {
		this.sugerente = sugerente;
	}
	
	
	public List<Pelicula> sugerirPeliculas(){
		List<Pelicula> pr = new ArrayList<Pelicula>();
		pr.addAll(peliculasReproducidas);
		List<Pelicula> g = new ArrayList<Pelicula>();
		g.addAll(grilla);
		List<Pelicula> sugerencias = sugerente.sugerirPeliculas(pr, g);
		return sugerencias;
	}
}
