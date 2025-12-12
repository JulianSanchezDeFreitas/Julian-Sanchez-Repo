package ej14;

public class Prisma extends Pieza{
	private double ladoMayor;
	private double ladoMenor;
	private double altura;
	
	public double getSuperficie() {
		//Superficie del prisma: 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura)
		return 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura);
	}
	
	public double getVolumen() {
		//Volumen del prisma: ladoMayor * ladoMenor * altura
		return ladoMayor * ladoMenor * altura;
	}
}
