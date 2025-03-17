package InterfacesClasesGenericas;

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
		menu();
		OperacionesMatBInteger operacionesMatBInteger = new OperacionesMatBInteger();
		System.out.println(operacionesMatBInteger.suma(1,100));
		System.out.println(operacionesMatBInteger.division(1,100));
		
	}
}
