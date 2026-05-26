package ej5ElementosQuimicos;

public class Sodio implements ElementoQuimico {
	

	public Sodio() {
		
	}

	@Override
	public String formula() {
		return "Na";
	}

	@Override
	public int pesoMolecular() {
		return 23;
	}

	@Override
	public int carga() {
		return +1;
	}

	@Override
	public boolean esValida() {
		return true;
	}

	@Override
	public boolean esMetal() {
		return true;
	}

}
