package ej21Wheather;

import java.util.List;

public abstract class WeatherDecorator implements WeatherData {

	protected WeatherData componente;
	@Override
	public double getTemperatura() {
		// TODO Auto-generated method stub
		return componente.getTemperatura();
	}

	@Override
	public double getPresion() {
		// TODO Auto-generated method stub
		return componente.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		// TODO Auto-generated method stub
		return componente.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		// TODO Auto-generated method stub
		return componente.getTemperaturas();
	}
	
	public abstract String displayData();
}
