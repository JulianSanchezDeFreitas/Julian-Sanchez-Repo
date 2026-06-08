package ej16Excursiones;

public class EstadoCerrado implements EstadoDeExcursion{

	@Override
	public String informacion(Excursion excursion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuaio) {
		excursion.agregarAEspera(unUsuaio);
	}

}
