package ej4Topografias;

public class Tierra implements Topografia{
	
	public Tierra(){
		
	}
	
	public double proporcionDeAgua(){
		return 0;
	}

	public boolean esIgual(Topografia t) {
		return t.proporcionDeAgua() == 0;
	}
	
}
