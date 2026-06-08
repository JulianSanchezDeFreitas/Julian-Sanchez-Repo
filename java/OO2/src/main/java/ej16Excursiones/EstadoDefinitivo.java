package ej16Excursiones;

public class EstadoDefinitivo implements EstadoDeExcursion{

	@Override
	public String informacion(Excursion excursion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuaio) {
		excursion.agregarInscripto(unUsuaio);
		if (excursion.tengoCupoMaximo()) {
			EstadoDeExcursion estado = new EstadoCerrado();
			excursion.cambioDeEstado(estado);
		}
	}

}
