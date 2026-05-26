package ej5ElementosQuimicos;

public class Oxigéno implements ElementoQuimico {

	
	public Oxigéno() {

	}

	@Override
	public String formula() {
		return "O";
	}

	@Override
	public int pesoMolecular() {
		return 16;
	}

	@Override
	public int carga() {
		return -2;
	}

	@Override
	public boolean esValida() {
		return true;
	}

	@Override
	public boolean esMetal() {
		return false;
	}

	
}
