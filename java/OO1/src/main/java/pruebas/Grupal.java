package pruebas;

public class Grupal extends Plan {

	
	public Grupal(int ipMax) {
		super(ipMax);
	}
	public double costoTotal(Integer cantidadIps, int anios) {
		System.out.print("estoy en grupal  | ");
		if(anios>10) {
			return super.costoTotal(cantidadIps, anios);		
		}
		return costoBase();
	}

	public double costoPenalizacion(Integer cantidadIps) {
		System.out.print("estoy en grupal  | ");
		return validacionIps(cantidadIps) * 500.0;
	}
	
	@Override
	public double costoBase() {
		System.out.print("estoy en grupal  | ");
		return ipMax * 800;
	}
	public void nadaG() {
		
	}
}
