package ej6;

import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private double monto;
	private boolean bonificacion;
	private Usuario usuario;
	
	public Factura(double monto, boolean bonificacion, Usuario usuario) {
		fecha = LocalDate.now();
		this.monto = monto;
		this.bonificacion = bonificacion;
		this.usuario = usuario;
	}
		
}
