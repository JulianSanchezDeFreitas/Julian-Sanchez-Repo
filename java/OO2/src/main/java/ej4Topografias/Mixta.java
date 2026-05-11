package ej4Topografias;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Component {

	private List<Component> partes;
	
	public Mixta(List<Component> partes) {
		// si no son 4 los elementos de la lista no deberia instanciarse el objeto, avisar el error 
		if (partes.size() == 4) {
			this.partes = partes;			
		}
	}
	
	public List<Component> getPartes(){
		List<Component> partesRetorno = new ArrayList<>();
		partesRetorno.addAll(partes);
		return partesRetorno;
	}
	
	public double proporcionDeAgua() {
		return (partes.stream()
				.mapToDouble(p->p.proporcionDeAgua())
				.sum()
				/4);
	}
	
	
}
