package Ejercicio3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("=== Prueba de Cola de Prioridad ===");
            
            PriorityQueueLinked<String, Integer> tareas = new PriorityQueueLinked<>(5);
            

            tareas.enqueue("Hacer resumen", 1);
            tareas.enqueue("Estudiar para examen", 3);
            tareas.enqueue("Comprar materiales", 2);
            tareas.enqueue("Entregar proyecto final", 4);
            tareas.enqueue("Hacer ejercicios", 5);
            
            System.out.println("\nEstado inicial de la cola:");
            System.out.println(tareas.toString());
            
            System.out.println("\nElemento con mayor prioridad (front): " + tareas.front());
            System.out.println("Elemento con menor prioridad (back): " + tareas.back());
            
            System.out.println("\nProcesando elementos por orden de prioridad:");
            while (!tareas.isEmpty()) {
                System.out.println("Atendiendo: " + tareas.dequeue());
            }
            

            PriorityQueueLinked<Double, Integer> numeros = new PriorityQueueLinked<>(3);
            numeros.enqueue(3.5, 0);
            numeros.enqueue(1.2, 2);
            numeros.enqueue(4.8, 1);
            
            System.out.println("\nElemento con mayor prioridad (front): " + numeros.front());
            System.out.println("Elemento con menor prioridad (back): " + numeros.back());
            

            System.out.println("\nCola de números en orden de Prioridad:");
            while (!numeros.isEmpty()) {
                System.out.println(numeros.dequeue());
            }
            
            
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}