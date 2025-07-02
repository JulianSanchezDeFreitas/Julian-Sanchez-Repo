package parcialesArbolesGen;

import arbolesGenerales.GeneralTree;

public class TestParcialArboles {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(25);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(35);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(35);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(14);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(33);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(35);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(35);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(83);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(90);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(33);
        GeneralTree<Integer> nodo15 = new GeneralTree<>(25);

        nodo1.addChild(nodo2);
        nodo1.addChild(nodo3);
        nodo2.addChild(nodo4);
        nodo2.addChild(nodo5);
        nodo4.addChild(nodo6);
        nodo6.addChild(nodo10);
        nodo5.addChild(nodo7);
        nodo5.addChild(nodo8);
        nodo5.addChild(nodo9);
        nodo9.addChild(nodo11);
        nodo9.addChild(nodo12);
        nodo9.addChild(nodo13);
        nodo9.addChild(nodo14);
        nodo3.addChild(nodo15);

        boolean retorno = ParcialArbolesG.esDeSeleccion(nodo1);
        System.out.println("retorno");
        System.out.println(retorno);
    }
}
