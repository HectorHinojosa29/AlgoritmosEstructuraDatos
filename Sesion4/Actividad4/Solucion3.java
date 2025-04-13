package Actividad4;

public class Solucion3 {
	// Método principal para encontrar la moda
    public static int moda3(int[] a, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();
        
        heterogeneo.insertar(new Limits(a, prim, ult));
        
        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            Limits p = heterogeneo.mayor();
            
            // Calculamos la mediana
            int mediana = a[(p.prim + p.ult) / 2];
            
            // Dividimos el vector en 3 subvectores
            int[] pivotes = pivote2(p.a, mediana, p.prim, p.ult);
            int izq = pivotes[0];
            int der = pivotes[1];
            
            Limits p1 = new Limits(p.a, p.prim, izq - 1);
            Limits p2 = new Limits(p.a, izq, der - 1);
            Limits p3 = new Limits(p.a, der, p.ult);
            
            // Modificamos los conjuntos
            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }
        
        if (homogeneo.esVacio()) {
            return a[prim];
        }
        
        Limits p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.a[p.prim];
    }
    
    // Método para particionar el vector alrededor de la mediana
    private static int[] pivote2(int[] a, int mediana, int prim, int ult) {
        int izq = prim;
        int der = ult;
        int i = prim;
        
        while (i <= der) {
            if (a[i] < mediana) {
                swap(a, izq, i);
                izq++;
                i++;
            } else if (a[i] > mediana) {
                swap(a, i, der);
                der--;
            } else {
                i++;
            }
        }
        
        return new int[]{izq, der + 1};
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    // Método main para probar la implementación
    public static void main(String[] args) {
        int[] test1 = {1, 2, 2, 3, 4}; // Moda: 2
        int[] test2 = {5, 5, 5, 2, 2, 3}; // Moda: 5
        int[] test3 = {1}; // Moda: 1
        int[] test4 = {1, 2, 3, 4, 5}; // Moda: 1 (todos con frecuencia 1)
        int[] test5 = {2, 2, 3, 3, 4}; // Moda: 2 (primer grupo con frecuencia máxima)
        int[] test6 = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}; // Moda: 3
        
        System.out.println("Moda de [1, 2, 2, 3, 4]: " + moda3(test1, 0, test1.length - 1));
        System.out.println("Moda de [5, 5, 5, 2, 2, 3]: " + moda3(test2, 0, test2.length - 1));
        System.out.println("Moda de [1]: " + moda3(test3, 0, test3.length - 1));
        System.out.println("Moda de [1, 2, 3, 4, 5]: " + moda3(test4, 0, test4.length - 1));
        System.out.println("Moda de [2, 2, 3, 3, 4]: " + moda3(test5, 0, test5.length - 1));
        System.out.println("Moda de [1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]: " + moda3(test6, 0, test6.length - 1));
    }
}
