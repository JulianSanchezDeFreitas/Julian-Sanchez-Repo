package ej6SubteWay;

public class VegetarianoBuilder implements Builder {

private Sanguche sanguche;
	
	@Override
	public void buildPan() {
		sanguche.setPrecioPan(120);
	}

	@Override
	public void buildPrincipal() {
		sanguche.setPrecioPrincipal(200);
	}

	@Override
	public void buildAdherazo() {
		sanguche.setPrecioAdherezo(0);
	}

	@Override
	public void buildAdicional() {
		sanguche.setPrecioAdicional(100);
	}
	
}
