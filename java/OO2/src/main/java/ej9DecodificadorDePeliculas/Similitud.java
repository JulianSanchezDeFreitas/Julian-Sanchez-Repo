package ej9DecodificadorDePeliculas;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;

public class Similitud implements Sugerente {

	public Similitud() {}

	@Override
	public List<Pelicula> sugerirPeliculas(List<Pelicula> peliculasReproducidas, List<Pelicula> grilla) {
		Set<Pelicula> similares = new HashSet<Pelicula>();
		for (Pelicula pelicula : peliculasReproducidas) {
			for (Pelicula peliculaSimilar : pelicula.getSimilares()) {
				similares.add(peliculaSimilar);
			}
	}
		
	return similares.stream()
			.filter(Pelicula -> !peliculasReproducidas.contains(Pelicula))
			.sorted(Comparator.comparingInt(Pelicula::getAño).reversed())
			.limit(3)
			.collect(Collectors.toList());
  }
}
