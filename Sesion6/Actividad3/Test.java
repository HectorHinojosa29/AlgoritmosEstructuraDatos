package Actividad3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueueLinkSort<Integer, Integer> pqEnteros = new PriorityQueueLinkSort<>();
            pqEnteros.enqueue(22, 3);
            pqEnteros.enqueue(19, 1);
            pqEnteros.enqueue(8, 2);

            System.out.println("Contenido de la cola de prioridad:");
            System.out.println(pqEnteros.toString());

            System.out.println("Frente de la cola: " + pqEnteros.front());
            System.out.println("Último de la cola: " + pqEnteros.back());

            System.out.println("Dequeue: " + pqEnteros.dequeue());
            System.out.println("Dequeue: " + pqEnteros.dequeue());

            System.out.println("Contenido de la cola después de los dequeues:");
            System.out.println(pqEnteros.toString());
            
            PriorityQueueLinkSort<String, Integer> pqString = new PriorityQueueLinkSort<>();
            pqString.enqueue("Tarea 1", 5);
            pqString.enqueue("Tarea 2", 2);
            pqString.enqueue("Tarea 3", 4);

            System.out.println("Contenido de la cola de prioridad:");
            System.out.println(pqString.toString());

            System.out.println("Frente de la cola: " + pqString.front());
            System.out.println("Último de la cola: " + pqString.back());

            System.out.println("Dequeue: " + pqString.dequeue());
            System.out.println("Dequeue: " + pqString.dequeue());

            System.out.println("Contenido de la cola después de los dequeues:");
            System.out.println(pqString.toString());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
