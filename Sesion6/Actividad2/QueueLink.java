package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (this.isEmpty()) {
            this.first = aux;
        } else {
            this.last.setNext(aux);
        }
        this.last = aux;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        } else {
            E value = this.first.getvalor();
            this.first = this.first.getNext();
            if (this.first == null) {
                this.last = null;
            }
            return value;
        }
    }

    public E front() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        } else {
            return this.first.getvalor();
        }
    }

    public E back() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        } else {
            return this.last.getvalor();
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.first;
        while (current != null) {
            sb.append(current.getvalor()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}
