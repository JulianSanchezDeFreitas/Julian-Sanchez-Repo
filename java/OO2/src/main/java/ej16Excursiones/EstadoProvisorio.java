package ej16Excursiones;

public class EstadoProvisorio implements EstadoDeExcursion{

	@Override
	public String informacion(Excursion excursion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuaio) {
		excursion.agregarInscripto(unUsuaio);
		if (excursion.tengoCupoMinimo()) {
			EstadoDeExcursion estadoDefinitivo = new EstadoDefinitivo();
			excursion.cambioDeEstado(estadoDefinitivo);
		}
		
	}

	
}
