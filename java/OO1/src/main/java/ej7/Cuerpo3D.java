package ej7;



public class Cuerpo3D {
	private double altura;
	private Figura directriz;
	
	
	public void setAltura(double valor) {
		altura = valor;
		
	}
	
	public double getAltura() {
		return altura;
		
	}
	
	public void setCaraBasal(Figura cara) {
		directriz = cara;
	}
	public double getVolumen() {
		return directriz.getArea() * altura;
		
	}
	
	public double getSuperficieExterior() {
		double areaCara = directriz.getArea();
		double perimetroCara = directriz.getPerimetro();
		
		return 2 * areaCara + perimetroCara * altura;
	}
}
