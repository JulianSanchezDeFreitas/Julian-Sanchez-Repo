package ej9DecodificadorDePeliculas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Puntaje implements Sugerente {

	public Puntaje() {}

	@Override
	public List<Pelicula> sugerirPeliculas(List<Pelicula> peliculasReproducidas, List<Pelicula> grilla) {
		return grilla.stream()
				.filter(Pelicula -> !peliculasReproducidas.contains(Pelicula))
				.sorted(Comparator.comparingDouble(Pelicula::getPuntaje).reversed())
				.limit(3)
				.collect(Collectors.toList());
	}
}
