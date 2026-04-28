package ej2CalculoDeSueldo;

public class Temporario extends EmpleadoConFamilia {
	private static final int VALOR_HORA = 300;
	private static final int SUELDO_BASE = 20000;
	private int horas_trabajadas;
	
	
	public Temporario(boolean casado, int hijos, int horas) {
		super(casado, hijos);
		this.horas_trabajadas = horas;
	}

	public int getHoras() {
		return horas_trabajadas;
	}

	public void setHoras(int horas) {
		this.horas_trabajadas = horas;
	}

	@Override
	protected double sueldoBasico() {
		return SUELDO_BASE + this.getHoras() * VALOR_HORA;
	}

	@Override
	public double adicional() {
		return super.adicional();
	}

}
