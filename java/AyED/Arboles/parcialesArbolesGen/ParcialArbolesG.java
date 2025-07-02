package parcialesArbolesGen;

import arbolesGenerales.GeneralTree;

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
}
