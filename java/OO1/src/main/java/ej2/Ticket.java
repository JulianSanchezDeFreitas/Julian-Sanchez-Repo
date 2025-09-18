package ej2;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private Integer cantidadDeProductos;
	private double pesoTotal = 0;
	private double precioTotal = 0;
	private List<Producto> productos;
	
	public Ticket(Integer cantidadProductos, double pesoT, double precioT){
		fecha = LocalDate.now();
		cantidadDeProductos = cantidadProductos;
		pesoTotal = pesoT;
		precioTotal = precioT;
		precioTotal = precioTotal + this.impuesto();
		
	}
	
	public Ticket(List<Producto> productos) {
		fecha = LocalDate.now();
		cantidadDeProductos = productos.size();
		for (Producto p : productos) {
			pesoTotal += p.getPeso();
			precioTotal += p.getPrecio();
		}
		
	}
	public double impuesto() {
		return precioTotal * 0.21;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
