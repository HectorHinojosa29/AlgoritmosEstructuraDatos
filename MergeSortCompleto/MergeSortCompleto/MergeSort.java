import java.util.ArrayList;

public class MergeSort {

    // Metodo generico que ordena un ArrayList de elementos comparables
    //Divide el ArrayList en mitades recursivamente hasta que las sublistas tienen un solo elemento.
    //Luego, las une de forma ordenada usando el método merge.
    public <T extends Comparable<T>> void sort(ArrayList<T> arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            sort(arreglo, izquierda, medio);
            sort(arreglo, medio + 1, derecha);
            merge(arreglo, izquierda, medio, derecha);
        }
    }
    // Metodo generico que une ambas mitades de los arreglos
    private <T extends Comparable<T>> void merge(ArrayList<T> arreglo, int izquierda, int medio, int derecha) {
        //Crea dos ArrayList auxiliares: uno para la mitad izquierda y otro para la derecha.
        ArrayList<T> izquierda_del_arreglo = new ArrayList<>(medio - izquierda + 1);
        ArrayList<T> derecha_del_arreglo = new ArrayList<>(derecha - medio);

        // copia los elementos de la parte izquierda del arreglo original (arreglo) hacia una nueva lista auxiliar
        for (int i = 0; i < medio - izquierda + 1; i++) {
            izquierda_del_arreglo.add(arreglo.get(izquierda + i));
            System.out.println(izquierda_del_arreglo);
        }
        //  copia los elementos de la parte derecha del arreglo original (arreglo) hacia una nueva lista auxiliar
        for (int j = 0; j < derecha - medio; j++) {
            derecha_del_arreglo.add(arreglo.get(medio + 1 + j));
        }
        /*i es índice para recorrer izquierda_del_arreglo
        j es para derecha_del_arreglo
        k es el índice del arreglo original arreglo donde se van colocando los elementos ordenados. */
        int i = 0, j = 0;
        int k = izquierda;

        //Compara los elementos de ambas mitades
        //Si el de la izquierda es menor o igual, se coloca en el arreglo original.
        while (i < izquierda_del_arreglo.size() && j < derecha_del_arreglo.size()) {
            //  Si el elemento izquierdo es menor o igual al derecho, va primero
            if (izquierda_del_arreglo.get(i).compareTo(derecha_del_arreglo.get(j)) <= 0) {
                arreglo.set(k++, izquierda_del_arreglo.get(i++));
            } 
            else {
                arreglo.set(k++, derecha_del_arreglo.get(j++));
            }
        }
        //Si todavía quedan elementos en la lista izquierda, los pone en el arreglo original.
        //Esto pasa si los de la derecha ya se terminaron.
        while (i < izquierda_del_arreglo.size()) {
            arreglo.set(k++, izquierda_del_arreglo.get(i++));
        }
        //Igual para los elementos restantes de la lista derecha.
        while (j < derecha_del_arreglo.size()) {
            arreglo.set(k++, derecha_del_arreglo.get(j++));
        }
    }

    public <T> void ImprimirArrayList(ArrayList<T> arreglo) {
        for (T elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}
