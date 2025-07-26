package parcialesGrafos;

import java.util.LinkedList;
import java.util.List;

import grafoListAdy.AdjListGraph;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> grafo = new AdjListGraph<>();
		Vertex<Integer> vert7 = grafo.createVertex(7);
		Vertex<Integer> vert1 = grafo.createVertex(1);
		Vertex<Integer> vert4 = grafo.createVertex(4);
		Vertex<Integer> vert2 = grafo.createVertex(2);
		Vertex<Integer> vert3 = grafo.createVertex(3);
		Vertex<Integer> vert5 = grafo.createVertex(5);
		Vertex<Integer> vert6 = grafo.createVertex(6);

		grafo.connect(vert1, vert4);
		grafo.connect(vert1, vert2);
		grafo.connect(vert2, vert3);
		grafo.connect(vert2, vert1);
		grafo.connect(vert6, vert5);
		grafo.connect(vert3, vert6);

		Graph<String> grafo2 = new AdjListGraph<>();
		Vertex<String> vert17 = grafo2.createVertex("casa");
		Vertex<String> vert11 = grafo2.createVertex("patio");
		Vertex<String> vert14 = grafo2.createVertex("pileta");
		Vertex<String> vert12 = grafo2.createVertex("baño");
		Vertex<String> vert13 = grafo2.createVertex("cocina");
		Vertex<String> vert15 = grafo2.createVertex("comedor");
		Vertex<String> vert16 = grafo2.createVertex("garage");

		grafo2.connect(vert11, vert14);
		grafo2.connect(vert11, vert12);
		grafo2.connect(vert12, vert13);
		grafo2.connect(vert12, vert11);
		grafo2.connect(vert16, vert15);
		grafo2.connect(vert13, vert16);
		
		
		//Recorridos<Integer> reco = new Recorridos<>();
		//reco.bfs(grafo);
		Mapa mapa = new Mapa(grafo2);
		//LinkedList<String> retorno = mapa.devolverCamino("baño", "casa");
		List<String> bans = new LinkedList<>();
		bans.add("casa");
		List<String> retorno = mapa.devolverCaminoExceptuando("baño", "comedor", bans);
		System.out.println("retorno");
		System.out.println(retorno);
		//Recorridos<Integer> dbsReco = new Recorridos<>();
		//List<Integer> lista = dbsReco.bfsListaMain(grafo, vert1);
		//for(int i = 0; i<lista.size();i++) {
		//	System.out.print(lista.get(i));
		//}
	}

}
