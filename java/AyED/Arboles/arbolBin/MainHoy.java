package arbolBin;

import parcialesArbolesBin.BinaryTree;
import parcialesArbolesBin.ImpresorArboles;

public class MainHoy {

	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(4);
		BinaryTree<Integer> rama1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> rama2 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> hoja1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> hoja2 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> hoja3 = new BinaryTree<Integer>(9);
		BinaryTree<Integer> hoja4 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> hoja5 = new BinaryTree<Integer>();
		BinaryTree<Integer> espejo;
		raiz.addLeftChild(rama1);
		raiz.addRightChild(rama2);
		rama1.addLeftChild(hoja1);
		rama1.addRightChild(hoja3);
		rama2.addLeftChild(hoja2);
		rama2.addRightChild(hoja4);
		
		ImpresorArboles impresor = new ImpresorArboles();
		
		//System.out.println(raiz.contarHojas());
		//System.out.println(rama2.contarHojas());
		//System.out.println(hoja3.contarHojas());
		//System.out.println(hoja5.contarHojas());
		
		//impresor.imprimoInOrden(raiz);
		
		//espejo = raiz.espejo();
		//impresor.imprimoInOrden(espejo);
		raiz.entreNiveles(1, 2);
		//System.out.println(hoja5.toString());

		
	}

}
