package ActividadEjercicios;

public class Node<T> { //CLASE NODO
    T dato;				// DATO TIPO T
    Node<T> siguiente;	//NODO SIGUIENTE TIPO T

    public Node(T d) {	//CONSTRUCTOR
        dato = d;
        siguiente = null;
    }
}