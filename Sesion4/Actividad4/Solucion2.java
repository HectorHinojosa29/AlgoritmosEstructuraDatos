package Actividad4;

public class Solucion2 {
	public static int moda2(int array[]) {
        if (array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        
        int first = 1;
        int p = 0;
        int end = array.length - 1;
        int moda = array[0];
        int free = 1;
        int maxfree = 1;
        
        while (first <= end) {
            if (array[p] == array[first]) {  // Corregido: array[first] en lugar de array(first]
                free++;
                first++;
            } else {
                if (free > maxfree) {
                    maxfree = free;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                free = 1;
            }
        }
        
        // Comprobar la última secuencia
        if (free > maxfree) {
            moda = array[p];
        }
        
        return moda;
    }

    public static void main(String[] args) {
        // Pruebas
        int[] test1 = {1, 2, 2, 3, 4}; // Moda: 2
        int[] test2 = {5, 5, 5, 2, 2, 3}; // Moda: 5
        int[] test3 = {1}; // Moda: 1
        int[] test4 = {1, 2, 3, 4, 5}; // Moda: 1 (todos con frecuencia 1)
        int[] test5 = {2, 2, 3, 3, 4}; // Moda: 2 (primer grupo con frecuencia máxima)
        
        System.out.println("Moda de [1, 2, 2, 3, 4]: " + moda2(test1));
        System.out.println("Moda de [5, 5, 5, 2, 2, 3]: " + moda2(test2));
        System.out.println("Moda de [1]: " + moda2(test3));
        System.out.println("Moda de [1, 2, 3, 4, 5]: " + moda2(test4));
        System.out.println("Moda de [2, 2, 3, 3, 4]: " + moda2(test5));
        
        try {
            int[] test6 = {};
            System.out.println("Moda de array vacío: " + moda2(test6));
        } catch (IllegalArgumentException e) {
            System.out.println("Error al calcular moda: " + e.getMessage());
        }
    }
}