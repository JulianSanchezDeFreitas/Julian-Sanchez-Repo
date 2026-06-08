package ej14ArmadoDePC;

public class BuilderBasico extends BuilderEquipo {

	@Override
	public void crearProcesador() {
		equipo.agregarComponente(catalogo.getComponentes("Procesador basico"));
		
	}

	@Override
	public void crearMemoria() {
		equipo.agregarComponente(catalogo.getComponentes("8 gb"));
		
	}

	@Override
	public void crearDisco() {
		equipo.agregarComponente(catalogo.getComponentes("HDD 500 gb"));
		
	}

	@Override
	public void crearTarjetaGrafica() {
	// NO POSEE	
	}

	@Override
	public void crearGabinete() {
		equipo.agregarComponente(catalogo.getComponentes("Gabinete estandar"));
		
	}

	
}
