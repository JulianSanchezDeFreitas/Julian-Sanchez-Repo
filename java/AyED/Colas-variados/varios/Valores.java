package varios;

public class Valores {
	private int min;
	private int max;
	private double promedio;
	
	public Valores(int min, int max, double promedio) {
		this.min = min;
		this.max = max;
		this.promedio = promedio;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	
}
