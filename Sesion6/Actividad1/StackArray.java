package Actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    public void push(E x) {
        if (isFull()) {
            System.out.println("Error: La pila está llena.");
        } else {
            array[++tope] = x;
        }
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía, no se puede hacer pop.");
        } else {
            E item = array[tope];
            array[tope--] = null;
            return item;
        }
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía, no se puede obtener el top.");
        } else {
            return array[tope];
        }
    }

    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        return this.tope == array.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]).append("\n");
        }
        return sb.toString();
    }
}

