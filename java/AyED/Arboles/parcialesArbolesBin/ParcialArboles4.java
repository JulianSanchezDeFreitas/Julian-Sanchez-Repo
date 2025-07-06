package parcialesArbolesBin;

public class ParcialArboles4 {
        public ParcialArboles4(){

        }

        public BinaryTree<Integer> proceso (BinaryTree<Integer> arbol){
        int nietos = 0;
        System.out.println(arbol.getData());
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
        if (arbol.hasLeftChild()){
            an.addLeftChild(proceso(arbol.getLeftChild()));

        }
        if (arbol.hasRightChild()){
            an.addRightChild(proceso(arbol.getRightChild()));

        }
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
