package graph;
//ACTIVIDAD 2
import ListLinked.ListLinked;

public class Vertex<E> {
    private E data;
    protected ListLinked<Edge<E>> listAdj;

    public Vertex(E data) {
        this.data = data;
        this.listAdj = new ListLinked<Edge<E>>();
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
}