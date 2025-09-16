package ej3;


public class Item {
	private String detalle;
	private Integer cantidad;
	private double costoUnitario;
	
	
	public double costo () {
		return cantidad * costoUnitario;
	}
}
