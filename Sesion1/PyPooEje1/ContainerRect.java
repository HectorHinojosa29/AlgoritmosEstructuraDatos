package PyPooEje1;

import PyPooAct1.Rectangulo;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n; // Capacidad máxima
    private static int numRec = 0; // Número actual de rectángulos almacenados

    // Constructor
    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // Método para agregar un rectángulo al contenedor
    public void agregarRectangulo(Rectangulo r) {
        if (numRec < n) { // Verifica si aún hay espacio en el contenedor
            rectangulos[numRec] = r;
            distancias[numRec] = calcularDistancia(r);
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No se pueden agregar más rectángulos. Contenedor lleno.");
        }
    }

    // Método para calcular la distancia euclidiana entre las esquinas del rectángulo
    private double calcularDistancia(Rectangulo r) {
        double x1 = r.getEsquina1().getX();
        double y1 = r.getEsquina1().getY();
        double x2 = r.getEsquina2().getX();
        double y2 = r.getEsquina2().getY();

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Método para mostrar los rectángulos almacenados con sus áreas y distancias
    public void mostrarRectangulos() {
        System.out.println("Rectángulos almacenados:");
        for (int i = 0; i < numRec; i++) {
            System.out.println("Rectángulo " + (i + 1) + ": " +
                               "Esquina 1: (" + rectangulos[i].getEsquina1().getX() + ", " + rectangulos[i].getEsquina1().getY() + "), " +
                               "Esquina 2: (" + rectangulos[i].getEsquina2().getX() + ", " + rectangulos[i].getEsquina2().getY() + ") | " +
                               "Área: " + areas[i] + " | Distancia: " + distancias[i]);
        }
    }
    
    public void aRectangulo(Rectangulo r) {
        if (numRec < n) { // Verifica si hay espacio disponible
            rectangulos[numRec] = r; // Guarda el rectángulo
            distancias[numRec] = calcularDistancia(r); // Calcula y almacena la distancia
            areas[numRec] = r.calculoArea(); // Calcula y almacena el área
            numRec++; // Incrementa el contador de rectángulos almacenados
        } else {
            System.out.println("No se pueden agregar más rectángulos. Contenedor lleno.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-25s %-10s %-10s\n", "Rectángulo", "Coordenadas", "Distancia", "Área"));

        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("%-10d ([%.1f, %.1f], [%.1f, %.1f]) %-10.3f %-10.2f\n", 
                    (i + 1),
                    rectangulos[i].getEsquina1().getX(), rectangulos[i].getEsquina1().getY(),
                    rectangulos[i].getEsquina2().getX(), rectangulos[i].getEsquina2().getY(),
                    distancias[i],
                    areas[i]));
        }

        return sb.toString();
    }
}
