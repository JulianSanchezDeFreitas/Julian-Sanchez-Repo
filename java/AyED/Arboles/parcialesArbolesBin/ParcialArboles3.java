package parcialesArbolesBin;

import java.util.LinkedList;

public class ParcialArboles3 {

    private BinaryTree<Integer> arbol;

    public ParcialArboles3(BinaryTree<Integer> ab){
        arbol = ab;

    }
    private LinkedList<Integer> ejercicioPrivate(BinaryTree<Integer> arbol ,LinkedList<Integer> camino, LinkedList<Integer> listaModificable){ 
    	
    	if(!arbol.isLeaf() && camino == null){
            int valorActual = arbol.getData();
            if(arbol.hasLeftChild()){
                int valorHijo = arbol.getLeftChild().getData();
                if(((valorHijo >= 0) && (valorActual < 0)) || ((valorActual >= 0) && (valorHijo < 0))){
                    listaModificable.add(valorHijo);
                    camino = ejercicioPrivate(arbol.getLeftChild(), camino, listaModificable);
                    listaModificable.removeFirstOccurrence(valorHijo);
                }
            }
            if(arbol.hasRightChild() && camino == null){
                int valorHijo = arbol.getRightChild().getData();
                if(((valorHijo >= 0) && (valorActual < 0)) || ((valorActual >= 0) && (valorHijo < 0))){
                    listaModificable.add(valorHijo);
                    camino = ejercicioPrivate(arbol.getRightChild(), camino, listaModificable);
                    listaModificable.removeFirstOccurrence(valorHijo);
                }
            }
        
        }else if(camino == null){
        	camino = new LinkedList<>();
            camino.addAll(listaModificable);
        } 
          return camino;
    }

    public LinkedList<Integer> ejercicio(){
        
        LinkedList<Integer> lista = null;
        LinkedList<Integer> listaModificable = null;
        if (!arbol.isEmpty()){
                listaModificable = new LinkedList<>();
                listaModificable.add(arbol.getData());
                lista = ejercicioPrivate(arbol,lista, listaModificable);            
        }
        
        return lista;
    }
}
