package ej14ArmadoDePC;

public class BuilderIntermedio extends BuilderEquipo {

	@Override
	public void crearProcesador() {
		equipo.agregarComponente(catalogo.getComponentes("Procesador intermedio"));
		
	}

	@Override
	public void crearMemoria() {
		equipo.agregarComponente(catalogo.getComponentes("16 gb"));
		
	}

	@Override
	public void crearDisco() {
		equipo.agregarComponente(catalogo.getComponentes("SSD 500 gb"));
		
	}

	@Override
	public void crearTarjetaGrafica() {
		equipo.agregarComponente(catalogo.getComponentes("GTX 1650"));
		
	}

	@Override
	public void crearGabinete() {
		equipo.agregarComponente(catalogo.getComponentes("Fuente 800 w"));
		
	}

	
}
