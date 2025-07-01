package arbolesGenerales;

public class TestNivelAltura {
    
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(10);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(11);

        nodo1.addChild(nodo2);
        nodo1.addChild(nodo3);
        nodo1.addChild(nodo4);
        nodo2.addChild(nodo5);
        nodo2.addChild(nodo6);
        nodo3.addChild(nodo7);
        nodo4.addChild(nodo8);
        nodo4.addChild(nodo9);
        nodo4.addChild(nodo10);
        nodo7.addChild(nodo11);

        System.out.println("retorno nivel de");
        System.out.println(nodo1.nivel(45));
        
    }
}
