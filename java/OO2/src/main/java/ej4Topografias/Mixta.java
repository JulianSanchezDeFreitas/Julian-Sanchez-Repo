package ej4Topografias;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Topografia {

	private List<Topografia> partes;
	
	public Mixta(List<Topografia> partes) {
		// si no son 4 los elementos de la lista no deberia instanciarse el objeto, avisar el error 
		if (partes.size() == 4) {
			this.partes = partes;			
		}
	}
	
	public List<Topografia> getPartes(){
		List<Topografia> partesRetorno = new ArrayList<>();
		partesRetorno.addAll(partes);
		return partesRetorno;
	}
	
	public double proporcionDeAgua() {
		return (partes.stream()
				.mapToDouble(p->p.proporcionDeAgua())
				.sum()
				/4);
	}
	

	public boolean esIgual(Topografia t) {
		if( t.proporcionDeAgua() == 1 || t.proporcionDeAgua() == 0 ) {
			return false;
		}
		
		 Mixta mixta= (Mixta) t;
		 return this.getPartes().equals(mixta.getPartes());
	}
}
