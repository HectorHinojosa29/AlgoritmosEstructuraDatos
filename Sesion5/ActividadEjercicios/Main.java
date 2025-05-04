package ActividadEjercicios;

import java.util.Scanner;

public class Main {
	//USO DE SWITCH CASE PARA LAS OPCIONES Y LA LLAMADA A LOS EMTODOS CORRESPONDIENTES
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        Node<Tarea> listaExtra = null;

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Ver tareas");
            System.out.println("4. Ver si existe una tarea");
            System.out.println("5. Invertir lista de tareas");
            System.out.println("6. Ver tarea más prioritaria");
            System.out.println("7. Completar tarea");
            System.out.println("8. Ver tareas completadas");
            System.out.println("9. Buscar tarea ");
            System.out.println("10. Comparar con lista extra");
            System.out.println("11. Concatenar lista extra");
            System.out.println("12. Contar nodos de la lista");
            System.out.println("13. Agregar tarea a lista extra");
            System.out.println("14. Ver lista extra");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Titulo de la tarea: ");
                    String tit = sc.nextLine();
                    gestor.agregarTarea(new Tarea(tit, verificarPrioridad()));
                    System.out.println("Tarea agregada.");
                    break;

                case 2:
                    System.out.print("Titulo exacta de la tarea a eliminar: ");
                    String titEli = sc.nextLine();
                    boolean eliminada = gestor.eliminarTarea(new Tarea(titEli, verificarPrioridad()));
                    System.out.println(eliminada ? "Tarea eliminada." : "No se encontró la tarea.");
                    break;

                case 3:
                    System.out.println("Tareas actuales:");
                    gestor.imprimirTareas();
                    break;

                case 4:
                    System.out.print("Titulo de la tarea a buscar: ");
                    String titBus = sc.nextLine();
                    boolean existe = gestor.contieneTarea(new Tarea(titBus, verificarPrioridad()));
                    System.out.println(existe ? "La tarea existe." : "No existe esa tarea.");
                    break;

                case 5:
                    gestor.invertirTareas();
                    System.out.println("Lista invertida.");
                    break;

                case 6:
                    Tarea t = gestor.obtenerTareaMasPrioritaria();
                    System.out.println(t != null ? "Más prioritaria: " + t : "No hay tareas.");
                    break;

                case 7:
                    System.out.print("Titulo de la tarea a completar: ");
                    String titComp = sc.nextLine();
                    boolean comp = gestor.completarTarea(new Tarea(titComp, verificarPrioridad()));
                    System.out.println(comp ? "Tarea completada." : "No se encontró la tarea.");
                    break;

                case 8:
                    gestor.mostrarTareasCompletadas();
                    break;
                case 9:
                    System.out.print("Descripción de la tarea a buscar: ");
                    String descBuscarNodo = sc.nextLine();
                    boolean esta = ListaUtils.buscarElemento(gestor.cabeza, new Tarea(descBuscarNodo, verificarPrioridad()));
                    System.out.println(esta ? "La tarea se encuentra en la lista enlazada." : "La tarea no está en la lista enlazada.");
                    break;
    
                case 10:
                    boolean iguales = ListaUtils.sonIguales(gestor.cabeza, listaExtra);
                    System.out.println(iguales ? "Las listas son iguales." : "Las listas son diferentes.");
                    break;
                case 11:
                    gestor.cabeza = ListaUtils.concatenarListas(gestor.cabeza, listaExtra);
                    System.out.println("Listas concatenadas.");
                    listaExtra = null;
                    break;
                case 12:
                    int total = ListaUtils.contarNodos(gestor.cabeza);
                    System.out.println("Número de tareas en la lista: " + total);
                    break;
                    
                case 13:
                	System.out.print("titulo de la tarea extra: ");
                    String titExtra = sc.nextLine();

                    listaExtra = ListaUtils.insertarAlFinal(listaExtra, new Tarea(titExtra, verificarPrioridad()));
                    System.out.println("Tarea agregada a la lista extra.");
                    break;
                    
                case 14:
                    System.out.println("Lista extra:");
                    Node<Tarea> actualExtra = listaExtra;
                    while (actualExtra != null) {
                        System.out.println(actualExtra.dato);
                        actualExtra = actualExtra.siguiente;
                    }
                    break;
                    
                
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
    //METODO PARA VALIDAR LA PRIORIDAD DE 1 A 5
    static int verificarPrioridad() {
    	int prio;
    	Scanner sc = new Scanner(System.in);
    	do{
        	System.out.print("Prioridad de la tarea (1 alta - 5 baja): ");
			prio = sc.nextInt();	
        }while(prio<1 || prio>5);
    	sc.nextLine();
    	return prio;
    }
    
}