package ej14ArmadoDePC;

public class ArmadorPC {

	private BuilderEquipo builder;
	
	public ArmadorPC(BuilderEquipo builder) {
		this.builder = builder;
	}
	public Equipo construct() {
		builder.crearProcesador();
		builder.crearMemoria();
		builder.crearDisco();
		builder.crearTarjetaGrafica();
		builder.crearGabinete();
		return builder.getResultado();
	}
}
