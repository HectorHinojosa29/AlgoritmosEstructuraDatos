package ActividadEjercicios;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T extends Comparable<T>> {
	//CLASE GESTORTAREAS DE TIPO T(HEREDA DE INTERFAZ COMPARABLE)
    Node<T> cabeza;//NODO CABEZA
    List<T> tareasHechas;// LISTA PARA LAS TAREAS COMPLETADAS

    public GestorDeTareas() {//CONSTRUCTOR
        cabeza = null;
        tareasHechas = new ArrayList<>();
    }

    public void agregarTarea(T tarea) {//AGREGAR TAREA
        Node<T> nuevo = new Node<>(tarea);
        if (cabeza == null) { //VERIFICA QUE LA CABEZA ESTE VACIO
            cabeza = nuevo; //SI SI ASIGNA NUEVA TAREA A LA CABEZA
        } else {
            Node<T> aux = cabeza;
            while (aux.siguiente != null) {//ITERA EN LOS NODOS HASTA QUE UNO ESTE VACIO
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;// NUEVA TAREA
        }
    }

    public boolean eliminarTarea(T tarea) {//ELIMiNA TAREA
        if (cabeza == null) return false;

        if (cabeza.dato.equals(tarea)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Node<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(tarea)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }

        return false;
    }

    public boolean contieneTarea(T tarea) {//VERIFICA SI EXISTE LA TAREA
        Node<T> aux = cabeza;
        while (aux != null) {
            if (aux.dato.equals(tarea)) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    public void imprimirTareas() {//MUESTRA LAS TAREAS
        if (cabeza == null) {
            System.out.println("No hay tareas.");
            return;
        }
        Node<T> aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public int contarTareas() {//CUENTA CUANTAS TAREAS O NODOS HAY
        int cont = 0;
        Node<T> aux = cabeza;
        while (aux != null) {
            cont++;
            aux = aux.siguiente;
        }
        return cont;
    }

    public T obtenerTareaMasPrioritaria() {//OBTIENE LA TAREA DE MAYOR PRIORIDAD
        if (cabeza == null) return null;

        T mejor = cabeza.dato;
        Node<T> aux = cabeza.siguiente;
        while (aux != null) {
            if (aux.dato.compareTo(mejor) < 0) {
                mejor = aux.dato;
            }
            aux = aux.siguiente;
        }
        return mejor;
    }

    public void invertirTareas() { //INVIERTE LA LISTA DE TAREAS
        Node<T> anterior = null;
        Node<T> actual = cabeza;
        Node<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    public boolean completarTarea(T tarea) { 
    	//COMPLETA TAREA(AGREGA A LISTA DE TAREAS HECHAS) Y LA ELIMINA DE LA LISTA
        if (eliminarTarea(tarea)) {
            tareasHechas.add(tarea);
            return true;
        }
        return false;
    }

    public void mostrarTareasCompletadas() {//MUESTRA LA LISTA DE TAREAS HECHAS
        if (tareasHechas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            System.out.println("Tareas completadas:");
            for (T t : tareasHechas) {
                System.out.println(t);
            }
        }
    }
}