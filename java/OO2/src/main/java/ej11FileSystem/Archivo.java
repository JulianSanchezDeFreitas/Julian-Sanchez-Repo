package ej11FileSystem;

import java.time.LocalDate;

public class Archivo extends Elemento {
	private int tamaño;
	
	
	
	public Archivo(String nombre, LocalDate fechaCreacion, int tamaño) {
		super(nombre, fechaCreacion);
		this.tamaño = tamaño;
	}

	@Override
	public int getTamaño() {	
		return this.tamaño ;
	}
	public LocalDate getFecha() {
		return this.fechaCreacion;
	}
	
	public Archivo archivoMasGrande() {
		return this;
	}
	
	public Archivo archivoMasNuevo() {
		return this;
	}
}
