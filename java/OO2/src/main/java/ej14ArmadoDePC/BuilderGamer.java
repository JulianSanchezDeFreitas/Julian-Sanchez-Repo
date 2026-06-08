package ej14ArmadoDePC;

public class BuilderGamer extends BuilderEquipo{

	@Override
	public void crearProcesador() {
		equipo.agregarComponente(catalogo.getComponentes("Procesador gamer"));
		equipo.agregarComponente(catalogo.getComponentes("Pad termico"));
		equipo.agregarComponente(catalogo.getComponentes("Cooler"));
		
	}

	@Override
	public void crearMemoria() {
		equipo.agregarComponente(catalogo.getComponentes("32 gb"));
		equipo.agregarComponente(catalogo.getComponentes("32 gb"));
		
	}

	@Override
	public void crearDisco() {
		equipo.agregarComponente(catalogo.getComponentes("SSD 500gb"));
		equipo.agregarComponente(catalogo.getComponentes("SSD 1TB"));
		
	}

	@Override
	public void crearTarjetaGrafica() {
		equipo.agregarComponente(catalogo.getComponentes("RTX4090"));
		
	}

	@Override
	public void crearGabinete() {
		double consumo = equipo.getConsumo() * 1.5;
		equipo.agregarComponente(catalogo.getComponentes("Fuente "+ consumo+" w"));
	}


}
