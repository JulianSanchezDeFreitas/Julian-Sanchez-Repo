package ej6;

public class Consumo {
	private EnergiaActiva activa;
	private EnergiaReactiva reactiva;
	
	
	public Factura emitirFactura(Usuario unUsuario) {
		Factura factura = new Factura(this.montoTotal() , reactiva.aptoBonificacion(), unUsuario);	
		return factura;
	}

	public double montoTotal() {
		double montoTotal = activa.costoTotal();
		if(reactiva.aptoBonificacion()) {
			montoTotal = montoTotal * 0.10;
		}
		return montoTotal;
	}
}
