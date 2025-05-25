package Actividad; 

// Nodo genérico para estructuras de datos (árboles, listas)
public class Node<E> {
    private E data;         // Dato almacenado en el nodo
    protected Node<E> left; // Hijo izquierdo (accesible por subclases)
    protected Node<E> right;// Hijo derecho (accesible por subclases)

    // Constructor: crea nodo con dato y sin hijos
    public Node(E data) {
        this.setData(data); // Asigna valor al nodo
        this.left = null;  // Inicializa hijo izquierdo vacío
        this.right = null; // Inicializa hijo derecho vacío
    }

    // Representación textual del nodo (devuelve el dato como String)
    public String toString() {
        return getData().toString();
    }

    // Getter del dato
    public E getData() {
        return data;
    }

    // Setter del dato
    public void setData(E data) {
        this.data = data;
    }
}