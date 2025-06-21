package Pruebas;

import btree.BTree;

public class BTreeSearchTest {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4);

        int[] valores = {50, 20, 70, 10, 30, 60, 80, 25, 27, 26, 90, 5, 15};
        for (int valor : valores) {
            btree.insert(valor);
        }

        System.out.println("Árbol B después de las inserciones:");
        System.out.println(btree);

        System.out.println("---------------------------------------------------");
        
        int[] clavesExistentes = {10, 20, 26, 50, 90};
        for (int clave : clavesExistentes) {
            System.out.println("Buscando " + clave + "...");
            boolean encontrado = btree.search(clave);
            if (encontrado) {
                System.out.println("La clave " + clave + " fue encontrada.\n");
            } else {
                System.out.println("La clave " + clave + " NO fue encontrada.\n");
            }
        }

        System.out.println("---------------------------------------------------");

        int[] clavesNoExistentes = {100, 0, 35, 65};
        for (int clave : clavesNoExistentes) {
            System.out.println("Buscando " + clave + "...");
            boolean encontrado = btree.search(clave);
            if (encontrado) {
                System.out.println("La clave " + clave + " fue encontrada (esto no debería pasar).\n");
            } else {
                System.out.println("La clave " + clave + " NO fue encontrada (correcto).\n");
            }
        }
    }
}
