package graph;
//EJERCICIO 3
import java.util.ArrayList;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<VertexObj<V, E>>();
        this.secEdge = new ArrayList<EdgeObj<V, E>>();
    }

    // Método para insertar un vértice
    public void insertVertex(V data) {
        if (!searchVertex(data)) {
            VertexObj<V, E> newVertex = new VertexObj<V, E>(data, secVertex.size());
            secVertex.add(newVertex);
        }
    }

    // Método para insertar una arista
    public void insertEdge(V verOri, V verDes, E info) {
        VertexObj<V, E> vertexOri = getVertex(verOri);
        VertexObj<V, E> vertexDes = getVertex(verDes);
        
        if (vertexOri != null && vertexDes != null && !searchEdge(verOri, verDes)) {
            EdgeObj<V, E> newEdge = new EdgeObj<V, E>(vertexOri, vertexDes, info, secEdge.size());
            secEdge.add(newEdge);
        }
    }

    // Método para buscar un vértice
    public boolean searchVertex(V data) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(data)) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para obtener un vértice
    private VertexObj<V, E> getVertex(V data) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    // Método para buscar una arista
    public boolean searchEdge(V verOri, V verDes) {
        VertexObj<V, E> vertexOri = getVertex(verOri);
        VertexObj<V, E> vertexDes = getVertex(verDes);
        
        if (vertexOri != null && vertexDes != null) {
            for (EdgeObj<V, E> edge : secEdge) {
                if ((edge.getEndVertex1().equals(vertexOri) && edge.getEndVertex2().equals(vertexDes)) ||
                    (edge.getEndVertex1().equals(vertexDes) && edge.getEndVertex2().equals(vertexOri))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para recorrido en anchura (BFS)
    public void bfs(V startData) {
        VertexObj<V, E> startVertex = getVertex(startData);
        if (startVertex == null) return;

        ArrayList<VertexObj<V, E>> visited = new ArrayList<>();
        ArrayList<VertexObj<V, E>> queue = new ArrayList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("Recorrido BFS desde " + startData + ": ");

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.remove(0);
            System.out.print(current.getInfo() + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;
                if (edge.getEndVertex1().equals(current)) {
                    neighbor = edge.getEndVertex2();
                } else if (edge.getEndVertex2().equals(current)) {
                    neighbor = edge.getEndVertex1();
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vértices:\n");
        for (VertexObj<V, E> vertex : secVertex) {
            sb.append(vertex.toString()).append("\n");
        }
        sb.append("\nAristas:\n");
        for (EdgeObj<V, E> edge : secEdge) {
            sb.append(edge.toString()).append("\n");
        }
        return sb.toString();
    }
}