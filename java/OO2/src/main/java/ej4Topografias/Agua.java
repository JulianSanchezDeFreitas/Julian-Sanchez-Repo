package ej4Topografias;

public class Agua implements Topografia{
	
	public Agua() {
		
	}
	
	public double proporcionDeAgua(){
		return 1;
	}

	@Override
	public boolean esIgual(Topografia t) {
		return t.proporcionDeAgua() == 1 ;
	}

	
}
