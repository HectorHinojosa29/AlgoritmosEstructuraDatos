package Ejercicio1;


import Actividad1.Stack;
import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            Stack<Integer> stackEnteros = new StackLink<>();
            stackEnteros.push(20);
            stackEnteros.push(60);
            stackEnteros.push(100);
            System.out.println("Pila después de las inserciones:");
            System.out.println(stackEnteros);

            System.out.println("Elemento en la parte superior: " + stackEnteros.top());

            System.out.println("Pop: " + stackEnteros.pop());
            System.out.println("Pila después del pop:");
            System.out.println(stackEnteros);

            Stack<String> stackString = new StackLink<>();
            stackString.push("Hola");
            stackString.push("Mundo");
            stackString.push("Pilas y Colas");
            System.out.println("Pila después de las inserciones:");
            System.out.println(stackString);

            System.out.println("Elemento en la parte superior: " + stackString.top());

            System.out.println("Pop: " + stackString.pop());
            System.out.println("Pop: " + stackString.pop());
            System.out.println("Pila después del pop:");
            System.out.println(stackString);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
