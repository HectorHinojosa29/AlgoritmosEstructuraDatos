package Pruebas;

import btree.BNode;
import btree.BTree;

public class BTreeTest {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4);

        int[] valores = {50, 20, 70, 10, 30, 60, 80, 25, 27, 26, 90, 5, 15};

        for (int valor : valores) {
            System.out.println("Insertando: " + valor);
            btree.insert(valor);
            System.out.println(btree);
            System.out.println("---------------------------------------------------");
        }

        System.out.println("Insertando duplicado 30:");
        btree.insert(30);

        if (!btree.isEmpty()) {
            BNode<Integer> root = btree.root;
            int[] pos = new int[1];
            boolean encontrado = root.searchNode(20, pos);
            if (encontrado) {
                System.out.println("Clave 20 encontrada en el nodo raíz en la posición: " + pos[0]);
            } else {
                System.out.println("Clave 20 no encontrada en el nodo raíz.");
            }
        }

        System.out.println("Árbol B completo:");
        System.out.println(btree);
    }
}

