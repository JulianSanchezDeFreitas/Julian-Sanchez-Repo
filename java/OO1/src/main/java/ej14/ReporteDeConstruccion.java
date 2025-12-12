package ej14;

import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	
	public double volumenDeMaterial(String material) {
		//hacer un stream para filtrar mteriales
		double resultado = piezas.stream()
				.filter(pieza->pieza.getMaterial() == material)
				.mapToDouble(pieza->pieza.getVolumen())
				.sum();
		return resultado;
		
	}
	
	public double superficieDeColor(String color) {
		//hacer un stream para filtrar colores
		return 0;
	}
}
