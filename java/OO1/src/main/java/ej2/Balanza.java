package ej2;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private Integer cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public Balanza() {
		
	}
	
	public void ponerEnCero() {
		cantidadDeProductos = 0;
		precioTotal = 0;
		pesoTotal = 0;
		productos = new ArrayList<Producto>();
	}
	public void agregarProducto(Producto producto) {
		cantidadDeProductos++;
		precioTotal += producto.getPrecio();
		pesoTotal += producto.getPeso();
		productos.add(producto);
	}
	public List<Producto> getProductos(){
		List<Producto> ret = new ArrayList<Producto>();
		ret.addAll(productos);
		return ret;
	}
	
	public Ticket emitirTicket() {
		// dos formas de hacer tickets
		//Ticket recibo = new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
		Ticket recibo = new Ticket(productos);
		return recibo;
	}

	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	
}
