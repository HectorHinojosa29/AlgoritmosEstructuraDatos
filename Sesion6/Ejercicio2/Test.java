package Ejercicio2;

import Actividad2.Queue;
import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueArray<>(4);
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            System.out.println("Cola después de insertar:");
            System.out.println(cola);

            System.out.println("Frente: " + cola.front());
            System.out.println("Final: " + cola.back());

            cola.dequeue();
            System.out.println("Cola después de un dequeue:");
            System.out.println(cola);



        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}

