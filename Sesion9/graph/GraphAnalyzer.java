package graph;
//EJERCICIO 5
import java.util.List;

public class GraphAnalyzer<E> {
    private GraphLink<E> graph;

    public GraphAnalyzer(GraphLink<E> graph) {
        this.graph = graph;
    }

    // a) Grado de un nodo
    public int gradoNodo(E nodo) {
        return graph.getGrado(nodo);
    }

    // b) Verificar si es un camino (Px)
    public boolean esCamino() {
        List<E> vertices = graph.getVertices();
        int n = vertices.size();
        
        // Un camino tiene exactamente 2 nodos con grado 1 y el resto con grado 2
        int countGrado1 = 0;
        int countGrado2 = 0;
        
        for (E v : vertices) {
            int grado = gradoNodo(v);
            if (grado == 1) countGrado1++;
            else if (grado == 2) countGrado2++;
            else return false; // Si hay algún nodo con grado diferente a 1 o 2
        }
        
        return countGrado1 == 2 && countGrado2 == n - 2 && graph.isConexo();
    }

    // c) Verificar si es un ciclo (Cx)
    public boolean esCiclo() {
        List<E> vertices = graph.getVertices();
        int n = vertices.size();
        
        // Un ciclo tiene todos los nodos con grado 2
        for (E v : vertices) {
            if (gradoNodo(v) != 2) {
                return false;
            }
        }
        
        return graph.isConexo() && (graph.countAristas() == n);
    }

    // d) Verificar si es una rueda (Wx)
    public boolean esRueda() {
        List<E> vertices = graph.getVertices();
        int n = vertices.size();
        
        if (n < 4) return false; // La rueda más pequeña es W3 (3 vértices en el ciclo + 1 centro)
        
        // Buscar el nodo central (debe tener grado n-1)
        E centro = null;
        for (E v : vertices) {
            if (gradoNodo(v) == n - 1) {
                centro = v;
                break;
            }
        }
        
        if (centro == null) return false;
        
        // Verificar que los demás nodos formen un ciclo (grado 3)
        int countGrado3 = 0;
        for (E v : vertices) {
            if (!v.equals(centro)) {
                if (gradoNodo(v) != 3) {
                    return false;
                }
                countGrado3++;
            }
        }
        
        return countGrado3 == n - 1 && graph.isConexo();
    }

    // e) Verificar si es completo (Kx)
    public boolean esCompleto() {
        List<E> vertices = graph.getVertices();
        int n = vertices.size();
        
        // En un grafo completo, cada nodo debe tener grado n-1
        for (E v : vertices) {
            if (gradoNodo(v) != n - 1) {
                return false;
            }
        }
        
        // Verificar número de aristas: n(n-1)/2
        return graph.countAristas() == (n * (n - 1)) / 2;
    }

    // Método principal para identificar el tipo de grafo
    public void identificarTipoGrafo() {
        System.out.println("\n=== ANALIZANDO TIPO DE GRAFO ===");

        if (esCamino()) {
            System.out.println("El grafo es de tipo CAMINO (P" + graph.getVertices().size() + ")");
        } else if (esCiclo()) {
            System.out.println("El grafo es de tipo CICLO (C" + graph.getVertices().size() + ")");
        } else if (esRueda()) {
            System.out.println("El grafo es de tipo RUEDA (W" + graph.getVertices().size() + ")");
        } else if (esCompleto()) {
            System.out.println("El grafo es de tipo COMPLETO (K" + graph.getVertices().size() + ")");
        } else {
            System.out.println("El grafo no coincide con los tipos específicos analizados");
        }

        System.out.println("=== FIN DEL ANÁLISIS ===");
    }

    // EJERCICIO 7
    public static class Test {
        public static void main(String[] args) {
            // Crear un grafo de ejemplo (ciclo C4)
            GraphLink<String> grafo = new GraphLink<>();
            
            grafo.insertVertex("A");
            grafo.insertVertex("B");
            grafo.insertVertex("C");
            grafo.insertVertex("D");
            
            grafo.insertEdge("A", "B");
            grafo.insertEdge("B", "C");
            grafo.insertEdge("C", "D");
            grafo.insertEdge("D", "A");
            
            // Analizar el grafo
            GraphAnalyzer<String> analizador = new GraphAnalyzer<>(grafo);
            analizador.identificarTipoGrafo();
            
            // Probar grado de un nodo
            System.out.println("Grado del nodo A: " + analizador.gradoNodo("A"));
            
            // Crear un grafo completo K3
            GraphLink<String> grafoCompleto = new GraphLink<>();
            grafoCompleto.insertVertex("X");
            grafoCompleto.insertVertex("Y");
            grafoCompleto.insertVertex("Z");
            
            grafoCompleto.insertEdge("X", "Y");
            grafoCompleto.insertEdge("X", "Z");
            grafoCompleto.insertEdge("Y", "Z");
            
            GraphAnalyzer<String> analizadorCompleto = new GraphAnalyzer<>(grafoCompleto);
            analizadorCompleto.identificarTipoGrafo();
        }
    }
}