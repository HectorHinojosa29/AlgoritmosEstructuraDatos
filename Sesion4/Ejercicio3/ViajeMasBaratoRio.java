package Ejercicio3;

import java.util.Scanner;


public class ViajeMasBaratoRio {

    public static int[][] calcularCostosMinimos(int[][] tarifasDirectas, int n) {
        int[][] costosMinimos = new int[n][n];

        // Inicializar C[i][j] con los valores directos de T[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                costosMinimos[i][j] = tarifasDirectas[i][j];
            }
        }

        // Aplicar programación dinámica para encontrar costos mínimos
        for (int distancia = 2; distancia < n; distancia++) { // Distancia entre i y j
            for (int i = 0; i < n - distancia; i++) {
                int j = i + distancia;
                // Verificar si hay una ruta más barata pasando por un embarcadero intermedio k
                for (int k = i + 1; k < j; k++) {
                    int costoConEscala = costosMinimos[i][k] + costosMinimos[k][j];
                    if (costoConEscala < costosMinimos[i][j]) {
                        costosMinimos[i][j] = costoConEscala;
                    }
                }
            }
        }

        return costosMinimos;
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el número de embarcaderos:");
        int numEmbarcaderos = entrada.nextInt();

        int[][] tarifasDirectas = new int[numEmbarcaderos][numEmbarcaderos];
        System.out.println("Ingrese las tarifas directas (T[i][j]):");

        for (int i = 0; i < numEmbarcaderos; i++) {
            for (int j = i + 1; j < numEmbarcaderos; j++) {
                System.out.printf("Costo de embarcadero %d a %d: ", i, j);
                tarifasDirectas[i][j] = entrada.nextInt();
            }
        }

        int[][] costosMinimos = calcularCostosMinimos(tarifasDirectas, numEmbarcaderos);

        System.out.println("\nMatriz de costos mínimos entre embarcaderos:");
        for (int i = 0; i < numEmbarcaderos; i++) {
            for (int j = 0; j < numEmbarcaderos; j++) {
                if (i >= j) {
                    System.out.print("-\t"); // No aplicable (i >= j)
                } else {
                    System.out.print(costosMinimos[i][j] + "\t");
                }
            }
            System.out.println();
        }

    }

}