import java.util.*;

public class Menu {

    public static void menu() {
        Scanner scanner_menu = new Scanner(System.in);
        MergeSort mergeSort = new MergeSort();

        while (true) {
            try {
                System.out.print("     Menu     "
                        + "\n1. Crear un arreglo Integer"
                        + "\n2. Crear un arreglo Double"
                        + "\n3. Crear un arreglo Float"
                        + "\n4. Salir"
                        + "\n --------> ");
                byte opcion = scanner_menu.nextByte();

                switch (opcion) {
                    case 1: {
                        //Arreglo Integer
                        ArrayList<Integer> array_Integer = new ArrayList<>();
                        
                        System.out.print("Cuantos elementos habra en su arreglo?: "); byte n = scanner_menu.nextByte();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Ingrese los elementos del arreglo Integer " +(i+1) +": ");
                            array_Integer.add(scanner_menu.nextInt());
                        }
                        //Imprimiendo Arreglo original (desordenado)
                        System.out.println("Array original:");
                        mergeSort.ImprimirArrayList(array_Integer);

                        mergeSort.sort(array_Integer, 0, array_Integer.size() - 1);
                        
                        //Imprimiendo Arreglo ordenado
                        System.out.println("Array ordenado:");
                        mergeSort.ImprimirArrayList(array_Integer);
                        break;
                    }
                    case 2: {
                        //Arreglo Double
                        ArrayList<Double> array_Double = new ArrayList<>();
                        
                        System.out.print("Cuantos elementos habra en su arreglo?: "); byte n = scanner_menu.nextByte();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Ingrese los elementos del arreglo Double " +(i+1) +": ");
                            array_Double.add(scanner_menu.nextDouble());
                        }
                        //Imprimiendo Arreglo original (desordenado)
                        System.out.println("Array original:");
                        mergeSort.ImprimirArrayList(array_Double);
                        
                        mergeSort.sort(array_Double, 0, array_Double.size() - 1);
                        
                        //Imprimiendo Arreglo ordenado
                        System.out.println("Array ordenado:");
                        mergeSort.ImprimirArrayList(array_Double);
                        break;
                    }
                    case 3: {
                        //Arreglo Float
                        ArrayList<Float> array_Float = new ArrayList<>();

                        System.out.print("Cuantos elementos habra en su arreglo?: "); byte n = scanner_menu.nextByte();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Ingrese los elementos del arreglo Float " +(i+1) +": ");
                            array_Float.add(scanner_menu.nextFloat());
                        }
                        //Imprimiendo Arreglo original (desordenado)
                        System.out.println("Array original:");
                        mergeSort.ImprimirArrayList(array_Float);
                        
                        mergeSort.sort(array_Float, 0, array_Float.size() - 1);

                        //Imprimiendo Arreglo ordenado
                        System.out.println("Array ordenado:");
                        mergeSort.ImprimirArrayList(array_Float);
                        break;
                    }
                    case 4:
                        System.out.println("Saliendo del Programa...");
                        scanner_menu.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Ingrese valores válidos");
                scanner_menu.nextLine();
            }
        }
    }
}
