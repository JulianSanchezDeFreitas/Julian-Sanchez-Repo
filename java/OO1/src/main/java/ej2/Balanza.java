package ej2;

public class Balanza {
	private Integer cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		cantidadDeProductos = 0;
		precioTotal = 0;
		pesoTotal = 0;
	}
	public void agregarProducto(Producto producto) {
		cantidadDeProductos++;
		precioTotal += producto.getPrecio();
		pesoTotal += producto.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket recibo = new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
		return recibo;
	}
}
