package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            QueueLink<Integer> queueEnteros = new QueueLink<>();
            queueEnteros.enqueue(10);
            queueEnteros.enqueue(20);
            queueEnteros.enqueue(30);

            System.out.println("Contenido de la cola:");
            System.out.println(queueEnteros.toString());

            System.out.println("Frente de la cola: " + queueEnteros.front());
            System.out.println("Último de la cola: " + queueEnteros.back());

            System.out.println("Dequeue: " + queueEnteros.dequeue());
            System.out.println("Dequeue: " + queueEnteros.dequeue());

            System.out.println("Contenido de la cola después de los dequeue:");
            System.out.println(queueEnteros.toString());
            
            
            QueueLink<String> queueString = new QueueLink<>();
            queueString.enqueue("Hola");
            queueString.enqueue("Mundo");
            queueString.enqueue("Pilas y Colas");

            System.out.println("Contenido de la cola:");
            System.out.println(queueString.toString());

            System.out.println("Frente de la cola: " + queueString.front());
            System.out.println("Último de la cola: " + queueString.back());

            System.out.println("Dequeue: " + queueString.dequeue());
            System.out.println("Dequeue: " + queueString.dequeue());

            System.out.println("Contenido de la cola después de los dequeueEnteross:");
            System.out.println(queueString.toString());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
