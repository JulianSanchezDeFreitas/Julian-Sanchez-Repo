package ej5ElementosQuimicos;

public class Calcio implements ElementoQuimico {

	
	public Calcio() {

	}

	@Override
	public String formula() {
		return "Ca";
	}

	@Override
	public int pesoMolecular() {
		return 40;
	}

	@Override
	public int carga() {
		return 2;
	}

	@Override
	public boolean esValida() {
		return true;
	}

	@Override
	public boolean esMetal() {
		// TODO Auto-generated method stub
		return true;
	}

}
