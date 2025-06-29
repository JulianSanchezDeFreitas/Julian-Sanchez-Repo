package parcialesArbolesBin;

import java.util.LinkedList;

public class ParcialArboles3 {
// esta clase, apartir de la variable de instanci arbol, busca caminos que cumplan la condicion de ser alternado entre positivos y negativos enteros
// devuelve la primera ocurrencia, en comentarios se agregan correcciones para que devuelva el camino mas largo, no solo la primera ocurrencia, el resultado es una lista con los numeros enteros
    private BinaryTree<Integer> arbol;

    public ParcialArboles3(BinaryTree<Integer> ab){
        arbol = ab;

    }
    private LinkedList<Integer> ejercicioPrivate(BinaryTree<Integer> arbol ,LinkedList<Integer> camino, LinkedList<Integer> listaModificable){  // agregar parametro Integer maximo
    
    	if(!arbol.isLeaf() && camino == null){  //quitar comparacion con null para poder seguir recorriendo
            int valorActual = arbol.getData();
            if(arbol.hasLeftChild()){
                int valorHijo = arbol.getLeftChild().getData();
                if(((valorHijo >= 0) && (valorActual < 0)) || ((valorActual >= 0) && (valorHijo < 0))){
                    listaModificable.add(valorHijo);
                    camino = ejercicioPrivate(arbol.getLeftChild(), camino, listaModificable); // agregar parametro maximo
                    listaModificable.removeFirstOccurrence(valorHijo);
                }
            }
            if(arbol.hasRightChild() && camino == null){  //quitar comparacion con null para poder seguir recorriendo
                int valorHijo = arbol.getRightChild().getData();
                if(((valorHijo >= 0) && (valorActual < 0)) || ((valorActual >= 0) && (valorHijo < 0))){
                    listaModificable.add(valorHijo);
                    camino = ejercicioPrivate(arbol.getRightChild(), camino, listaModificable); // agregar parametro maximo
                    listaModificable.removeFirstOccurrence(valorHijo);
                }
            }
        
        }else if(camino == null){     
            camino = new LinkedList<>();
            camino.addAll(listaModificable);
          //  maximo = camino.size();      
            
        } //else if((camino.size() > maximo)){
            //    maximo = camino.size();         este pedazo de codigo modifica el camino si encuentra otro camino mas con un tamaño superior al ya establecido
            //    camino.clear();
            //    camino.addAll(listaModificable);            
        //}
          return camino;
    }

    public LinkedList<Integer> ejercicio(){
        
        LinkedList<Integer> lista = null;
        LinkedList<Integer> listaModificable = null;
        if (!arbol.isEmpty()){
                // definir variable Integer maximo
                listaModificable = new LinkedList<>();
                listaModificable.add(arbol.getData());
                lista = ejercicioPrivate(arbol,lista, listaModificable);        // agregar parametro maximo     
        }
        
        return lista;
    }
}
