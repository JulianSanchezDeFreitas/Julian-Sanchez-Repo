package parcialesGrafos;

import java.util.LinkedList;
import java.util.List;

import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class BuscadorDeCaminos {
    private Graph<String> bosque;
    
    public BuscadorDeCaminos(Graph<String> bosque){
        this.bosque = bosque;

    }

    private List<List<String>> recorridosMasSeguroPrivate(Vertex<String> vertice, List<String> caminoActual, List<List<String>> retorno, boolean[] marcas){
        caminoActual.add(vertice.getData());
        marcas[vertice.getPosition()] = true;
        if (vertice.getData().equals("casa abuelita")) {
            if (retorno == null) {
                retorno = new LinkedList<>();
            }
            List<String> aux = new LinkedList<>();
            aux.addAll(caminoActual);
            retorno.add(aux);
        }else{
            List<Edge<String>> aristas = bosque.getEdges(vertice);
            Vertex<String> vecino = null;
            for (Edge<String> a : aristas) {
                vecino = a.getTarget();
                if (a.getWeight() <= 5 && !marcas[vecino.getPosition()]) {
                    retorno = recorridosMasSeguroPrivate(vecino, caminoActual, retorno, marcas);
                }
            }
        }
        caminoActual.removeLast();
        marcas[vertice.getPosition()] = false;
        
        return retorno;
    }
    
    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> retorno = null;
        Vertex<String> verticeorigen = bosque.search("casa caperucita");
        if (verticeorigen != null) {
            boolean[] marcas = new boolean[bosque.getSize()];
            List<String> caminoActual = new LinkedList<>();
            retorno = recorridosMasSeguroPrivate(verticeorigen, caminoActual, retorno, marcas);
        }
        return retorno;
    }

}
