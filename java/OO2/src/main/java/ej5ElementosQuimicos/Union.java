package ej5ElementosQuimicos;


import java.util.List;

public class Union implements ElementoQuimico {
	
	private List<ElementoQuimico> elementos;
	
	public Union(List<ElementoQuimico> elementos){
		this.elementos = elementos;
	}
	
	@Override
	public String formula() {
		// se requiere que los elementos esten ordenados, si no ordenar antes de arrancar el algoritmo

		int contador = 0;
		String actual = elementos.getFirst().formula();
		String retorno = "";
		for (ElementoQuimico elemento : elementos) {
			if (actual.equals(elemento.formula())) {
				contador += 1;
			}else {
				retorno += actual;
				if (contador > 1) {
					retorno += contador;
				}
				contador = 1;
				actual = elemento.formula();
			}
		}
		retorno += actual;
		if (contador > 1) {
			retorno += contador;
		}
		return retorno;
	}
	public void agregarElemento(ElementoQuimico e) {
		elementos.add(e);
	}

	@Override
	public int pesoMolecular() {
		return elementos.stream()
				.mapToInt(e->e.pesoMolecular())
				.sum();
	}

	@Override
	public int carga() {
		return elementos.stream()
				.mapToInt(e->e.carga())
				.sum();
	}

	@Override
	public boolean esValida() {
		return !this.esMetal();
}

	@Override
	public boolean esMetal() {
		for (ElementoQuimico elemento : elementos) {
			if(!elemento.esMetal()) {
				return false;
			}
		}
		return true ;
	}

	
}
