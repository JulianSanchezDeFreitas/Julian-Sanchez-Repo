package ej29;

import java.util.List;

public class SesionDeJuego extends Actividad {
	private List<Item> items;
	
	public double Costo() {
		double total = 0;
		if(this.duarcion > 360) {
			total = items.stream()
			.mapToDouble(i -> i.costo())
			.sum();
		}
		return total;
	}
}
