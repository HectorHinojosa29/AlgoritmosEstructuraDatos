package Actividades_Ejercicios;

import Exceptions.ItemDuplicated;

import Exceptions.ItemNotFound;
import Exceptions.ExceptionIsEmpty;;

public class Prueba {
    public static void main(String[] args) throws ExceptionIsEmpty {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();
            LinkedBST<Integer> bst2 = new LinkedBST<>();
            
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            
            bst2.insert(100);
            bst2.insert(50);
            bst2.insert(150);

            System.out.println("InOrder: " + bst.inOrder());
            System.out.println("PreOrder: " + bst.preOrder());
            System.out.println("PostOrder: " + bst.postOrder());
            
            System.out.println("Buscar 30: " + bst.search(30));
            
            System.out.println("Mínimo: " + bst.findMin());
            System.out.println("Máximo: " + bst.findMax());
            
            //Prueba de nuevos métodos
            System.out.println("Cantidad de nodos: " + bst.countAllNodes());
            System.out.println("Cantidad de nodos no-hoja: " + bst.countNodes());
            System.out.println("Altura del subárbol con raíz 30: " + bst.height(30));
            System.out.println("Amplitud del nivel 1: " + bst.amplitude(1));
            System.out.println("Área del árbol: " + bst.areaBST());
            bst.drawBST();
            System.out.println("Representación con paréntesis:");
            bst.parenthesize();
            
            System.out.println("¿Los árboles tienen la misma área? " + sameArea(bst, bst2));
            
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public static boolean sameArea(LinkedBST<?> tree1, LinkedBST<?> tree2) throws ItemNotFound {
        return tree1.areaBST() == tree2.areaBST();
    }
}