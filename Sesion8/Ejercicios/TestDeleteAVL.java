package Ejercicios;

import Actividad.AVLTree;

public class TestDeleteAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] keys = {30, 20, 40, 10, 25, 35, 50};
        
        System.out.println("Inserción inicial:");
        for (int key : keys) {
            avl.insert(key);
            System.out.println("Insertado: " + key + " | Altura: " + avl.height());
        }
        
        System.out.print("PreOrden antes de eliminar: ");
        avl.preOrder();
        
        // Eliminar nodos y mostrar efectos
        System.out.println("\nEliminando 25 (hoja):");
        avl.delete(25);
        avl.preOrder();
        
        System.out.println("\nEliminando 20 (un hijo):");
        avl.delete(20);
        avl.preOrder();
        
        System.out.println("\nEliminando 30 (dos hijos):");
        avl.delete(30);
        
        System.out.print("PreOrden despues de eliminar: ");
        avl.preOrder();
    }
}