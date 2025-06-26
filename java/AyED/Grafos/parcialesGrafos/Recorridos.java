package parcialesGrafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ejercicio1.Queue;
import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Recorridos<T> {
	public Recorridos() {
		
	}
	
	public void dfsMain(Graph<T> grafo){
		boolean[] marcas = new boolean[grafo.getSize()];
		for (int i = 0; i < grafo.getSize(); i++) {
			if(!marcas[i]) {
				dfs(i, grafo, marcas);
			}
		}
	}
	public void dfs(int i, Graph<T> grafo, boolean[] marcas) {
		
		marcas[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if (!marcas[j]) {
				dfs(j, grafo, marcas);
			}
		}
	}
	public List<T> dfsMainLista(Graph<T> grafo){
		boolean[] marcas = new boolean[grafo.getSize()];
		List<T> lista = new ArrayList<>();
		for (int i = 0; i < grafo.getSize(); i++) {
			if(!marcas[i]) {

				dfsLista(i, grafo, marcas, lista);
			}
		}
		return lista;
	}
	public List<T> dfsLista(int i, Graph<T> grafo, boolean[] marcas,List<T> lista ) {
		
		marcas[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if (!marcas[j]) {
				dfsLista(j, grafo, marcas, lista);
			}
		}
		return lista;
	}
	
	public List<T> bfsListaMain(Graph<T> grafo, Vertex<T> inicial){
		Queue<Vertex<T>> cola = new Queue<>();
		List<T> listaRetorno = new LinkedList<>();
		boolean[] marca = new boolean[grafo.getSize()];
		cola.enQueue(inicial);
		marca[inicial.getPosition()]= true;
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!marca[i]) {
				bfsLista(i, marca, grafo, listaRetorno, cola);				
			}
		}
		return listaRetorno;
	}
	
	private List<T> bfsLista(int i, boolean[] marca, Graph<T> grafo, List<T> lista, Queue<Vertex<T>> cola){
		while(!cola.isEmpty()) {
			Vertex<T> v = cola.deQueue();
			lista.add(v.getData());
			List<Edge<T>> arista = grafo.getEdges(v);
			for(Edge<T> e:arista) {
				if(!marca[e.getTarget().getPosition()]) {
					cola.enQueue(e.getTarget());
					marca[e.getTarget().getPosition()] = true;
				}
			}
		}
		
		return lista;
		
		
	}
	
	
}
