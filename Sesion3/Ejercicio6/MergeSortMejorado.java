package Ejercicio6;

import java.util.Arrays;

public class MergeSortMejorado {
    private static final int INSERTION_THRESHOLD = 16;  // Umbral para Insertion Sort

    public static void optimizedMergeSort(int[] arr, int left, int right) {
        if (right - left <= INSERTION_THRESHOLD) {
            insertionSort(arr, left, right);  // O(n²) para n pequeño (mejor constante)
            return;							  // O(1), constante
        }

        int mid = (left + right) / 2;			// O(1), constante
        optimizedMergeSort(arr, left, mid);
        optimizedMergeSort(arr, mid + 1, right);// O(log n), logaritmica(recursion)

        // Si ya está ordenado, evita la fusión
        if (arr[mid] > arr[mid + 1]) {			// O(1), constante
            merge(arr, left, mid, right);  		// O(1), constante
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {// O(n), lineal
            int key = arr[i];					// O(1), constante	
            int j = i - 1;						// O(1), constante
            while (j >= left && arr[j] > key) {	// O(n), lineal
                arr[j + 1] = arr[j];			// O(1), constante
                j--;							// O(1), constante
            }
            arr[j + 1] = key;					// O(1), constante
        }
    }

 // Método principal para ordenar - O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {  // O(1), constante
            int mid = (left + right) / 2;  // O(1), constante
            
            mergeSort(arr, left, mid);      // T(n/2), logarítmica con respecto a “n”
            mergeSort(arr, mid + 1, right); // T(n/2), logarítmica con respecto a “n”
            merge(arr, left, mid, right);   
        }
    }

    // Método para fusionar dos subarreglos - O(n)
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;  // O(1), constante
        int n2 = right - mid;     // O(1), constante

        int[] L = new int[n1];  // O(1), constante
        int[] R = new int[n2];  // O(1), constante

        // Copiar datos a L[] - O(n1)
        for (int i = 0; i < n1; i++) {  // O(n), lineal
            L[i] = arr[left + i];       // O(1), constante
        }

        // Copiar datos a R[] - O(n2)
        for (int j = 0; j < n2; j++) {  // O(n), lineal
            R[j] = arr[mid + 1 + j];    // O(1), constante
        }

        // Índices para L[], R[] y el arreglo original
        int i = 0, j = 0, k = left;  // O(1), constante

        // Fusión de L[] y R[] - O(n1 + n2) = O(n)
        while (i < n1 && j < n2) {  // O(n), lineal
            if (L[i] <= R[j]) {     // O(1), constante
                arr[k] = L[i];      // O(1), constante
                i++;                // O(1), constante
            } else {
                arr[k] = R[j];      // O(1), constante
                j++;                // O(1), constante
            }
            k++;                    // O(1), constante
        }

        // Copiar elementos restantes de L[] - O(n1 - i)
        while (i < n1) {            // O(n), lineal
            arr[k] = L[i];          // O(1), constante
            i++;                    // O(1), constante
            k++;                    // O(1), constante
        }

        // Copiar elementos restantes de R[] - O(n2 - j)
        while (j < n2) {            // O(n), lineal
            arr[k] = R[j];          // O(1), constante
            j++;                    // O(1), constante
            k++;                    // O(1), constante
        }
    }

    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};  // O(1), constante
        
        System.out.println("Arreglo original: " + Arrays.toString(arr));  // O(1), constante
        
        mergeSort(arr, 0, arr.length - 1);  // O(n log n), lineal-logarítmica 
        
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));  // O(1), constante
    }
}