package ej5ElementosQuimicos;

public class Cloro implements ElementoQuimico{

	
	public Cloro() {

	}

	@Override
	public String formula() {
		return "Cl";
	}

	@Override
	public int pesoMolecular() {
		return 35;
	}

	@Override
	public int carga() {
		return -1;
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
