package ej4Topografias;

import java.util.ArrayList;
import java.util.List;

public class Topografia {

	private List<Component> componentes;
	
	public Topografia() {
		componentes = new ArrayList<Component>();
	}
	
	public boolean agregarComponente(Component c) {
		return componentes.add(c);
	}
	
	public double proporcionDeAgua() {
		return componentes.stream()
				.mapToDouble(c->c.proporcionDeAgua())
				.sum();
	}
	
	public List<Component> getComponentes() {
		return this.componentes;
	}
	
	public boolean esIgual(Topografia t) {
		return componentes.equals(t.getComponentes());
	}
}
