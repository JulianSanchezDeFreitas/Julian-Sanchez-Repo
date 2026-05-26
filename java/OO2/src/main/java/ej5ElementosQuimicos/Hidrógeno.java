package ej5ElementosQuimicos;

public class Hidrógeno implements ElementoQuimico{

	
	public Hidrógeno() {

	}

	@Override
	public String formula() {
		return "H";
	}

	@Override
	public int pesoMolecular() {
		return 1;
	}

	@Override
	public int carga() {
		return 1;
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
