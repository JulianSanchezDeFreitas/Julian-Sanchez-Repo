package parcialesGrafos;

import java.util.List;

import grafoListAdy.AdjListGraph;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class TestBuscadorDeCaminos {
    public static void main(String[] args) {
        Graph<String> bosque = new AdjListGraph<>();
        Vertex<String> casaCaperucita = bosque.createVertex("casa caperucita");
        Vertex<String> claro1 = bosque.createVertex("claro 1");
        Vertex<String> claro2 = bosque.createVertex("claro 2");
        Vertex<String> claro3 = bosque.createVertex("claro 3");
        Vertex<String> claro4 = bosque.createVertex("claro 4");
        Vertex<String> claro5 = bosque.createVertex("claro 5");
        Vertex<String> casaAbuelita = bosque.createVertex("casa abuelita");
        bosque.connect(casaCaperucita, claro3, 4);
        bosque.connect(casaCaperucita, claro1, 3);
        bosque.connect(casaCaperucita, claro2, 4);
        bosque.connect(claro3, claro5, 15);
        bosque.connect(claro1, claro5, 3);
        bosque.connect(claro1, claro2, 4);
        bosque.connect(claro2, claro1, 4);
        bosque.connect(claro2, claro5, 11);
        bosque.connect(claro2, claro4, 10);
        bosque.connect(claro5, casaAbuelita, 4);
        bosque.connect(claro4, casaAbuelita, 9);





        BuscadorDeCaminos buscador = new BuscadorDeCaminos(bosque);
        List<List<String>> retorno = buscador.recorridosMasSeguro();

        System.out.println("retorno");
        System.out.println(retorno);
    }
}
