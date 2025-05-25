package Actividad;

public class TestAVL {
    public static void main(String[] args) {
        // Caso 1 - RSR
    	System.out.println("Caso 1 - RSR:");
        AVLTree<Integer> avl1 = new AVLTree<>();
        int[] keys1 = {30, 20, 10};
        for (int key1 : keys1) {
            avl1.insert(key1);
            System.out.println("Insertado: " + key1 );
        }
        System.out.print("PreOrden: ");
        avl1.preOrder();
        System.out.println(" ");
        
        // Caso 2 - RSL
        System.out.println("Caso 2 - RSL:");
        AVLTree<Integer> avl2 = new AVLTree<>();
        int[] keys2 = {10, 20, 30};
        for (int key2 : keys2) {
            avl2.insert(key2);
            System.out.println("Insertado: " + key2 );
        }
        System.out.print("PreOrden: ");
        avl2.preOrder();
        System.out.println(" ");
        
        // Caso 3 - RDR
        System.out.println("Caso 3 - RDR:");
        AVLTree<Integer> avl3 = new AVLTree<>();
        int[] keys3 = {10, 30, 20};
        for (int key3 : keys3) {
            avl3.insert(key3);
            System.out.println("Insertado: " + key3);
        }
        System.out.print("PreOrden: ");
        avl3.preOrder();
        System.out.println(" ");
        
        // Caso 4 - RDL
        System.out.println("Caso 4 - RDL:");
        AVLTree<Integer> avl4 = new AVLTree<>();
        int[] keys4 = {30, 10, 20};
        for (int key4 : keys4) {
            avl4.insert(key4);
            System.out.println("Insertado: " + key4);
        }
        System.out.print("PreOrden: ");
        avl4.preOrder();
        System.out.println(" ");

        // Caso 5 - RSR
        System.out.println("Caso 5 - RSR:");
        AVLTree<Integer> avl5 = new AVLTree<>();
        int[] keys5 = {30, 10, 20};
        for (int key5 : keys5) {
            avl5.insert(key5);
            System.out.println("Insertado: " + key5);
        }
        System.out.print("PreOrden: ");
        avl5.preOrder();
        System.out.println(" ");

        // Caso 6 - RSL
        System.out.println("Caso 6 - RSL:");
        AVLTree<Integer> avl6 = new AVLTree<>();
        int[] keys6 = {10, 20, 30, 50};
        for (int key6 : keys6) {
            avl6.insert(key6);
            System.out.println("Insertado: " + key6);
        }
        System.out.print("PreOrden: ");
        avl6.preOrder();
        System.out.println(" ");
        
        // Caso 7 - RDR
        System.out.println("Caso 7 - RDR:");
        AVLTree<Integer> avl7 = new AVLTree<>();
        int[] keys7 = {10, 40, 20, 30};
        for (int key7 : keys7) {
            avl7.insert(key7);
            System.out.println("Insertado: " + key7);
        }
        System.out.print("PreOrden: ");
        avl7.preOrder();
        System.out.println(" ");
        
        // Caso 8 - RDL
        System.out.println("Caso 8 - RDL:");
        AVLTree<Integer> avl8 = new AVLTree<>();
        int[] keys8 = {50, 20, 40, 30};
        for (int key8 : keys8) {
            avl8.insert(key8);
            System.out.println("Insertado: " + key8);
        }
        System.out.print("PreOrden: ");
        avl8.preOrder();
    }
}
