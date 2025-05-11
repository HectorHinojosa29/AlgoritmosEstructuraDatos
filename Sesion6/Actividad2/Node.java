package Actividad2;

public class Node<E> {
    private E valor;
    private Node<E> next;

    public Node(E valor) {
        this.valor = valor;
        this.next = null;
    }

    public E getvalor() {
        return valor;
    }

    public void setvalor(E valor) {
        this.valor = valor;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

