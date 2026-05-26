package ej4Topografias;

public class Pantano implements Topografia {
	
	public Pantano() {
		
	}
	
	public double proporcionDeAgua() {
		return 0.7;
	}

	public boolean esIgual(Topografia t) {
		
		return t.proporcionDeAgua() == 0.7;
	}
	
}
