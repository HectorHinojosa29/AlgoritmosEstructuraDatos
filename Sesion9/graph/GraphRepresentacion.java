package graph;
//EJERCICIO 6
import java.util.ArrayList;
import java.util.List;

public class GraphRepresentacion<E> {
    private GraphLink<E> graph;

    public GraphRepresentacion(GraphLink<E> graph) {
        this.graph = graph;
    }

    // a) Representación Formal: listado de vértices y aristas
    public void representacionFormal() {
        System.out.println("\n=== REPRESENTACIÓN FORMAL ===");
        
        // Listar vértices
        System.out.println("Vértices (Nodos):");
        List<E> vertices = graph.getVertices();
        for (E v : vertices) {
            System.out.println("- " + v);
        }
        
        // Listar aristas
        System.out.println("\nAristas:");
        for (E v1 : vertices) {
            Vertex<E> vertex = graph.getVertex(v1);
            Edge<E> edge = vertex.listAdj.getFirst();
            while (edge != null) {
                E v2 = edge.getRefDest().getData();
                // Para evitar duplicados en grafo no dirigido (A-B y B-A)
                if (vertices.indexOf(v1) < vertices.indexOf(v2)) {
                    if (edge.getWeight() > -1) {
                        System.out.println("- {" + v1 + ", " + v2 + "} (Peso: " + edge.getWeight() + ")");
                    } else {
                        System.out.println("- {" + v1 + ", " + v2 + "}");
                    }
                }
                edge = vertex.listAdj.getNext();
            }
        }
        System.out.println("=== FIN REPRESENTACIÓN FORMAL ===\n");
    }

    // b) Representación por Lista de Adyacencia
    public void representacionListaAdyacencia() {
        System.out.println("\n=== LISTA DE ADYACENCIA ===");
        List<E> vertices = graph.getVertices();
        
        for (E v : vertices) {
            Vertex<E> vertex = graph.getVertex(v);
            System.out.print(v + " -> ");
            
            Edge<E> edge = vertex.listAdj.getFirst();
            while (edge != null) {
                System.out.print(edge.getRefDest().getData());
                if (edge.getWeight() > -1) {
                    System.out.print("(" + edge.getWeight() + ")");
                }
                edge = vertex.listAdj.getNext();
                if (edge != null) System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("=== FIN LISTA DE ADYACENCIA ===\n");
    }

    // c) Representación por Matriz de Adyacencia
    public void representacionMatrizAdyacencia() {
        System.out.println("\n=== MATRIZ DE ADYACENCIA ===");
        List<E> vertices = graph.getVertices();
        int n = vertices.size();
        
        // Crear matriz n x n
        int[][] matriz = new int[n][n];
        
        // Inicializar matriz con 0s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 0;
            }
        }
        
        // Llenar matriz con 1s donde hay aristas
        for (int i = 0; i < n; i++) {
            E v1 = vertices.get(i);
            Vertex<E> vertex = graph.getVertex(v1);
            Edge<E> edge = vertex.listAdj.getFirst();
            
            while (edge != null) {
                E v2 = edge.getRefDest().getData();
                int j = vertices.indexOf(v2);
                matriz[i][j] = 1;
                edge = vertex.listAdj.getNext();
            }
        }
        
        // Imprimir encabezado de columnas
        System.out.print("   ");
        for (E v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();
        
        // Imprimir matriz
        for (int i = 0; i < n; i++) {
            System.out.print(vertices.get(i) + "  ");
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=== FIN MATRIZ DE ADYACENCIA ===\n");
    }
    
    // EJERCICIO 8
    public static class Test {
        public static void main(String[] args) {
            // Crear un grafo de ejemplo
            GraphLink<String> grafo = new GraphLink<>();
            
            grafo.insertVertex("A");
            grafo.insertVertex("B");
            grafo.insertVertex("C");
            grafo.insertVertex("D");
            
            grafo.insertEdge("A", "B");
            grafo.insertEdge("B", "C");
            grafo.insertEdge("C", "D");
            grafo.insertEdge("D", "A");
            grafo.insertEdgeWeight("A", "C", 5);
            
            // Crear representaciones
            GraphRepresentacion<String> representacion = new GraphRepresentacion<>(grafo);
            
            // Mostrar representaciones
            representacion.representacionFormal();
            representacion.representacionListaAdyacencia();
            representacion.representacionMatrizAdyacencia();
            

        }
    }
}
