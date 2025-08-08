package parcialesGrafos;

import java.util.LinkedList;
import java.util.List;

import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Parcial5 {
    private List<String> rutaOptimaPrivate(Graph<String> grafo, Vertex<String> vertice, List<String> caminoActual, List<String> retorno, boolean[] marcas, int pociones){
        
        caminoActual.add(vertice.getData());
        marcas[vertice.getPosition()] = true;
        if (vertice.getData().equals("aldea")) {
            if(caminoActual.size()>retorno.size() && !retorno.isEmpty()){
                    retorno.clear();
                }
            retorno.addAll(caminoActual);
        }else{
            List<Edge<String>> aristas = grafo.getEdges(vertice);
            for (Edge<String> a : aristas) {
                int cantPociones = a.getWeight();
                if (pociones-cantPociones > 0 && !marcas[vertice.getPosition()]) {
                    retorno = rutaOptimaPrivate(grafo, a.getTarget(), caminoActual, retorno, marcas, pociones);
                }
            }
        }
        caminoActual.removeLast();
        marcas[vertice.getPosition()] = false;
        
        return retorno;
    }

    public List<String> rutaOptima(Graph<String> grafo , String castillo ,String aldea ,int maxPociones){
        List<String> retorno = null;
        if (grafo != null && !grafo.isEmpty()) {
            Vertex<String> aldeaV = grafo.search(aldea);
            Vertex<String> castilloV = grafo.search(castillo);
            if(aldeaV != null && castilloV != null){
                retorno = new LinkedList<>();
                List<String> caminoActual = new LinkedList<>();
                boolean[] marcas = new boolean[grafo.getSize()];
                retorno = rutaOptimaPrivate(grafo, castilloV,retorno, caminoActual, marcas, maxPociones);

            }
        }
        return retorno;
    }
}
