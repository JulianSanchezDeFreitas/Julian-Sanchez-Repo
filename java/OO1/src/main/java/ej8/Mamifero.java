package ej8;

import java.time.LocalDate;



public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate nacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero() {
		
	}
	public Mamifero(String nombre) {
		nacimiento = LocalDate.now();
		identificador = nombre;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if (madre != null && madre.getPadre() != null) {
			return madre.getPadre();
		}
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (madre != null && madre.getMadre() != null) {
			return madre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (padre != null && padre.getPadre() != null) {
			return padre.getPadre();
		}
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (padre != null && padre.getMadre() != null) {
			return padre.getMadre();
		}
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		boolean tiene = false;
		if (madre != null) {
			tiene = madre.tieneComoAncestroA(unMamifero);
			if (madre.equals(unMamifero) || tiene) {
				return true;
			}
		}
		if (padre != null) {
			tiene = padre.tieneComoAncestroA(unMamifero);
			if (padre.equals(unMamifero) || tiene) {
				return true;
			}
		}
		return tiene;
	
	}
}