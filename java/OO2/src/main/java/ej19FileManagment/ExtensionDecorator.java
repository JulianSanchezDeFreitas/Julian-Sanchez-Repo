package ej19FileManagment;

public class ExtensionDecorator extends Decorator {

	private String extensio;
	
	
	public ExtensionDecorator(Archivo archivo, String extensio) {
		super(archivo);
		this.extensio = extensio;
	}


	@Override
	public String prettyPrinting() {
		String retorno ;
		retorno = archivo.prettyPrinting() + " " + this.extra();
		return retorno;
	}

	private String extra() {
		return this.extensio;
	}
}
