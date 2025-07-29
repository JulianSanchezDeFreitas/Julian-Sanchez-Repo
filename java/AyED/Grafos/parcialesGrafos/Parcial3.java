package parcialesGrafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ejercicio1.Queue;

import grafosInterface.Graph;
import grafosInterface.Vertex;
import grafosInterface.Edge;

public class Parcial3 {
    public Parcial3(){

    }
    
	public List<String> resolver(Graph<Persona> mapa, Persona empleado, int gradoSeparacion){
        List<String> retorno = null;
        if (!(gradoSeparacion == 0 || mapa == null || mapa.isEmpty())) {
            // continuo el ejercicio
            Vertex<Persona> verticeEmpleado = null;
            Vertex<Persona> siguiente = null;
            Iterator<Vertex<Persona>> iter = mapa.getVertices().iterator();
            // busco el empleado en el mapa
            while (iter.hasNext() && verticeEmpleado == null) {
                siguiente = iter.next();
                if (siguiente.getData().equals(empleado)) {
                    verticeEmpleado = siguiente;
                }
            }
            // si existe el empleado empiezo a buscar los jubilados
            if (!(verticeEmpleado == null)) {
                // creo la cola donde guardo los jubilados
                Queue<Vertex<Persona>> cola = new Queue<>();
                cola.enQueue(verticeEmpleado);
                cola.enQueue(null);
                int nivel = 0;
                int cantidadJubilados = 10;
                retorno = new LinkedList<>();
                boolean[] marcas = new boolean[mapa.getSize()];
                // si la cola no esta vacio, puedo seguir incluyendo jubilados a la lista, y sigo en el grado de separacion
                while (!cola.isEmpty() && cantidadJubilados > 0 && nivel < gradoSeparacion) {
                    // desencolo de la lista
                    siguiente = cola.deQueue();
                    if (siguiente != null) {
                        marcas[siguiente.getPosition()] = true;
                        // si no es null significa que sigo en el mismo nivel entonces busco en todos sus vecinos quienes cumplen condicion
                        List<Edge<Persona>> aristas = mapa.getEdges(siguiente);
                        for (Edge<Persona> a : aristas) {
                            Vertex<Persona> vecino = a.getTarget();
                            // si el vecino es jubilado y puedo seguir incluyendo jubilados, lo agrego a la lista, lo encolo y agrego a la lista de nombres
                            if (vecino.getData().soyJubilado() && cantidadJubilados > 0 && !marcas[vecino.getPosition()]) {
                                marcas[vecino.getPosition()] = true;
                                cola.enQueue(vecino);
                                retorno.add(vecino.getData().getNombre());
                                cantidadJubilados--;
                            }
                        }
                    }else{
                        if (!cola.isEmpty()) {
                            // si desencole un null significa que pase de nivel o termine la cantidad de vertices en el grafo
                            nivel++;
                            cola.enQueue(null);
                        }
                    }
                }

                                
            }


        }
        // si no la lista queda en null

        return retorno;
    }
	
}
