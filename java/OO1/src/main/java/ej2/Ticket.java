package ej2;

import java.time.LocalDate;

public class Ticket {
	private LocalDate fecha;
	private Integer cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(Integer cantidadProductos, double pesoT, double precioT){
		fecha = LocalDate.now();
		cantidadDeProductos = cantidadProductos;
		pesoTotal = pesoT;
		precioTotal = precioT;
		precioTotal = precioTotal + this.impuesto();
	}
	public double impuesto() {
		return precioTotal * 0.21;
	}
}
