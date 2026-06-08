package ej21Wheather;


public class CelsiusDecorator extends WeatherDecorator {


	@Override
	public String displayData() {
		// TODO Auto-generated method stub
		return componente.displayData() + " " +this.extra();
	}
	
	public String extra() {
		return componente.getTemperatura() - 32 / 1.8 + "";
	}

}
