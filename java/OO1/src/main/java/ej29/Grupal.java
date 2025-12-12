package ej29;

public class Grupal extends Plan {

	
	public Grupal(int ipMax) {
		super(ipMax);
	}
	public double costoPenalizacion(Integer cantidadIps, int antiguedad) {
		if(antiguedad>10) {
			return validacionIps(cantidadIps) * 500.0;			
		}
		return 0;
	}

	@Override
	public double costoBase() {
		return ipMax * 800;
	}
	public void nadaG() {
		
	}
}
