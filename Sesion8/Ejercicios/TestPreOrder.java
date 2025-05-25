package Ejercicios;

import Actividad.AVLTree;

public class TestPreOrder {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] keys = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        
        System.out.println("Inserción en AVL:");
        for (int key : keys) {
            avl.insert(key);
            System.out.print("PreOrden después de insertar " + key + ": ");
            avl.preOrder();
        }
    }
}