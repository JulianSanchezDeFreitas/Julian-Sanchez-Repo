package parcialesArbolesBin;

public class TestParcial4 {
    public static void main(String[] args) {
        ParcialArboles4 test = new ParcialArboles4();

        BinaryTree<Integer> nodo1 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(12);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(13);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(-3);


        nodo1.addLeftChild(nodo2);
        nodo1.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo3.addRightChild(nodo5);
        nodo4.addLeftChild(nodo6);
        nodo4.addRightChild(nodo7);
        nodo5.addRightChild(nodo8);


        ImpresorArboles i = new ImpresorArboles();
        //System.out.println("arbol 1");
        //i.imprimoPreOrden(nodo1);
        BinaryTree<Integer> resultado = test.resolver(nodo1);
        System.out.println("retrono");
        i.imprimoPreOrden(resultado);
    }
}
