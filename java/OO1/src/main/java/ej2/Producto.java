package ej2;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	public Producto(double peso, double precio, String descripcion){
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
}
