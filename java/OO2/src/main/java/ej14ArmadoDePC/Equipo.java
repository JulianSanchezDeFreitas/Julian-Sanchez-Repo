package ej14ArmadoDePC;

import java.util.List;

public abstract class Equipo {

	private List<Componente> componentes;
	
	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}
	
	public double getConsumo() {
		return componentes.stream()
				.mapToDouble(c->c.getConsumo())
				.sum();
	}
	
	public double calcularPrecio() {
		return componentes.stream()
				.mapToDouble(c->c.getPrecio())
				.sum();
	}
}
