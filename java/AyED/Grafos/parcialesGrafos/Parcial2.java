package parcialesGrafos;

import java.util.List;

import grafosInterface.Edge;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Parcial2 {
    private int resolverPrivate(int tiempo, Graph<Recinto> sitios, Vertex<Recinto >vertice, boolean[] marcas){
        int retorno;
        marcas[vertice.getPosition()] = true;
        if ((vertice.getData().getTiempo() > tiempo  )){
            retorno = 0;
        }else{
            int lugares = 0;
            int maxLugares = 0;
            tiempo = tiempo - vertice.getData().getTiempo();
            List<Edge<Recinto>> aristas = sitios.getEdges(vertice);
            for (Edge<Recinto> a : aristas) {
                int tiempoTotal = a.getWeight() + a.getTarget().getData().getTiempo();

                if (tiempoTotal < tiempo && !marcas[a.getTarget().getPosition()]) {
                    lugares = resolverPrivate(tiempo, sitios, a.getTarget(), marcas);
                }
                if (lugares > maxLugares) {
                    maxLugares = lugares;
                }
            }
            retorno = maxLugares++;
        }

        marcas[vertice.getPosition()] = true;
        return retorno;
    }

	public int resolver(Graph<Recinto> sitios, int tiempo){
        int retorno = 0;
        Recinto entrada = new Recinto(15, "entrada");
        if (sitios != null && !sitios.isEmpty()) {
            Vertex<Recinto> verticeOrigen = sitios.search(entrada);
            if (verticeOrigen != null) {
                boolean[] marcas = new boolean[sitios.getSize()];
                retorno = resolverPrivate(tiempo, sitios, verticeOrigen ,marcas);
                
            }
            
        }

        return retorno;
    }
	
}
