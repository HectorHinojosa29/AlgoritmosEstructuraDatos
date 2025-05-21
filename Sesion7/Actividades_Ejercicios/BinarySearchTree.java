// Interfaz que define las operaciones básicas de un Árbol Binario de Búsqueda (BST)
package Actividades_Ejercicios;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import Exceptions.ExceptionIsEmpty;

public interface BinarySearchTree<E> {
	
    // Inserta un elemento en el árbol
	void insert(E data) throws ItemDuplicated;

    // Busca un elemento en el árbol
	E search(E data) throws ItemNotFound;

    // Elimina un elemento del árbol
	void delete(E data) throws ExceptionIsEmpty;

    // Verifica si el árbol está vacío
	boolean isEmpty();
}
