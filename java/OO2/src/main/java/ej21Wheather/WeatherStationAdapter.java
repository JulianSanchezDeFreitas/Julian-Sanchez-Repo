package ej21Wheather;

import java.util.List;

public class WeatherStationAdapter implements WeatherData{
	private HomeWeatherStation estacionDeClima;
	
	@Override
	public double getTemperatura() {
		// TODO Auto-generated method stub
		return estacionDeClima.getTemperatura();
	}

	@Override
	public double getPresion() {
		// TODO Auto-generated method stub
		return estacionDeClima.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		// TODO Auto-generated method stub
		return estacionDeClima.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		// TODO Auto-generated method stub
		return estacionDeClima.getTemperaturas();
	}
	
	@Override
	public String displayData() {
		return "";
	}

}
