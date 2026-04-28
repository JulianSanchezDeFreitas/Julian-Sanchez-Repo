package ej2CalculoDeSueldo;

public class Pasante extends Empleado {

	private static final int VALOR_EXAMEN_RENDIDO = 2000;
	private static final int SUELDO_BASE = 20000;
	private int examenesRendidos;
	
	
	
	public Pasante(int examenesRendidos) {
		this.examenesRendidos = examenesRendidos;
	}

	public int getExamenesRendidos() {
		return examenesRendidos;
	}

	public void setExamenesRendidos(int examenesRendidos) {
		this.examenesRendidos = examenesRendidos;
	}

	@Override
	protected double sueldoBasico() {
		
		return SUELDO_BASE ;
	}

	@Override
	protected double adicional() {

		return VALOR_EXAMEN_RENDIDO * this.getExamenesRendidos();
	}

}
