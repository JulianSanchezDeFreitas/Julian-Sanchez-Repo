package ej6;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		consumos = new ArrayList<Consumo>(); 
	}
	
	public void consultarFactura() {
		Consumo consumo = consumos.getLast();
		Factura factura = consumo.emitirFactura(this);
		
	}
	public void agregarFactura(Consumo consumo) {
		consumos.add(consumo);
	}
}
