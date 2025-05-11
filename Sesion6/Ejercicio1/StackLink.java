package Ejercicio1;


import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;
import Actividad2.Node;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(this.top);
        this.top = newNode;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E data = this.top.getvalor();
        this.top = this.top.getNext();
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return this.top.getvalor();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.top;
        while (current != null) {
            sb.append(current.getvalor()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}
