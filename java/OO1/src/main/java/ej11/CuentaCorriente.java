package ej11;

public class CuentaCorriente extends Cuenta{
	// el descubierto se plantea como numero negativo 
	public double descubiero;
	
	public CuentaCorriente () {
		descubiero = 0;
	}

	public double getDescubiero() {
		return descubiero;
	}

	public void setDescubiero(double descubiero) {
		this.descubiero = descubiero;
	}
	
	public boolean puedeExtraer(double monto) {
		
		return this.getSaldo() - monto > descubiero;
				
	}
}
