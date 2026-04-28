package ej9Pedidos;

public abstract class FormaDePago {
	protected double porcentajeRecargo;
	
	public double recargoFormaDePago() {
		return this.porcentajeRecargo;
	}
}
