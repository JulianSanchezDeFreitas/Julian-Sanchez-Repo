package ej29;

public class Item {
	private String nombre;
	private double precioUnitario;
	private Integer cantidad;
	
	
	
	public double costo() {
		return cantidad * precioUnitario;
	}
}
