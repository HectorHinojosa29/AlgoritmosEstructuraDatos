package MergeSortSimple;

public class MergeSortSimple {
    public void sort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            // Encuentra el punto medio del arreglo
            int medio = (izquierda + derecha) / 2;

            // Divide la primera y segunda mitad (llamada recursiva)
            sort(arreglo, izquierda, medio);
            sort(arreglo, medio + 1, derecha);

            // Une las mitades
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    public void merge(int arreglo[], int izquierda, int medio, int derecha) {
        // Encuentra el tamaño de los sub-arreglos para unirlos
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // arreglos temporales
        int izquierda_del_arreglo[] = new int[n1];
        int derecha_del_arreglo[] = new int[n2];

        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            izquierda_del_arreglo[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha_del_arreglo[j] = arreglo[medio + j + 1];
        }

        //Une los arreglos temporales

        // Indices inicial del primer y segundo sub-arreglo
        int i = 0, j = 0;
        // Indice inicial del sub-vector arreglo[].
        int k = izquierda;

        // Ordenamiento
        while (i < n1 && j < n2) {
            if (izquierda_del_arreglo[i] <= derecha_del_arreglo[j]) {
                arreglo[k] = izquierda_del_arreglo[i];
                i++;
            } 
            else {
                arreglo[k] = derecha_del_arreglo[j];
                j++;
            }
            k++;
        }

        // Si quedan elementos por ordenar 
        // Copiar los elementos restantes de izquierda_del_arreglo[].
        while (i < n1) {
            arreglo[k] = izquierda_del_arreglo[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de derecha_del_arreglo[].
        while (j < n2) {
            arreglo[k] = derecha_del_arreglo[j];
            j++;
            k++;
        }
    }

    public void imprimir_arreglo(int arreglo[]) {
        int n = arreglo.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortSimple mergeSort = new MergeSortSimple();
        int arreglo[] = {5, 26, 12, 6, 1, 4, 7, 3, 4, 5, 2, 122, 344, 2556, 2, 5 ,5, 4};
        int n = arreglo.length;

        System.out.println("arreglo original:");
        for (int elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        System.out.println("\narreglo ordenado:");
        mergeSort.sort(arreglo, 0, n - 1);
        mergeSort.imprimir_arreglo(arreglo);
    }
}
