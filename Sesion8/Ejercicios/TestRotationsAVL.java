package Ejercicios;

import Actividad.AVLTree;

public class TestRotationsAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        System.out.println("Operación | Valor | Rotación | Raíz después");
        System.out.println("------------------------------------------");
        
        avl.insert(30);
        System.out.println("Insertar  | 30    | Ninguna  | " + (avl.getRoot() != null ? avl.getRoot().getData() : "null"));
        
        avl.insert(20);
        System.out.println("Insertar  | 20    | Ninguna  | " + avl.getRoot().getData());
        
        avl.insert(10); 
        System.out.println("Insertar  | 10    | RSR      | " + avl.getRoot().getData());
        
        avl.insert(40);
        avl.insert(50);  
        System.out.println("Insertar  | 50    | RSL      | " + avl.getRoot().getData());
        
        avl.delete(20);  
        System.out.println("Eliminar  | 20    | RDL      | " + avl.getRoot().getData());
    }
}
