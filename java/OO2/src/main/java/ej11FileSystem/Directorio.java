package ej11FileSystem;

import java.time.LocalDate;
import java.util.List;

public class Directorio extends Elemento {

	private static final int TAMAÑO = 32;

	public Directorio(String nombre, LocalDate fechaCreacion) {
		super(nombre, fechaCreacion);
	}

	private List<Elemento> elementos;
	
	public int getTamaño() {
		return elementos.stream()
		.mapToInt(e -> e.getTamaño())
		.sum()
		+ TAMAÑO;
		
	}
	
	public Archivo archivoMasGrande() {
		Archivo archiMaximo = new Archivo("-", null, -1);
		Archivo archiAux = new Archivo("-", null, -1);
		for (Elemento elemento : elementos) {
			archiAux = elemento.archivoMasGrande();
			
			if (archiAux.getTamaño() > archiMaximo.getTamaño()) {
				archiMaximo = archiAux;
			}
		}
		return archiMaximo;
	}
	
	public Archivo archivoMasNuevo() {
		Archivo archiMasNuevo = new Archivo("-", null, -1);
		Archivo archiAux = new Archivo("-", null, -1);
		for (Elemento elemento : elementos) {
			archiAux = elemento.archivoMasNuevo();
			
			if (archiAux.getFecha().isAfter(archiMasNuevo.getFecha())) {
				archiMasNuevo = archiAux;
			}
		}
		return archiMasNuevo;
	}
}
