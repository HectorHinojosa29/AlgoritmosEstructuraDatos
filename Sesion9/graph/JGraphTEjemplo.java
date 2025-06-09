package graph;
//EJERCICIO 4
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.List;
import java.util.Set;

public class JGraphTEjemplo {
    public static void main(String[] args) {
        // Crear un grafo ponderado no dirigido de ciudades peruanas
        Graph<String, DefaultWeightedEdge> grafoPeru = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        // Agregar vértices (ciudades)
        String[] ciudades = {"Lima", "Arequipa", "Cusco", "Trujillo", "Ica", "Puno"};
        for (String ciudad : ciudades) {
            grafoPeru.addVertex(ciudad);
        }
        
        System.out.println("--- CIUDADES (VÉRTICES) ---");
        System.out.println(grafoPeru.vertexSet());
        
        // Agregar aristas con pesos (distancias en km)
        agregarRuta(grafoPeru, "Lima", "Arequipa", 1000);
        agregarRuta(grafoPeru, "Lima", "Ica", 300);
        agregarRuta(grafoPeru, "Lima", "Trujillo", 600);
        agregarRuta(grafoPeru, "Arequipa", "Cusco", 500);
        agregarRuta(grafoPeru, "Cusco", "Puno", 350);
        agregarRuta(grafoPeru, "Cusco", "Ica", 700);
        
        System.out.println("\n--- RUTAS (ARISTAS) CON DISTANCIAS ---");
        for (DefaultWeightedEdge ruta : grafoPeru.edgeSet()) {
            String origen = grafoPeru.getEdgeSource(ruta);
            String destino = grafoPeru.getEdgeTarget(ruta);
            double distancia = grafoPeru.getEdgeWeight(ruta);
            System.out.println(origen + " - " + destino + ": " + distancia + " km");
        }
        
        // Recorrido BFS (usando Dijkstra como ejemplo)
        System.out.println("\n--- CAMINO MÁS CORTO (DIJKSTRA) ---");
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = 
            new DijkstraShortestPath<>(grafoPeru);
        
        GraphPath<String, DefaultWeightedEdge> camino = dijkstra.getPath("Lima", "Puno");
        
        System.out.println("Ruta Lima a Puno: " + camino.getVertexList());
        System.out.println("Distancia total: " + camino.getWeight() + " km");
        
        // Verificar si el grafo es conexo
        System.out.println("\n--- CONECTIVIDAD DEL GRAFO ---");
        ConnectivityInspector<String, DefaultWeightedEdge> inspector = 
            new ConnectivityInspector<>(grafoPeru);
        
        boolean esConexo = inspector.isConnected();
        System.out.println("¿El grafo es conexo? " + (esConexo ? "Sí" : "No"));
        
        // Mostrar componentes conexos
        List<Set<String>> componentes = inspector.connectedSets();
        System.out.println("\nComponentes conexos:");
        for (int i = 0; i < componentes.size(); i++) {
            System.out.println("Componente " + (i+1) + ": " + componentes.get(i));
        }
        
        // Grado de cada vértice
        System.out.println("\n--- GRADO DE CADA CIUDAD ---");
        for (String ciudad : grafoPeru.vertexSet()) {
            int grado = grafoPeru.degreeOf(ciudad);
            System.out.println(ciudad + ": " + grado + " conexión(es)");
        }
    }
    
    // Método auxiliar para agregar rutas con peso
    private static void agregarRuta(Graph<String, DefaultWeightedEdge> grafo, 
                                  String origen, String destino, double distancia) {
        DefaultWeightedEdge edge = grafo.addEdge(origen, destino);
        grafo.setEdgeWeight(edge, distancia);
    }
}