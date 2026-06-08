package ej19FileManagment;

public abstract class Decorator implements Archivo {

	protected Archivo archivo;
	
	public Decorator(Archivo archivo) {
		this.archivo = archivo;
	}

	@Override
	public abstract String prettyPrinting();
	
	
}
