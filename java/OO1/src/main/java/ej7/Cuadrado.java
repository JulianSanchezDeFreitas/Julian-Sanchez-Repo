package ej7;

public class Cuadrado implements Figura {
	private double lado;
	
	public void setLado(double valor) {
		lado = valor;
		
	}
	public double getLado() {
		return lado;
		
	}

	public double getPerimetro() {
		return lado * 4;
				
	}
	
	public double getArea() {
		return lado * lado;
	}
}
