package ej7;

public class Circulo implements Figura {
	private double radio;
	private double diametro;
	
	public double getDiametro() {
		return diametro;
		
	}
	
	public void setDiametro(double valor) {
		this.diametro = valor;
	}
	
	public double getRadio() {
		return radio;
		
	}
	
	public void setRadio(double valor) {
		this.radio = valor;
		diametro = radio * 2;
		
	}
	
	public double getPerimetro() {
		return Math.PI * diametro;
		
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
		
	}
}
