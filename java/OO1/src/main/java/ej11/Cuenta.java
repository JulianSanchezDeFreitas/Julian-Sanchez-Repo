package ej11;

public abstract class Cuenta {
	private double saldo;
	
	
	public Cuenta () {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositarMonto(double monto) {
		this.saldo += monto;
		
	}
	
	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
		}
	
	public boolean extraer(double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;	
		
	}
	
	public boolean transeferirACuenta(Cuenta cuentaDestino ,double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositarMonto(monto);
			return true;
		}
		return false;
		
	}
	
	public abstract boolean puedeExtraer(double monto);
}

