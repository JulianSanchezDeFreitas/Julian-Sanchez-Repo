package ej5ElementosQuimicos;

public interface ElementoQuimico {

	public String formula();
	public int pesoMolecular();
	public int carga();
	public boolean esValida();
	public boolean esMetal();
}
