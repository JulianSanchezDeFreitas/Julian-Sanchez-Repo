package ej11FileSystem;

public class FileSystem {

	private Directorio raiz;
	
	public int tamañoTotalOcupado() {
		return raiz.getTamaño();
	}
	
	public Archivo archivoMasGrande() {
		return raiz.archivoMasGrande();
	}
	
	public Archivo archivoMasNuevo() {
		return raiz.archivoMasNuevo();
	}
}
