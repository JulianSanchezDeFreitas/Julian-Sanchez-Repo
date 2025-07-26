package parcialesGrafos;

import java.util.LinkedList;
import java.util.List;

import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> asignacion){
		mapaCiudades = asignacion;
	}
	private LinkedList<String> devolverCaminoPrivate(Vertex<String> vertice, boolean[] marcas, LinkedList<String> caminoActual, String ciudad2, LinkedList<String> retorno){
		if(retorno == null) {
			caminoActual.add(vertice.getData());
			System.out.println(caminoActual);
			marcas[vertice.getPosition()] = true;
			if(!vertice.getData().equals(ciudad2)){
				List<Edge<String>> aristas = mapaCiudades.getEdges(vertice);
				for (Edge<String> a : aristas) {
					if(!marcas[a.getTarget().getPosition()]){
						retorno = devolverCaminoPrivate(a.getTarget(), marcas, caminoActual, ciudad2, retorno);
						caminoActual.removeLast();
						marcas[a.getTarget().getPosition()] = false;
						
					}
				}
			}else{
				retorno = new LinkedList<>();
				retorno.addAll(caminoActual);
			}		
			
		}
		return retorno;		
	}
	public LinkedList<String> devolverCamino(String ciudad1, String ciudad2){
		LinkedList<String> retorno = null;
		Vertex<String> vertice = mapaCiudades.search(ciudad1);
		if (vertice != null) {
			LinkedList<String> caminoActual = new LinkedList<>();
			boolean[] marcas = new boolean[mapaCiudades.getSize()];
			retorno = devolverCaminoPrivate(vertice,marcas,caminoActual, ciudad2, retorno);
		}
		return retorno;
	}
	
	private List<String> devolverCaminoExceptuando(Vertex<String> vertice, String ciudadFin,List<String> ciudades ,boolean[] marcas,List<String> caminoActual, List<String> retorno ){
		if (retorno == null) {
			if(!ciudades.contains(vertice.getData())) {
				caminoActual.add(vertice.getData());
				System.out.print(caminoActual);
				if(!vertice.getData().equals(ciudadFin)) {
					marcas[vertice.getPosition()] = true;
					List<Edge<String>> aristas = mapaCiudades.getEdges(vertice);
					for (Edge<String> a:aristas) {
						if(!marcas[a.getTarget().getPosition()]) {
							retorno = devolverCaminoExceptuando(a.getTarget(), ciudadFin, ciudades, marcas, caminoActual, retorno);
							marcas[a.getTarget().getPosition()] = false;
						}							
					}
					caminoActual.removeLast();
				}else {
					System.out.print("devuelvo");
					System.out.print(caminoActual);
					retorno = new LinkedList<>(); 
					retorno.addAll(caminoActual);
					
				}
						
				
			}
		}
		
		
		return retorno;
	}
	
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades) {
		List<String> retorno = null;
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			Vertex<String> verticeOrigen = mapaCiudades.search(ciudad1);
			if(verticeOrigen!=null) {
				boolean[] marcas = new boolean[mapaCiudades.getSize()];
				List<String> caminoActual = new LinkedList<>();
				retorno = devolverCaminoExceptuando(verticeOrigen, ciudad2, ciudades, marcas ,caminoActual, retorno);
				
			}
		}
		return retorno;
	}
	
}
