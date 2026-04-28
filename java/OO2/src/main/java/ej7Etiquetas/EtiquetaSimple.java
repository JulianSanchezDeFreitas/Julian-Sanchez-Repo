package ej7Etiquetas;

public class EtiquetaSimple extends Etiqueta {

	public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA BÁSICA ---");
        generar();
        System.out.println("-----------------------");
    }

}
