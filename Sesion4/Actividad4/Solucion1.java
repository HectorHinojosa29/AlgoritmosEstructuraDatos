package Actividad4;

public class Solucion1 {
	public static void main(String[] args) {
        // Caso de prueba 1: Array con un único elemento
        int[] array1 = {5};
        System.out.println("Moda de [5]: " + modal(array1));  // Debería imprimir 5

        // Caso de prueba 2: Array con varios elementos y una moda clara
        int[] array2 = {1, 2, 2, 3, 4, 2, 5};
        System.out.println("Moda de [1, 2, 2, 3, 4, 2, 5]: " + modal(array2));  // Debería imprimir 2

        // Caso de prueba 3: Array donde todos los elementos son únicos
        int[] array3 = {10, 20, 30, 40};
        System.out.println("Moda de [10, 20, 30, 40]: " + modal(array3));  // Devolverá el primero (10)

        // Caso de prueba 4: Array con empate en frecuencia
        int[] array4 = {1, 1, 2, 2, 3};
        System.out.println("Moda de [1, 1, 2, 2, 3]: " + modal(array4));  // Devolverá el primero que alcanza esa frecuencia (1)

        // Caso de prueba 5: Array vacío (manejo de error)
        int[] array5 = {};
        try {
            System.out.println("Moda de array vacío: " + modal(array5));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array vacío no tiene moda");
        }
    }

    public static int modal(int array[]) {
        int first = 0;
        int end = array.length - 1;

        if (first == end)
            return array[first];
        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda);

        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }
        return moda;
    }

    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first == end) 
            return array[first] == ele ? 1 : 0;
        int sum = 0;
        for (int i = first; i <= end; i++)
            if (array[i] == ele)
                sum++;
        return sum;
    }
}
