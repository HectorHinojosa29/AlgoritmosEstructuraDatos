package Ejercicio2;

import java.util.Scanner;

import java.util.Scanner;

public class EncontrarKesimoMasPequeno {

    public static int encontrarElementoKPequeno(int[] numeros, int k) {
        if (numeros == null || numeros.length == 0 || k < 1 || k > numeros.length) {
            throw new IllegalArgumentException("K debe estar entre 1 y el tamaño del arreglo");
        }
        return busquedaRapida(numeros.clone(), 0, numeros.length - 1, k - 1); // Usamos clone() para no modificar el original
    }

    private static int busquedaRapida(int[] numeros, int inicio, int fin, int k) {
        if (inicio == fin) {
            return numeros[inicio];
        }

        int posicionPivote = dividirArreglo(numeros, inicio, fin);

        if (k == posicionPivote) {
            return numeros[k];
        } else if (k < posicionPivote) {
            return busquedaRapida(numeros, inicio, posicionPivote - 1, k);
        } else {
            return busquedaRapida(numeros, posicionPivote + 1, fin, k);
        }
    }

    private static int dividirArreglo(int[] numeros, int inicio, int fin) {
        int pivote = numeros[fin];
        int indiceMenores = inicio;

        for (int indiceActual = inicio; indiceActual < fin; indiceActual++) {
            if (numeros[indiceActual] <= pivote) {
                intercambiar(numeros, indiceMenores, indiceActual);
                indiceMenores++;
            }
        }

        intercambiar(numeros, indiceMenores, fin);
        return indiceMenores;
    }

    private static void intercambiar(int[] numeros, int i, int j) {
        int temporal = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temporal;
    }
    

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de valores del array: ");
        int valor= entrada.nextInt();
		int[] array= new int[valor];
		for(int i = 0; i<array.length; i++) {
			System.out.println("Ingrese el elemento en la posicion "+ i + ":");
			array[i]= entrada.nextInt();
		}


        System.out.println("Ingrese el valor de K:");
        int k = entrada.nextInt();

        try {
            int resultado = encontrarElementoKPequeno(array, k);
            System.out.println("El " + k + "-ésimo elemento más pequeño es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}