package ej7Etiquetas;

public class EtiquetaDetalle extends Etiqueta {
	public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA DETALLE ---");
        generar();
        System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("-----------------------");
    }
}
