package Actividad4;

class Limits {
    int[] a;
    int prim;
    int ult;
    
    public Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }
    
    public int length() {
        return ult - prim + 1;
    }
}