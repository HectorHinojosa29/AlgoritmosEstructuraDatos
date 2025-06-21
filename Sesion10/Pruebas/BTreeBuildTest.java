package Pruebas;

import Exceptions.ItemNotFound;
import btree.BTree;

public class BTreeBuildTest {
    public static void main(String[] args) {
        try {
            String filename = "src/btree/btree_input.txt";
            BTree<Integer> arbol = BTree.building_BTree(filename);

            System.out.println("Árbol B construido desde el archivo:");
            System.out.println(arbol);
            
            System.out.println("Buscando 20: " + arbol.search(20));
            System.out.println("Buscando 90: " + arbol.search(90));
            System.out.println("Buscando 100 (que no existe): " + arbol.search(100));

            System.out.println("Eliminando 30...");
            arbol.remove(30);
            System.out.println(arbol);

        } catch (ItemNotFound e) {
            System.out.println("Error al construir el árbol: " + e.getMessage());
        }
    }
}
