package parcialesArbolesGen;

import java.util.List;

import arbolesGenerales.GeneralTree;

public class TestParcial2 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo15 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo16 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo17 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo18 = new GeneralTree<>(1);

        nodo1.addChild(nodo2);
        nodo1.addChild(nodo3);
        nodo1.addChild(nodo4);
        nodo2.addChild(nodo5);
        nodo2.addChild(nodo6);
        nodo3.addChild(nodo7);
        nodo3.addChild(nodo8);
        nodo4.addChild(nodo9);
        nodo5.addChild(nodo10);
        nodo5.addChild(nodo11);
        nodo5.addChild(nodo12);
        nodo8.addChild(nodo13);
        nodo9.addChild(nodo14);
        nodo13.addChild(nodo15);
        nodo14.addChild(nodo16);
        nodo14.addChild(nodo17);
        nodo15.addChild(nodo18);
        List<Integer> retorno = ParcialArbolesG.resolver(nodo1);
        System.out.println("retorno");    
        System.out.println(retorno);    
    }
}
