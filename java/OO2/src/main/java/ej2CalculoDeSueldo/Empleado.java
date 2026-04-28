package ej2CalculoDeSueldo;

public abstract class Empleado {

	private static final double PORCENTAJE_DESCUENTO_ADICIONAL = 0.05;
	private static final double PORCENTAJE_DESCUENTO_BASICO = 0.13;

	public double sueldo() {
		// este es el templateMethod
		return this.sueldoBasico() + this.adicional() - this.descuento();
	}
	
	protected abstract double sueldoBasico(); 
	protected abstract double adicional();
	
	protected double descuento() {
		return this.sueldoBasico() * PORCENTAJE_DESCUENTO_BASICO + this.adicional() * PORCENTAJE_DESCUENTO_ADICIONAL;
	}
}
