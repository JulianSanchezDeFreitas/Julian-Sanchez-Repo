package pruebas;

public class Individual extends Plan {
	private int minutosContratados;

	public Individual(int ipMax, int minutosContratados) {
		super(ipMax);
		this.minutosContratados = minutosContratados;
	}
	
	public double costoBase() {
		System.out.print("estoy en individual | ");
		return 20 * minutosContratados ;
	}
	
	
	public double costoPenalizacion(Integer cantidadIps) {
		System.out.print("estoy en individual  | ");
		return validacionIps(cantidadIps) * 300.0;
	}
	
	
	
	
	
	
}
