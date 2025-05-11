package Actividad1;

public class Test {
    public static void main(String[] args) {
        try {
            StackArray<Integer> pilaEnteros = new StackArray<>(5);
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            pilaEnteros.push(40);

            System.out.println("Contenido de la pilaEnteros:");
            System.out.println(pilaEnteros.toString());

            System.out.println("Elemento en el top: " + pilaEnteros.top());

            System.out.println("Pop: " + pilaEnteros.pop());
            System.out.println("Pop: " + pilaEnteros.pop());

            System.out.println("Contenido de la pilaEnteros después de los pops:");
            System.out.println(pilaEnteros.toString());
            
            StackArray<String> pilaString = new StackArray<>(5);
            pilaString.push("Hola");
            pilaString.push("Mundo");
            pilaString.push("Pilas y Colas");

            System.out.println("Contenido de la pilaString:");
            System.out.println(pilaString.toString());

            System.out.println("Elemento en el top: " + pilaString.top());

            System.out.println("Pop: " + pilaString.pop());
            System.out.println("Pop: " + pilaString.pop());

            System.out.println("Contenido de la pilaString después de los pops:");
            System.out.println(pilaString.toString());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
