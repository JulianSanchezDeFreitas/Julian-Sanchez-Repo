package parcialesArboles;

import java.util.ArrayList;

import arbol.BinaryTree;
import arbol.ImpresorArboles;

public class Test2 {

	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(20);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> nodo6 = new BinaryTree<Integer>(-9);
		BinaryTree<Integer> nodo7 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(6);
		ParcialArboles2 test = new ParcialArboles2();
		raiz.addLeftChild(nodo1);
		raiz.addRightChild(nodo2);
		nodo1.addLeftChild(nodo3);
		nodo1.addRightChild(nodo4);
		nodo2.addLeftChild(nodo5);
		nodo2.addRightChild(nodo6);
		nodo4.addLeftChild(nodo7);
		nodo5.addRightChild(nodo8);
		nodo8.addRightChild(nodo9);
		
		BinaryTree<ArrayList<Integer>> an = test.sumAndDif(raiz);
		ImpresorArboles i = new ImpresorArboles();
		i.imprimoPreOrden(an);
	}

}
