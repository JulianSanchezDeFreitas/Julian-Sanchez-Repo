package parcialesArbolesBin;

import java.util.LinkedList;

public class Test3 {

    public static void main(String[] args) {
        
        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(-2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(-3);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(-2);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(-1);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(-3);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(-8);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(-8);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(-3);
        BinaryTree<Integer> nodo12 = new BinaryTree<>(-1);
        BinaryTree<Integer> nodo13 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo14 = new BinaryTree<>(-4);

        nodo1.addLeftChild(nodo2);
        nodo2.addLeftChild(nodo3);
        nodo3.addLeftChild(nodo4);
        nodo4.addLeftChild(nodo5);
        nodo5.addLeftChild(nodo6);
        nodo4.addRightChild(nodo7);
        nodo3.addRightChild(nodo8);
        nodo8.addRightChild(nodo9);
        nodo2.addRightChild(nodo10);
        nodo1.addRightChild(nodo11);
        nodo11.addLeftChild(nodo12);
        nodo11.addRightChild(nodo13);
        nodo13.addRightChild(nodo14);

        ParcialArboles3 test = new ParcialArboles3(nodo1);
        LinkedList<Integer> retorno= test.ejercicio();
        //ImpresorArboles i = new ImpresorArboles();
        //i.imprimoPreOrden(nodo1);
        System.out.println("retorno");
        
        System.out.println(retorno);

    }


    
}
