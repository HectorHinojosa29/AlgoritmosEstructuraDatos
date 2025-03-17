package PyPooAct1;

public class Verificador {

	public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
	    double x1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double x2 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double y1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
	    double y2 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

	    double x3 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double x4 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double y3 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
	    double y4 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

	    return !(x2 <= x3 || x1 >= x4 || y2 <= y3 || y1 >= y4);
	}

	
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        boolean horizontal = (r1.getEsquina2().getX() == r2.getEsquina1().getX() || 
                              r1.getEsquina1().getX() == r2.getEsquina2().getX());
        boolean vertical = (r1.getEsquina2().getY() == r2.getEsquina1().getY() || 
                            r1.getEsquina1().getY() == r2.getEsquina2().getY());
        return (horizontal || vertical) && !esSobrePos(r1, r2);
    }


    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}
