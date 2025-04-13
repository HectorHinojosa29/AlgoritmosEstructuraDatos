package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class VerificacionArreglo{
	
	public static void verificarArray( int array [], int valor, ArrayList<Integer> subArray) {
		for(int i = 0; i<array.length-1 ; i++) {
			if (esPotenciaDe2(array[i])) {
				subArray.add(array[i]);
				
			}
			if(array[i] % 5 ==0 && array[i+1] % 2 ==0){
				subArray.add(array[i]);
			}
			if(array[i] % 5 ==0 && i ==array.length-2) {
				subArray.add(array[i]);
			}
		}
	}
	public static boolean esPotenciaDe2(int n) {
	    if (n <= 0) 
	    	return false;
	    if (n==1)
	    	return true;
	    if (n % 2 != 0)
	    	return false;

	    return esPotenciaDe2(n/2);

	}
	
	public static void main(String[] args) {
		ArrayList<Integer> subArray= new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		int suma=0;
		System.out.println("Ingrese la cantidad de elementos del arreglo: ");
		int valor= entrada.nextInt();
		int[] array= new int[valor];
		for(int i = 0; i<array.length; i++) {
			System.out.println("Ingrese el elemento en la posicion "+ i + ":");
			array[i]= entrada.nextInt();
		}
		verificarArray(array, valor, subArray);
		System.out.println(" Array principal: ");
		System.out.print("[ ");
		for(int elemento: array) {
			System.out.print(elemento+" ");
			
		}
		System.out.print("]");
		System.out.println("");
		System.out.println(" SubArray: ");
		System.out.print("[ ");
		for(int elemento: subArray) {
			System.out.print(elemento+" ");
			suma=suma+elemento;
		}
		System.out.print("]");
		System.out.println("Suma: "+suma);
		if (suma==array[array.length-1]) {
			System.out.println("True");
		}
		else
			System.out.println("False");

	}
	
}



