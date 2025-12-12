package ej29;

public class Individual extends Plan {
	private int minutosContratados;

	public Individual(int ipMax, int minutosContratados) {
		super(ipMax);
		this.minutosContratados = minutosContratados;
	}
	
	public double costoBase() {
		return 20 * minutosContratados ;
	}
	
	
	public double costoPenalizacion(Integer cantidadIps) {
		return validacionIps(cantidadIps) * 300.0;
	}
	
	public void nada() {
		
	}
	
}
