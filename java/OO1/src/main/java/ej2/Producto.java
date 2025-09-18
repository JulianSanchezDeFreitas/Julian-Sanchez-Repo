package ej2;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto( String descripcion, double peso, int precio){
		this.peso = peso;
		precioPorKilo = precio;
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return peso*precioPorKilo;
	}
	public double getPeso() {
		return peso;
		
	}
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setPrecioPorKilo(double precio) {
		precioPorKilo = precio;
	}
}
