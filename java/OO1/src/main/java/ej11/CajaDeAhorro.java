package ej11;

public class CajaDeAhorro extends Cuenta{
	
	
	public boolean puedeExtraer(double monto) {
		// si el monto + 2% restado el saldo es mayot a 0 devuelvo verdaderi
		return this.getSaldo() - (monto+(monto*0.02)) > 0;
	}

	@Override
	public void extraerSinControlar(double monto) {
		double saldo = getSaldo();
		saldo -= saldo + (saldo * 0.02);
		depositarMonto(monto);
	}
}
