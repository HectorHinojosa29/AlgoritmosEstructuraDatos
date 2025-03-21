package InterfacesClasesGenericas;

import java.util.Scanner;

public class Prueba {
	public static void menu() {
		System.out.println("Menú de Operaciones Clases Genéricas \n1. Suma.\r\n"
				+ "2. Resta.\r\n"
				+ "3. Producto.\r\n"
				+ "4. División.\r\n"
				+ "5. Potencia.\r\n"
				+ "6. Raíz Cuadrada.\r\n"
				+ "7. Raíz Cubica.\r\n"
				+ "8. Salir ");
		
	}
	public static void main(String[] args) {
		OperacionesMatBInteger operacionesMatBInteger = new OperacionesMatBInteger();
		OperacionesMatBDouble operacionesMatBDouble = new OperacionesMatBDouble();
		boolean salida=false;
		
		int opcion;
		int operandoE1,operandoE2;
		double operandoD1,operandoD2;
		String tipoOperacion;
		do {
			Scanner entrada=new Scanner(System.in);
			menu();
			System.out.println("Ingrese una opcion: ");
			opcion=entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
				case 1:{
					System.out.println("Operacion de Enteros o Doubles(E/D):");
					tipoOperacion=entrada.next();
					if (tipoOperacion.equals("E") || tipoOperacion.equals("e")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoE1=entrada.nextInt();
						operandoE2=entrada.nextInt();
						System.out.println("Resultado: "+operacionesMatBInteger.suma(operandoE1,operandoE2));
						
					}else if(tipoOperacion.equals("D") || tipoOperacion.equals("d")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoD1=entrada.nextDouble();
						operandoD2=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.suma(operandoD1,operandoD2));
					}else System.out.println("Opcion invalida");
					break;}
				
				case 2:{
					System.out.println("Operacion de Enteros o Doubles(E/D):");
					tipoOperacion=entrada.nextLine();
					if (tipoOperacion.equals("E") || tipoOperacion.equals("e")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoE1=entrada.nextInt();
						operandoE2=entrada.nextInt();
						System.out.println("Resultado: "+operacionesMatBInteger.resta(operandoE1,operandoE2));
						
					}else if(tipoOperacion.equals("D") || tipoOperacion.equals("d")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoD1=entrada.nextDouble();
						operandoD2=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.resta(operandoD1,operandoD2));
					}
					break;}
				
				
				case 3:{
					System.out.println("Operacion de Enteros o Doubles(E/D):");
					tipoOperacion=entrada.nextLine();
					if (tipoOperacion.equals("E") || tipoOperacion.equals("e")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoE1=entrada.nextInt();
						operandoE2=entrada.nextInt();
						System.out.println("Resultado: "+operacionesMatBInteger.producto(operandoE1,operandoE2));
						
					}else if(tipoOperacion.equals("D") || tipoOperacion.equals("d")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoD1=entrada.nextDouble();
						operandoD2=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.producto(operandoD1,operandoD2));
					}
					break;}
				
				
				case 4:{
					System.out.println("Operacion de Enteros o Doubles(E/D):");
					tipoOperacion=entrada.nextLine();
					if (tipoOperacion.equals("E") || tipoOperacion.equals("e")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoE1=entrada.nextInt();
						operandoE2=entrada.nextInt();
						System.out.println("Resultado: "+operacionesMatBInteger.division(operandoE1,operandoE2));
						
					}else if(tipoOperacion.equals("D") || tipoOperacion.equals("d")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoD1=entrada.nextDouble();
						operandoD2=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.division(operandoD1,operandoD2));
					}
					break;}
				
				
				case 5:{
					System.out.println("Operacion de Enteros o Doubles(E/D):");
					tipoOperacion=entrada.nextLine();
					if (tipoOperacion.equals("E") || tipoOperacion.equals("e")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoE1=entrada.nextInt();
						operandoE2=entrada.nextInt();
						System.out.println("Resultado: "+operacionesMatBInteger.potencia(operandoE1,operandoE2));
						
					}else if(tipoOperacion.equals("D") || tipoOperacion.equals("d")) {
						System.out.println("Ingrese el primer operando 1 y operando 2: ");
						operandoD1=entrada.nextDouble();
						operandoD2=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.potencia(operandoD1,operandoD2));
					}
					break;}
				
				
				case 6:{
						System.out.println("Ingrese el operando: ");
						operandoD1=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.raizCuad(operandoD1));
					
					break;}
					
				case 7:{
						System.out.println("Ingrese el operando: ");
						operandoD1=entrada.nextDouble();
						System.out.println("Resultado: "+operacionesMatBDouble.raizCubi(operandoD1));
					
					break;}
				
	
				case 8:{
					System.out.println("Saliendo.........");
					salida=true;
					break;}
					
			}
			
			
		tipoOperacion=null;
		}while (salida==false);
		

		
	}
}
