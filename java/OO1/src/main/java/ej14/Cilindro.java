package ej14;


public class Cilindro extends Pieza {
	private double altura;
	private double radio;
	
	public double getSuperficie() {
		// : 2 * π * radio  * h + 2 * π * radio ^2 
		return 2 * Math.PI * altura + 2 * Math.PI * Math.pow(radio, 2);
	}
	
	public double getVolumen() {
		// π * radio 2 * h
		return Math.PI * Math.pow(radio, 2) * altura;
	}
}
