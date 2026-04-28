package ej7Etiquetas;
/*
 * el metodo generar se encuentra en las sublclases con codigo practicamente duplicado
 *  hice un extract method para separar las lineas que estan duplicadas
 *  y luego pull up method a la superclase Eqtiqueta
 */
public abstract class Etiqueta {
	protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }

	public void generar() {
		System.out.println("Producto: " + nombreProducto);
	    System.out.println("Precio: $" + precio);
	}
}


