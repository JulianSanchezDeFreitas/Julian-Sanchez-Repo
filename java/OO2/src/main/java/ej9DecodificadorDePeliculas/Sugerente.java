package ej9DecodificadorDePeliculas;

import java.util.List;

public interface Sugerente {

	public List<Pelicula> sugerirPeliculas(List<Pelicula> peliculasReproducidas, List<Pelicula> grilla);
}
