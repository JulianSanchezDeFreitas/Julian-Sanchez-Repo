package parcialesArbolesGen;

import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;
import parcialesArbolesBin.BinaryTree;

public class ParcialArbolesG {
    private static boolean esDeSelccionPrivate(GeneralTree<Integer> arbol, boolean esValido){
        Integer min = 1000;
        if (!arbol.isLeaf() && esValido){
            for (GeneralTree<Integer> child : arbol.getChildren() ){
                if (child.getData() < min){
                    min = child.getData();
                }
                esValido = esDeSelccionPrivate(child, esValido);
            }
            if (min != arbol.getData()){
                esValido = false;
            }
                
        }
        System.out.println(esValido);
        return esValido;
    }

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){

        boolean esDeSeleccion = true;
        if (arbol != null && !arbol.isLeaf()){
            esDeSeleccion = esDeSelccionPrivate(arbol, esDeSeleccion);
        }else{
            esDeSeleccion = false;
        }
        return esDeSeleccion;
    }
    public static List<Integer> resolverPrivate(GeneralTree<Integer> arbol, List<Integer> caminoMaximo, List<Integer> caminoActual ,int nivel){
        caminoActual.add(arbol.getData());
        nivel++;
        if (arbol.isLeaf()){
            int suma = 0;
            int max = 0;
            for(int i = 0; i < caminoActual.size(); i++){
                suma += caminoActual.get(i) * i ;
            }
            for(int i = 0; i < caminoMaximo.size(); i++){
                max += caminoMaximo.get(i) * i ;
            }
            if(suma > max){
                caminoMaximo.clear();
                caminoMaximo.addAll(caminoActual);
                return caminoMaximo;
            }
        }else{
            for(GeneralTree<Integer> child : arbol.getChildren()){
                caminoMaximo = resolverPrivate(child, caminoMaximo, caminoActual, nivel);
                caminoActual.remove(caminoActual.size()-1);
            }
        }
        nivel--;

        return caminoMaximo;
    }
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List<Integer> caminoMaximo = null;
        if(arbol != null && !arbol.isEmpty()){
            int nivel = -1;
            caminoMaximo = new LinkedList<>();
            List<Integer> caminoActual = new LinkedList<>();
            caminoMaximo = resolverPrivate(arbol, caminoMaximo ,caminoActual, nivel);
        }
        return caminoMaximo;
    }

    public BinaryTree<Integer> proceso (BinaryTree<Integer> arbol){
        int nietos = 0;
        if (!arbol.isLeaf()){
            if (arbol.hasLeftChild()){
                if(!arbol.getLeftChild().isLeaf()){
                    if(arbol.getLeftChild().hasLeftChild()){
                        nietos++;
                    }
                    if(arbol.getLeftChild().hasRightChild()){
                        nietos++;
                    }
                }
            }
            if (arbol.hasRightChild()){
                if(!arbol.getRightChild().isLeaf()){
                    if(arbol.getRightChild().hasLeftChild()){
                        nietos++;
                    }
                    if(arbol.getRightChild().hasRightChild()){
                        nietos++;
                    }
                }
        }   
        BinaryTree<Integer> an = new BinaryTree<>(nietos);
        an.addLeftChild(proceso(arbol.getLeftChild()));
        an.addRightChild(proceso(arbol.getRightChild()));
        return an;
    }else{  
        BinaryTree<Integer> an = new BinaryTree<>(0);
        return an;
    }
}
    public BinaryTree<Integer> resolver ( BinaryTree<Integer> arbol){
        BinaryTree<Integer> retorno = null;
        if (arbol != null){
            if (arbol.isEmpty()){
                retorno = new BinaryTree<>(-1);

            }
            else{
                retorno = proceso(arbol);
            }
        }
        return retorno;
    }
}
