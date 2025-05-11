package Ejercicio2;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int primero;
    private int ultimo;
    private int tamanio;
    private int max;

    public QueueArray(int cant) {
        this.array = (E[]) new Object[cant];
        this.max = cant;
        this.primero = 0;
        this.ultimo = 0;
        this.tamanio = 0;
    }

    public void enqueue(E x) {
        if (tamanio == max) {
            throw new IllegalStateException("Cola llena");
        }
        array[ultimo] = x;
        ultimo = (ultimo + 1) % max;
        tamanio++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E value = array[primero];
        primero = (primero + 1) % max;
        tamanio--;
        return value;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return array[primero];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return array[(ultimo - 1 + max) % max];
    }

    public boolean isEmpty() {
        return tamanio == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = primero;
        for (int i = 0; i < tamanio; i++) {
            sb.append(array[index]).append("\n");
            index = (index + 1) % max;
        }
        return sb.toString();
    }
}

