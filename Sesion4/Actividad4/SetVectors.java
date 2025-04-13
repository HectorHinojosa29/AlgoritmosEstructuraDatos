package Actividad4;

import java.util.TreeSet;

class SetVectors {
    private TreeSet<Limits> set;
    
    public SetVectors() {
        // Ordenamos por longitud descendente
        set = new TreeSet<>((l1, l2) -> {
            int lenComp = Integer.compare(l2.length(), l1.length());
            if (lenComp != 0) return lenComp;
            return Integer.compare(l1.prim, l2.prim);
        });
    }
    
    public void insertar(Limits p) {
        set.add(p);
    }
    
    public Limits mayor() {
        return set.pollFirst();
    }
    
    public int longMayor() {
        return set.isEmpty() ? 0 : set.first().length();
    }
    
    public boolean esVacio() {
        return set.isEmpty();
    }
    
    public void destruir() {
        set.clear();
    }
}