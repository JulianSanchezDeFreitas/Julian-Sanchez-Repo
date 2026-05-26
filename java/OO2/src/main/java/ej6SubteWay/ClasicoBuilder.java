package ej6SubteWay;

public class ClasicoBuilder implements Builder{

	private Sanguche sanguche;
	
	@Override
	public void buildPan() {
		sanguche.setPrecioPan(100);
	}

	@Override
	public void buildPrincipal() {
		sanguche.setPrecioPrincipal(300);
	}

	@Override
	public void buildAdherazo() {
		sanguche.setPrecioAdherezo(20);
	}

	@Override
	public void buildAdicional() {
		sanguche.setPrecioAdicional(80);
	}
	
}
