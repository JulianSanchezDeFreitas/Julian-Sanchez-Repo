package parcialesGrafos;

import java.util.List;

import grafoListAdy.AdjListGraph;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> grafo = new AdjListGraph<>();
		Vertex<Integer> vert1 = grafo.createVertex(1);
		Vertex<Integer> vert4 = grafo.createVertex(4);
		Vertex<Integer> vert2 = grafo.createVertex(2);
		Vertex<Integer> vert3 = grafo.createVertex(3);
		Vertex<Integer> vert5 = grafo.createVertex(5);

		grafo.connect(vert1, vert4);
		grafo.connect(vert1, vert2);
		grafo.connect(vert2, vert3);
		grafo.connect(vert2, vert1);
		grafo.connect(vert5, vert5);
		
		Recorridos<Integer> dbsReco = new Recorridos<>();
		List<Integer> lista = dbsReco.bfsListaMain(grafo, vert1);
		for(int i = 0; i<lista.size();i++) {
			System.out.print(lista.get(i));
		}
	}

}
