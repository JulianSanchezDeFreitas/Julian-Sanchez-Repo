package ej19FileManagment;

import java.time.LocalDate;

public class FileOO2 implements Archivo{

	private String nombre;
	private String extension;
	private int tamaño;
	private LocalDate fechaDeCreacion;
	private LocalDate fechaDeModificacion;
	private String permisos;
	
	
	public FileOO2(String nombre, String extension, int tamaño, LocalDate fechaDeCreacion,
			LocalDate fechaDeModificacion, String permisos) {
		this.nombre = nombre;
		this.extension = extension;
		this.tamaño = tamaño;
		this.fechaDeCreacion = fechaDeCreacion;
		this.fechaDeModificacion = fechaDeModificacion;
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public int getTamaño() {
		return tamaño;
	}
	
	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	
	public LocalDate getFechaDeModificacion() {
		return fechaDeModificacion;
	}
	
	public String getPermisos() {
		return permisos;
	}

	@Override
	public String prettyPrinting() {
		return this.getNombre();
	}
	
	
}
