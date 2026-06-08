package ej11FileSystem;

import java.time.LocalDate;

public abstract class Elemento {
	protected String nombre;
	protected LocalDate fechaCreacion;
	
	public abstract int getTamaño();
	public abstract Archivo archivoMasGrande();
	public abstract	Archivo archivoMasNuevo();
	
	public Elemento(String nombre, LocalDate fechaCreacion) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
}
