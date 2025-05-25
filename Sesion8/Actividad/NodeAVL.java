package Actividad; 

// Nodo especializado para árboles AVL (extiende de Node<E>)
public class NodeAVL<E> extends Node<E> {
    protected int bf;  // Factor de balance (altura subárbol izq - der)

    // Constructor: crea nodo AVL con dato y factor de balance 0
    public NodeAVL(E data) {
        super(data);  // Llama al constructor de la clase padre (Node)
        this.bf = 0;  // Inicializa factor de balance en 0 (equilibrado)
    }

    // Representación textual del nodo (dato + espacio)
    @Override
    public String toString() {
        return getData() + " ";  // Ejemplo: "5 " 
    }
}