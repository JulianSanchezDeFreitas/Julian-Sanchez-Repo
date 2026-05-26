package ej6SubteWay;

public class VeganoBuilder implements Builder {

	private Sanguche sanguche;

	
	public VeganoBuilder() {
		sanguche = new Sanguche();
	}

	@Override
	public void buildPan() {
		sanguche.setPrecioPan(100);
		
	}

	@Override
	public void buildPrincipal() {
		sanguche.setPrecioPrincipal(500);
		
	}

	@Override
	public void buildAdherazo() {
		sanguche.setPrecioAdherezo(20);
	}

	@Override
	public void buildAdicional() {
		sanguche.setPrecioAdicional(0);
	}
	
	
}
