package ActividadEjercicios;

public class ListaUtils {

    public static <T> boolean buscarElemento(Node<T> cabeza, T valor) {
    	//METODO BUSCAR ELEMENTO
        Node<T> actual = cabeza;//VALOR ACTUAL LA CABEZA
        while (actual != null) {// ACTUAL(CABEZA) NO PUEDE ESTAR VACIO
            if (actual.dato.equals(valor)) return true;
            //COMPARA EL VALOR DEL USUARI CON EL DE LA LISTA
            actual = actual.siguiente;//ACTUAL AHORA ES EL SIGUIENTE VALOR EN LA LISTA
        }
        return false;
    }



    public static <T> Node<T> insertarAlFinal(Node<T> cabeza, T valor) {//METODO INSERTAR VALOR AL FINAL
        Node<T> nuevo = new Node<>(valor);
        if (cabeza == null) return nuevo;//VERFICA SI LA CABEZA ESTA VACIA SI SI RETORNA EL NUEVO NODO
        Node<T> actual = cabeza;
        while (actual.siguiente != null) actual = actual.siguiente;
        //MIENTRA EL SIGUIENTE NODO NO ES VACIO ACTUAL ES EL SIGUIENTE NODO
        actual.siguiente = nuevo;//NUEVO ES EL SIGUIENTE NODO
        return cabeza;
    }

    public static <T> int contarNodos(Node<T> cabeza) {
    	//METODO PARA CONTAR CUANTOS NODOS HAY
        int contador = 0;//CONTADOR DESDE 0
        Node<T> actual = cabeza;
        while (actual != null) {//SI ACTUAL ES CABEZA ESTE NO DEBE SE NULO, SINO CONTADOR SEGUIRIA EN 0
            contador++; //AUMENTA CONTADOR EN 1
            actual = actual.siguiente; // SIGUIENTE NODO
        }
        return contador;
    }

    public static <T> boolean sonIguales(Node<T> l1, Node<T> l2) {
    //METODO SON IGUALES COMPARA DOS LISTAS
        while (l1 != null && l2 != null) {//NIGUNA LSITA PUEDE ESTAR VACIA
            if (!l1.dato.equals(l2.dato)) return false;
            // USO DEL METODO EQUALS PARA COMPARAR LOS NODOS Y VALORES LAS LISTAS
            l1 = l1.siguiente;//SIGUIENTE NODO DE LA LISTA 1
            l2 = l2.siguiente;//SIGUIENTE NODO DE LA LISTA 2
        }
        return l1 == null && l2 == null;//RETORNA SI SON LISTAS IGUALES O DIFERENTES(true-false)
    }

    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
    	//METODO CONCATENAR LISTAS
        if (l1 == null) return l2;//SI LISTA 1 ESTA VACIA RETORNA LA LISTA 2
        Node<T> actual = l1;
        while (actual.siguiente != null) actual = actual.siguiente;
        //MIENTRAS EL NODO SIGUIENTE NO SEA VACIO EL VALOR CAMBIA AL SIGUIENTE NODO
        actual.siguiente = l2;//AL SIGUIENTE NODO SE LE ASIGNA EL LA LISTA 2 
        return l1;
    }
}