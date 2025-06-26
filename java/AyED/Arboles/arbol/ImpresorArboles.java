package arbol;

public class ImpresorArboles {

   
    public ImpresorArboles() {
    	
    }
    public void imprimoInOrden(BinaryTree<?> arbol){
    	if (arbol!=null) {
    		if (arbol.hasLeftChild()) {
    			imprimoInOrden(arbol.getLeftChild());
    		}
    		System.out.println(arbol.getData());
    		if(arbol.hasRightChild()) {
    			imprimoInOrden(arbol.getRightChild());
    		}
    	}
    }
    public void imprimoPreOrden(BinaryTree<?> arbol){
    	System.out.println(arbol.getData());
    	if (arbol!=null) {
    		if (arbol.hasLeftChild()) {
    			imprimoPreOrden(arbol.getLeftChild());
    		}
    		if(arbol.hasRightChild()) {
    			imprimoPreOrden(arbol.getRightChild());
    		}
    	}
    }
}

