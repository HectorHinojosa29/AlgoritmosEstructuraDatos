package Actividad;

import java.util.LinkedList;
import java.util.Queue;

// Árbol Binario de Búsqueda (BST) genérico con elementos comparables
public class BSTree<E extends Comparable<E>> {
    private NodeAVL<E> root;  // Raíz del árbol (usa nodos AVL pero sin balanceo automático)

    // ---- Inserción ----
    public void insert(E data) {
        setRoot(insert(getRoot(), data));  // Inserta recursivamente y actualiza raíz
    }

    protected NodeAVL<E> insert(NodeAVL<E> node, E data) {
        if (node == null) {
            return new NodeAVL<>(data);  // Crea nuevo nodo si llegamos a nulo
        }

        int cmp = data.compareTo(node.getData());
        if (cmp < 0) {
            node.left = insert((NodeAVL<E>) node.left, data);  // Inserta en subárbol izquierdo
        } else if (cmp > 0) {
            node.right = insert((NodeAVL<E>) node.right, data);  // Inserta en subárbol derecho
        }
        // Si cmp == 0, no hace nada (evita duplicados)
        return node;
    }

    // ---- Búsqueda ----
    public NodeAVL<E> search(E data) {
        return search(getRoot(), data);  // Búsqueda desde la raíz
    }

    private NodeAVL<E> search(NodeAVL<E> node, E data) {
        if (node == null) return null;  // No encontrado

        int cmp = data.compareTo(node.getData());
        if (cmp == 0) return node;  // Encontrado
        return cmp < 0 
            ? search((NodeAVL<E>) node.left, data)  // Busca en izquierda
            : search((NodeAVL<E>) node.right, data);  // Busca en derecha
    }

    // ---- Ejercicio 1: Altura ----
    public int height() {
        return height(getRoot());  // Altura desde raíz
    }

    private int height(NodeAVL<E> node) {
        if (node == null) return -1;  // Convención: árbol vacío = -1
        return 1 + Math.max(
            height((NodeAVL<E>) node.left),  // Altura izquierda
            height((NodeAVL<E>) node.right)  // Altura derecha
        );
    }

    // ---- Ejercicio 5: Recorrido PreOrden ----
    public void preOrder() {
        preOrder(getRoot());
        System.out.println();  // Salto de línea al final
    }
    
    private void preOrder(NodeAVL<E> node) {
        if (node != null) {
            System.out.print(node + " ");  // Visita raíz
            preOrder((NodeAVL<E>) node.left);  // Recorre izquierda
            preOrder((NodeAVL<E>) node.right);  // Recorre derecha
        }
    }
    
    // ---- Ejercicios 3-4: Recorrido por Niveles ----
    public void breadthFirstTraversal() {
        if (getRoot() == null) return;
        
        Queue<NodeAVL<E>> queue = new LinkedList<>();
        queue.add(getRoot());  // Encola la raíz
        
        while (!queue.isEmpty()) {
            NodeAVL<E> current = queue.poll();  // Desencola
            System.out.print(current.getData() + " ");  // Procesa
            
            if (current.left != null) queue.add((NodeAVL<E>) current.left);  // Encola hijo izquierdo
            if (current.right != null) queue.add((NodeAVL<E>) current.right);  // Encola hijo derecho
        }
        System.out.println();
    }

    // Versión recursiva (para propósitos educativos)
    public void breadthFirstRecursive() {
        for (int i = 0; i <= height(); i++) {
            printLevel(getRoot(), i);  // Imprime cada nivel
        }
        System.out.println();
    }

    private void printLevel(NodeAVL<E> node, int level) {
        if (node == null) return;
        if (level == 0) {
            System.out.print(node.getData() + " ");  // Nodo del nivel actual
        } else {
            printLevel((NodeAVL<E>) node.left, level - 1);  // Baja al siguiente nivel izquierdo
            printLevel((NodeAVL<E>) node.right, level - 1);  // Baja al siguiente nivel derecho
        }
    }

    // ---- Getters/Setters (Ejercicio 6) ----
    public NodeAVL<E> getRoot() {
        return root;
    }

    public void setRoot(NodeAVL<E> root) {
        this.root = root;
    }
}