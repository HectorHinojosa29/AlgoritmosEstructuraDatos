package Ejercicios;

import Actividad.AVLTree;
import Actividad.BSTree;

public class TestComparacionBSTvsAVL {
    public static void main(String[] args) {
    	//CASO 1
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        int[] datos = {10, 20, 30, 40, 50, 60}; 

        for (int dato : datos) {
            bst.insert(dato);
            avl.insert(dato);
        }

        System.out.println("Altura BST: " + bst.height());
        System.out.println("Altura AVL: " + avl.height());

        System.out.println("Buscar 50 en BST: " + (bst.search(50) != null));
        System.out.println("Buscar 50 en AVL: " + (avl.search(50) != null));
        
        
        BSTree<Integer> bst1 = new BSTree<>();
        AVLTree<Integer> avl1 = new AVLTree<>();

        int[] datos1 = {1, 25, 75, 125, 50, 200}; 

        for (int dato : datos1) {
            bst1.insert(dato);
            avl1.insert(dato);
        }

        System.out.println("Altura BST: " + bst1.height());
        System.out.println("Altura AVL: " + avl1.height());

        System.out.println("Buscar 50 en BST: " + (bst1.search(75) != null));
        System.out.println("Buscar 50 en AVL: " + (avl1.search(75) != null));
    }
}
