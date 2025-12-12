package pruebas;



public abstract class Plan {
	protected double ipMax;

	public Plan(int ipMax) {
		this.ipMax = ipMax;
	}
	
	public abstract double costoBase();
	
	public abstract double costoPenalizacion(Integer cantidadIps);
	
	public double costoTotal(Integer cantidadIps, int anios) {
		System.out.print("estoy en plan  | ");
		return costoPenalizacion(cantidadIps) + this.costoBase();
	}
	
	protected double validacionIps(Integer cantidadIps) {
		System.out.print("estoy en plan  | ");
		if (cantidadIps - ipMax > 0) {
			return cantidadIps - ipMax;
		}
		return 0;
	}
}
