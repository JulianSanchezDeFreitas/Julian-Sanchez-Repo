package ej2CalculoDeSueldo;

public abstract class EmpleadoConFamilia extends Empleado {

	protected static final int VALOR_CASADO = 5000;
	protected final int VALOR_HIJO = 2000;
	private boolean casado;
	private int hijos;

	
	
	public EmpleadoConFamilia(boolean casado, int hijos) {
		this.casado = casado;
		this.hijos = hijos;
	}

	public boolean esCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
	}

	protected double adicional() {
		double total = 0;
		if (this.esCasado()) {
			total += VALOR_CASADO;
		}
		return total + VALOR_HIJO  * getHijos();
	}

	

}