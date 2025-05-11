package Actividad3;

import Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N prior;

        EntryNode(E data, N prior) {
            this.data = data;
            this.prior = prior;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            Node<EntryNode> current = this.first;
            Node<EntryNode> previous = null;

            while (current != null && current.getData().prior.compareTo(pr) >= 0) {
                previous = current;
                current = current.getNext();
            }

            if (previous == null) {
                newNode.setNext(this.first);
                this.first = newNode;
            } else {
                previous.setNext(newNode);
                newNode.setNext(current);
            }

            if (newNode.getNext() == null) {
                this.last = newNode;
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }

        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.last.getData().data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> current = this.first;
        while (current != null) {
            sb.append(current.getData().data).append(" (Prioridad: ").append(current.getData().prior).append(")\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}

