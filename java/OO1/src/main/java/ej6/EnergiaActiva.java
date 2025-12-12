package ej6;

public class EnergiaActiva {
	private int kWh;
	private double cuadroTarifario;
	
	public double costoTotal() {
		return kWh * cuadroTarifario;
		
	}
}
