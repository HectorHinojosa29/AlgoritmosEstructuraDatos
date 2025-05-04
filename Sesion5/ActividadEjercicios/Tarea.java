package ActividadEjercicios;

public class Tarea implements Comparable<Tarea> {//CLASE TAREA IMPLEMENTA LA INTERFAZ COMPARABLE
	// ATRIBUTOS DE UNA TAREA
    String titulo;
    int prioridad;

    public Tarea(String desc, int prio) {//CONSTRUCTOR
        titulo = desc;
        prioridad = prio;
    }

    public int getPrioridad() {//OBTENER TAREA
        return prioridad;
    }

    public String gettitulo() {//OBTENER TITULO
        return titulo;
    }

    @Override
    public String toString() {//METODO QUE MUESTRA LA TAREA Y SU PRIORIDAD
        return titulo + " (prioridad " + prioridad + ")";
    }

    @Override
    public boolean equals(Object obj) {//METODO EQUALS DE LA INTERFAZ
        if (obj == null || !(obj instanceof Tarea)) return false;
        //VE SI EL OBJETO EXISTE Y SI ES DETIPO TAREA
        Tarea otra = (Tarea) obj;//NUEVA TAREA
        return titulo.equals(otra.titulo) && prioridad == otra.prioridad;
        //RETORNO DE LA COMPARACION DE TAREAS
    }

    @Override
    public int compareTo(Tarea otra) {
        // COMPARA PRIOIDADES DE LAS TAREAS(A MAYOR NUMERO MENOR PRIORIDAD
        return Integer.compare(this.prioridad, otra.prioridad);
    }
}