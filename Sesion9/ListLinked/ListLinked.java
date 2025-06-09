package ListLinked;

public class ListLinked<E> {
    private Node<E> first;
    private Node<E> current; 

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListLinked() {
        first = null;
        current = null;
    }

    public void insert(E data) {
        Node<E> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public boolean search(E data) {
        Node<E> current = first;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(E data) {
        if (first == null) return false;

        if (first.data.equals(data)) {
            first = first.next;
            return true;
        }

        Node<E> prev = first;
        Node<E> curr = first.next;

        while (curr != null) {
            if (curr.data.equals(data)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public E getFirst() {
        current = first;
        return current != null ? current.data : null;
    }

    public E getNext() {
        if (current == null) return null;
        current = current.next;
        return current != null ? current.data : null;
    }

    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        int count = 0;
        Node<E> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }


}