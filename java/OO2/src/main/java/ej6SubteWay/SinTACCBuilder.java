package ej6SubteWay;

public class SinTACCBuilder implements Builder {
private Sanguche sanguche;
	
	@Override
	public void buildPan() {
		sanguche.setPrecioPan(150);
	}

	@Override
	public void buildPrincipal() {
		sanguche.setPrecioPrincipal(250);
	}

	@Override
	public void buildAdherazo() {
		sanguche.setPrecioAdherezo(18);
	}

	@Override
	public void buildAdicional() {
		sanguche.setPrecioAdicional(200);
	}
	
}
