package parcialesArbolesBin;

import java.util.ArrayList;

public class ParcialArboles2 {
	
	public ParcialArboles2() {
		
	}

	private BinaryTree<ArrayList<Integer>> SD(ArrayList<Integer> datos, BinaryTree<Integer> arbol, Integer valorPadre){
		ArrayList<Integer> datosN = new ArrayList<Integer>();
		Integer valorActual = arbol.getData();
		Integer dif = valorActual - valorPadre ;
		Integer sum = datos.getFirst() + arbol.getData();
		datosN.add(sum);
		datosN.add(dif);
		BinaryTree<ArrayList<Integer>> an = new BinaryTree<>(datosN);
		if (arbol.hasLeftChild()) {
			an.addLeftChild(SD(datosN,arbol.getLeftChild(), valorActual));				
		}
		if (arbol.hasRightChild()) {
			an.addRightChild(SD(datosN,arbol.getRightChild(), valorActual));
		}
	
		return an;
	}
	
	public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<ArrayList<Integer>> an = null;
		if (!arbol.isEmpty()) {
			Integer sum = arbol.getData();
			Integer dif = arbol.getData();
			ArrayList<Integer> datos = new ArrayList<Integer>();
			datos.add(sum);
			datos.add(dif);
			an = new BinaryTree<>(datos);
			if (arbol.hasLeftChild()) {
				an.addLeftChild(SD(datos,arbol.getLeftChild(), arbol.getData()));				
			}
			if (arbol.hasRightChild()) {
				an.addRightChild(SD(datos,arbol.getRightChild(),arbol.getData()));
			}
			
		}
		return an;
	}
}
