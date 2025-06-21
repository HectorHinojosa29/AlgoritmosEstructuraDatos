package Pruebas;

import btree.BTree;

public class BTreeRemoveTest {
    public static void main(String[] args) {

        BTree<Integer> btree = new BTree<>(4);


        int[] valores = {50, 20, 70, 10, 30, 60, 80, 25, 27, 26, 90, 5, 15, 35, 45, 55, 65, 75, 85, 95};
        for (int valor : valores) {
            btree.insert(valor);
        }


        System.out.println("Árbol B después de las inserciones iniciales:");
        System.out.println(btree);
        System.out.println("---------------------------------------------------");




        eliminarYMostrar(btree, 5);
        eliminarYMostrar(btree, 15);
        eliminarYMostrar(btree, 30);
        eliminarYMostrar(btree, 50);
        eliminarYMostrar(btree, 55);
        eliminarYMostrar(btree, 70);
        eliminarYMostrar(btree, 100);
        eliminarYMostrar(btree, 20);
        eliminarYMostrar(btree, 25);
        eliminarYMostrar(btree, 26);
        eliminarYMostrar(btree, 27);
        eliminarYMostrar(btree, 35);
        eliminarYMostrar(btree, 45);
        eliminarYMostrar(btree, 60);
        eliminarYMostrar(btree, 65);
        eliminarYMostrar(btree, 75);
        eliminarYMostrar(btree, 80);
        eliminarYMostrar(btree, 85);
        eliminarYMostrar(btree, 90);
        eliminarYMostrar(btree, 95);

    }

    private static void eliminarYMostrar(BTree<Integer> btree, int clave) {
        System.out.println("Eliminando clave: " + clave);
        btree.remove(clave);
        System.out.println(btree);
        System.out.println("---------------------------------------------------");
    }
}
