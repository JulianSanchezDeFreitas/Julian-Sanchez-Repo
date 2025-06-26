package parcialesArboles;


import arbol.BinaryTree;

public class ParcialArboles {
	private  BinaryTree<Integer> arbol;
	
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> busqueda(BinaryTree<Integer> ab, int num){
		BinaryTree<Integer> ret = null;
		if(ab != null) {
		if (ab.getData() == num){
			return ab;
		}else{
			if (ab.hasLeftChild()){
				ret = busqueda(ab.getLeftChild(), num);
				} 
			if (ret == null){
				if (ab.hasRightChild()){
					ret = busqueda(ab.getRightChild(), num);
				}
			}
			} 
		}
		return ret;
		}
	private int contadorHijos(BinaryTree<Integer> ab){
		int c = 0;
		if ((ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild())){
			if (ab.hasLeftChild()){
				c += contadorHijos(ab.getLeftChild()) + 1;
		
			}else {
			c += contadorHijos(ab.getRightChild()) + 1;
			}
		}else {
			if (ab.hasLeftChild()){
				c += contadorHijos(ab.getLeftChild());
			}	
			if (ab.hasRightChild()){
				c += contadorHijos(ab.getRightChild());
			}
			
		}
		return c;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> ab = busqueda(arbol, num);
		boolean isLeftTree;
		if ((ab == null) || (!ab.hasLeftChild())){
			isLeftTree = false;
		}else{
			int CHI = 0;
			int CHD = 0;
			CHI = contadorHijos(ab.getLeftChild());
			if (ab.hasRightChild()){
				CHD = contadorHijos(ab.getRightChild());
			}
			System.out.print(CHI);
			System.out.print(CHD);
			isLeftTree = CHI > CHD;
		}
		
		return isLeftTree;
	}
}
