package ej9DecodificadorDePeliculas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Novedad implements Sugerente {

	public Novedad() {}

	@Override
	public List<Pelicula> sugerirPeliculas(List<Pelicula> peliculasReproducidas, List<Pelicula> grilla) {
		return grilla.stream()
				.filter(Pelicula -> !peliculasReproducidas.contains(Pelicula))
				.sorted(Comparator.comparingInt(Pelicula::getAño).reversed())
				.limit(3)
				.collect(Collectors.toList());
	}
	
	
}
