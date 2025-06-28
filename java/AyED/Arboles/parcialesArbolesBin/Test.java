package parcialesArbolesBin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(2);
		BinaryTree<Integer> rama1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> rama2 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> hoja1 = new BinaryTree<Integer>(23);
		BinaryTree<Integer> hoja2 = new BinaryTree<Integer>(19);
		BinaryTree<Integer> hoja3 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> hoja4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hoja5 = new BinaryTree<Integer>(-3);
		BinaryTree<Integer> hoja6 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> hoja7 = new BinaryTree<Integer>(55);
		BinaryTree<Integer> hoja9 = new BinaryTree<Integer>(18);
		raiz.addLeftChild(rama1);
		raiz.addRightChild(rama2);
		rama1.addLeftChild(hoja1);
		rama1.addRightChild(hoja3);
		rama2.addLeftChild(hoja2);
		hoja1.addLeftChild(hoja5);
		hoja3.addLeftChild(hoja7);
		hoja3.addRightChild(hoja6);
		hoja2.addRightChild(hoja4);
		hoja4.addLeftChild(hoja9);
		
		ParcialArboles test = new ParcialArboles(raiz);
		if (test.isLeftTree(-3)) {
			System.out.print("Si");
		}else {
			System.out.print("no");
		}
		
	}

}
