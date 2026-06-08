package ej21Wheather;

public class PresionDecorator extends WeatherDecorator {

	@Override
	public String displayData() {
		return componente.displayData() + "; presion atmosferica  " + this.getPresion();
	}

	
	
}
