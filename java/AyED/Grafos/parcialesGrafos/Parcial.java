package parcialesGrafos;

import java.util.LinkedList;
import java.util.List;

import ejercicio1.Queue;
import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Parcial<T> {
	public Integer bfsInfeccion(Graph<T> grafo, Vertex<String> inicial) {
		boolean[] marca = new boolean[grafo.getSize()];
		Queue<Vertex<String>> cola = new Queue<>();
		int tiempo = 0;
		marca[inicial.getPosition()] = true;
		cola.enQueue(inicial);
		cola.enQueue(null);
		while(!cola.isEmpty()) {
			Vertex<String> v = cola.deQueue();
			if (v != null) {
				List<Edge<String>> lista = new LinkedList<>();
				for(Edge<String> e:lista) {
					Vertex<String> w = e.getTarget();
					if(!marca[w.getPosition()]) {
						marca[w.getPosition()] = true;
						cola.enQueue(w);
						
					}
				}
			}else if (!cola.isEmpty()){
				cola.enQueue(null);
				tiempo++;
			}
		}
		
		return tiempo;
	}
}
