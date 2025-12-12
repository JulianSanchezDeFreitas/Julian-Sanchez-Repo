package ej29;



public abstract class Plan {
	protected double ipMax;

	public Plan(int ipMax) {
		this.ipMax = ipMax;
	}
	
	public abstract double costoBase();
	
	public double costoTotal(Integer cantidadIps) {
		return this.validacionIps(cantidadIps) + costoBase();
		}
	
	protected double validacionIps(Integer cantidadIps) {
		if (cantidadIps - ipMax > 0) {
			return cantidadIps - ipMax;
		}
		return 0;
	}
}
