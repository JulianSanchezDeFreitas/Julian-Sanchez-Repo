package ej16Excursiones;

public class Usuario {

	private String nombre;
	private String aepllido;
	private String mail;
	
	
	public Usuario(String nombre, String aepllido, String mail) {
		this.nombre = nombre;
		this.aepllido = aepllido;
		this.mail = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getAepllido() {
		return aepllido;
	}
	public String getMail() {
		return mail;
	}
	
	
}
