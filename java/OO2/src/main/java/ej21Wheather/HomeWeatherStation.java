package ej21Wheather;

import java.util.List;

public class HomeWeatherStation implements WeatherData{

	//retorna la temperatura en grados Fahrenheit. 
	public double getTemperatura() {
		return 0;
	}

	//retorna la presión atmosférica en hPa
	public double getPresion() {
		return 0;
	}

	//retorna la radiación solar
	public double getRadiacionSolar() {
		return 0;
	}

	//retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
	public List<Double> getTemperaturas(){
		return null;
	}

	//retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
	public String displayData(){
	return "Temperatura F: " + this.getTemperatura() +
	   	  "Presión atmosf: " + this.getPresion() +
	   	  "Radiación solar: " + this.getRadiacionSolar();
	}

}
