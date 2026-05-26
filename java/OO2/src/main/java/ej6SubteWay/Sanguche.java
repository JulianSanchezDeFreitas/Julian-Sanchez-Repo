package ej6SubteWay;

public class Sanguche {

	private double precioPan;
	private double precioPrincipal;
	private double precioAdherezo;
	private double precioAdicional;
	
	public void setPrecioPan(double precioPan) {
		this.precioPan = precioPan;
	}
	public void setPrecioPrincipal(double precioPrincipal) {
		this.precioPrincipal = precioPrincipal;
	}
	public void setPrecioAdherezo(double precioAdherezo) {
		this.precioAdherezo = precioAdherezo;
	}
	public void setPrecioAdicional(double precioAdicional) {
		this.precioAdicional = precioAdicional;
	}
	
	public double costoTotal() {
		return precioAdherezo + precioAdicional + precioPan + precioPrincipal;
		
	}
}
