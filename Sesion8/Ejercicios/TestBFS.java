package Ejercicios;

import Actividad.AVLTree;

public class TestBFS {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] keys = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        
        for (int key : keys) {
            avl.insert(key);
        }
        
        System.out.println("Recorrido por amplitud (BFS) iterativo:");
        avl.breadthFirstTraversal();
        
        System.out.println("\nRecorrido por amplitud (BFS) recursivo:");
        avl.breadthFirstRecursive();
    }
}