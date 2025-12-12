package ej14;

public class Esfera extends Pieza {
	private double radio;
	
	public double getSuperficie() {
		//Superficie de una esfera: 4 * π * radio 2
		return 4 * Math.PI * Math.pow(radio, 2);
	}
	
	public double getVolumen() {
		//Volumen de una esfera: ⁴⁄₃ * π * radio ³.
		return 4/3 * Math.PI * Math.pow(radio, 3);
	}
}
