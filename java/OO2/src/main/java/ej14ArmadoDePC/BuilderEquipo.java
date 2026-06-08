package ej14ArmadoDePC;

public abstract class BuilderEquipo {
	protected Equipo equipo;
	protected Catalogo catalogo;
	
	public abstract void crearProcesador();
	public abstract void crearMemoria();
	public abstract void crearDisco();
	public abstract void crearTarjetaGrafica();
	public abstract void crearGabinete();
	
	public Equipo getResultado() {
		return equipo;
	}
}
