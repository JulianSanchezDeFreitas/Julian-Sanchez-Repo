package ej9Pedidos;

import java.util.List;

public class Pedido {
	private final double DESCUENTO_ANTIGUEDAD = 0.9;
	private final int MINIMO_ANTIGUEDAD = 5;
	private Cliente cliente;
	  private List<Producto> productos;
	  private FormaDePago formaPago;

	  public Pedido(Cliente cliente, List<Producto> productos, FormaDePago formaPago) {
	    this.cliente = cliente;
	    this.productos = productos;
	    this.formaPago = formaPago;
	  }

	  public double getCostoTotal() {

		  return (costoProductos() * formaPago.recargoFormaDePago()) * antiguedadCliente();
	  }

	private double antiguedadCliente() {
		int añosDesdeFechaAlta = cliente.antiguedad();
	    if (añosDesdeFechaAlta > MINIMO_ANTIGUEDAD) {
	      return DESCUENTO_ANTIGUEDAD;
	    }
	    return 1;
	}




	private double costoProductos() {
		double costoProductos = productos.stream()
				.mapToDouble(p->p.getPrecio())
				.sum();
		return costoProductos;
	}
}
