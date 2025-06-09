package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import ListLinked.ListLinked;

public class GraphLink<E> {
	//ACTIVIDAD 2
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    // Método para insertar un vértice
    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<E>(data);
        if (!searchVertex(data)) {
            listVertex.insert(newVertex);
        }
    }

    // Método para insertar una arista no ponderada
    public void insertEdge(E verOri, E verDes) {
        insertEdgeWeight(verOri, verDes, -1);
    }


    // Método para buscar un vértice
    public boolean searchVertex(E data) {
        Vertex<E> aux = listVertex.getFirst();
        while (aux != null) {
            if (aux.getData().equals(data)) {
                return true;
            }
            aux = listVertex.getNext();
        }
        return false;
    }

    // Método para obtener un vértice
    public Vertex<E> getVertex(E data) {
        Vertex<E> aux = listVertex.getFirst();
        while (aux != null) {
            if (aux.getData().equals(data)) {
                return aux;
            }
            aux = listVertex.getNext();
        }
        return null;
    }

    // Método para buscar una arista
    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = getVertex(verOri);
        Vertex<E> vertexDes = getVertex(verDes);
        
        if (vertexOri != null && vertexDes != null) {
            Edge<E> edge = new Edge<E>(vertexDes);
            return vertexOri.listAdj.search(edge);
        }
        return false;
    }

    // Método para eliminar un vértice
    public void removeVertex(E data) {
        Vertex<E> vertexToRemove = getVertex(data);
        if (vertexToRemove != null) {
            // Primero eliminamos todas las aristas que apuntan a este vértice
            Vertex<E> currentVertex = listVertex.getFirst();
            while (currentVertex != null) {
                if (!currentVertex.equals(vertexToRemove)) {
                    Edge<E> edge = new Edge<E>(vertexToRemove);
                    currentVertex.listAdj.remove(edge);
                }
                currentVertex = listVertex.getNext();
            }
            
            // Luego eliminamos el vértice de la lista
            listVertex.remove(vertexToRemove);
        }
    }

    // Método para eliminar una arista
    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = getVertex(verOri);
        Vertex<E> vertexDes = getVertex(verDes);
        
        if (vertexOri != null && vertexDes != null) {
            Edge<E> edgeOri = new Edge<E>(vertexDes);
            Edge<E> edgeDes = new Edge<E>(vertexOri);
            
            vertexOri.listAdj.remove(edgeOri);
            vertexDes.listAdj.remove(edgeDes);
        }
    }

    // Método para recorrido en profundidad (DFS)
    public void dfs(E startData) {
        Vertex<E> startVertex = getVertex(startData);
        if (startVertex != null) {
            ListLinked<Vertex<E>> visited = new ListLinked<Vertex<E>>();
            dfsRecursive(startVertex, visited);
            System.out.println();
        }
    }

    private void dfsRecursive(Vertex<E> current, ListLinked<Vertex<E>> visited) {
        System.out.print(current.getData() + " ");
        visited.insert(current);
        
        Edge<E> edge = current.listAdj.getFirst();
        while (edge != null) {
            Vertex<E> neighbor = edge.getRefDest();
            if (!visited.search(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
            edge = current.listAdj.getNext();
        }
    }

    // Método toString para representación del grafo
    public String toString() {
        return this.listVertex.toString();
    }
    //--------------------------------------------------------------------------------------------------
 //EJERCICIO1
 // EJERCICIO 1a: Implementación del recorrido en anchura (BFS)
    public void bfs(E startData) {
        Vertex<E> startVertex = getVertex(startData);
        if (startVertex == null) return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.insert(startVertex);

        System.out.print("Recorrido BFS desde " + startData + ": ");

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            Edge<E> edge = current.listAdj.getFirst();
            while (edge != null) {
                Vertex<E> neighbor = edge.getRefDest();
                if (!visited.search(neighbor)) {
                    visited.insert(neighbor);
                    queue.add(neighbor);
                }
                edge = current.listAdj.getNext();
            }
        }
        System.out.println();
    }

    // EJERCICIO 1b: Implementación de BFS para encontrar camino entre dos vértices
    public ArrayList<E> bfsPath(E startData, E endData) {
        Vertex<E> startVertex = getVertex(startData);
        Vertex<E> endVertex = getVertex(endData);
        ArrayList<E> path = new ArrayList<>();

        if (startVertex == null || endVertex == null) return path;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        java.util.HashMap<Vertex<E>, Vertex<E>> parentMap = new java.util.HashMap<>();

        queue.add(startVertex);
        visited.insert(startVertex);
        parentMap.put(startVertex, null);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            Vertex<E> current = queue.poll();

            if (current.equals(endVertex)) {
                found = true;
                break;
            }

            Edge<E> edge = current.listAdj.getFirst();
            while (edge != null) {
                Vertex<E> neighbor = edge.getRefDest();
                if (!visited.search(neighbor)) {
                    visited.insert(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
                edge = current.listAdj.getNext();
            }
        }

        // Reconstruir el camino si se encontró
        if (found) {
            Vertex<E> current = endVertex;
            while (current != null) {
                path.add(0, current.getData());
                current = parentMap.get(current);
            }
        }

        return path;
    }
    //---------------------------------------------------------------------------------------------------
 // EJERCICIO 2a: Insertar arista con peso
    public void insertEdgeWeight(E verOri, E verDes, int weight) {
        Vertex<E> vertexOri = getVertex(verOri);
        Vertex<E> vertexDes = getVertex(verDes);
        
        if (vertexOri != null && vertexDes != null) {
            Edge<E> edgeOri = new Edge<E>(vertexDes, weight);
            Edge<E> edgeDes = new Edge<E>(vertexOri, weight);
            
            // Eliminar aristas existentes entre estos vértices para evitar duplicados
            vertexOri.listAdj.remove(edgeOri);
            vertexDes.listAdj.remove(edgeDes);
            
            // Insertar las nuevas aristas con peso
            vertexOri.listAdj.insert(edgeOri);
            vertexDes.listAdj.insert(edgeDes);
        }
    }

    // EJERCICIO 2b: Encontrar el camino más corto (usando Dijkstra)
    public ArrayList<E> shortPath(E startData, E endData) {
        Vertex<E> startVertex = getVertex(startData);
        Vertex<E> endVertex = getVertex(endData);
        ArrayList<E> path = new ArrayList<>();

        if (startVertex == null || endVertex == null) {
            return path;
        }

        // Estructuras para Dijkstra
        HashMap<Vertex<E>, Integer> distances = new HashMap<>();
        HashMap<Vertex<E>, Vertex<E>> previous = new HashMap<>();
        PriorityQueue<VertexDistance<E>> queue = new PriorityQueue<>();

        // Inicialización
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            if (current.equals(startVertex)) {
                distances.put(current, 0);
            } else {
                distances.put(current, Integer.MAX_VALUE);
            }
            previous.put(current, null);
            queue.add(new VertexDistance<E>(current, distances.get(current)));
            current = listVertex.getNext();
        }

        // Algoritmo de Dijkstra
        while (!queue.isEmpty()) {
            VertexDistance<E> vd = queue.poll();
            Vertex<E> u = vd.vertex;

            Edge<E> edge = u.listAdj.getFirst();
            while (edge != null) {
                Vertex<E> v = edge.getRefDest();
                int alt = distances.get(u) + edge.getWeight();
                if (alt < distances.get(v)) {
                    distances.put(v, alt);
                    previous.put(v, u);
                    // Actualizar la prioridad en la cola
                    queue.remove(new VertexDistance<E>(v, 0));
                    queue.add(new VertexDistance<E>(v, alt));
                }
                edge = u.listAdj.getNext();
            }
        }

        // Reconstruir el camino si existe
        if (previous.get(endVertex) != null || endVertex.equals(startVertex)) {
            Stack<E> stack = new Stack<>();
            Vertex<E> step = endVertex;
            while (step != null) {
                stack.push(step.getData());
                step = previous.get(step);
            }
            while (!stack.isEmpty()) {
                path.add(stack.pop());
            }
        }

        return path;
    }

    // Clase auxiliar para Dijkstra
    private static class VertexDistance<E> implements Comparable<VertexDistance<E>> {
        Vertex<E> vertex;
        int distance;

        public VertexDistance(Vertex<E> vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<E> other) {
            return Integer.compare(this.distance, other.distance);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            VertexDistance<?> that = (VertexDistance<?>) obj;
            return vertex.equals(that.vertex);
        }
    }

    // EJERCICIO 2c: Verificar si el grafo es conexo
    public boolean isConexo() {
        if (listVertex.isEmpty()) {
            return true; // Grafo vacío se considera conexo
        }

        // Tomamos el primer vértice para iniciar el DFS
        Vertex<E> startVertex = listVertex.getFirst();
        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsRecursive(startVertex, visited);

        // Verificamos si todos los vértices fueron visitados
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            if (!visited.search(current)) {
                return false;
            }
            current = listVertex.getNext();
        }

        return true;
    }

    // EJERCICIO 2d: Implementación de Dijkstra que retorna un Stack
    public Stack<E> Dijsktra(E startData, E endData) {
        ArrayList<E> path = shortPath(startData, endData);
        Stack<E> stack = new Stack<>();
        for (E data : path) {
            stack.push(data);
        }
        return stack;
    }
    //---------------------------------------------------------------------------------------------------
    //EJERCICIO 5	
    // Método para obtener el grado de un nodo
    public int getGrado(E data) {
        Vertex<E> vertex = getVertex(data);
        if (vertex == null) return -1;
        
        int grado = 0;
        Edge<E> edge = vertex.listAdj.getFirst();
        while (edge != null) {
            grado++;
            edge = vertex.listAdj.getNext();
        }
        return grado;
    }

    // Método para contar aristas
    public int countAristas() {
        int count = 0;
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            Edge<E> edge = current.listAdj.getFirst();
            while (edge != null) {
                count++;
                edge = current.listAdj.getNext();
            }
            current = listVertex.getNext();
        }
        return count / 2; // Porque es no dirigido
    }

    // Método para obtener todos los nodos
    public List<E> getVertices() {
        List<E> vertices = new ArrayList<>();
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            vertices.add(current.getData());
            current = listVertex.getNext();
        }
        return vertices;
    }
    //---------------------------------------------------------------------------------------------------
 //EJERCICIO 9
 // EJERCICIO 9a: Verificar si el grafo es isomorfo con otro grafo
    public boolean isIsomorfo(GraphLink<E> otherGraph) {
        // Verificar si tienen el mismo número de vértices y aristas
        if (this.listVertex.size() != otherGraph.listVertex.size() || 
            this.countAristas() != otherGraph.countAristas()) {
            return false;
        }

        // Obtener secuencias de grados y comparar
        List<Integer> thisDegrees = getDegreeSequence();
        List<Integer> otherDegrees = otherGraph.getDegreeSequence();

        return thisDegrees.equals(otherDegrees);
    }

    private List<Integer> getDegreeSequence() {
        List<Integer> degrees = new ArrayList<>();
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            degrees.add(getGrado(current.getData()));
            current = listVertex.getNext();
        }
        degrees.sort(null);
        return degrees;
    }

    // EJERCICIO 9b: Verificar si el grafo es plano
    public boolean isPlano() {
        // Usando la fórmula de Euler para grafos planos: V - E + F = 2
        // Para grafos conexos, si E <= 3V - 6 entonces es plano
        int V = listVertex.size();
        int E = countAristas();
        
        if (V < 3) return true; // Grafos pequeños son siempre planos
        
        return E <= (3 * V - 6);
    }

    // EJERCICIO 9c: Verificar si el grafo es conexo(DESARROLLADO ARRIBA)
    

    // EJERCICIO 9d: Verificar si el grafo es auto-complementario
    public boolean isAutoComplementario() {
        // Crear el grafo complementario
        GraphLink<E> complement = new GraphLink<>();
        
        // Insertar todos los vértices
        Vertex<E> current = listVertex.getFirst();
        while (current != null) {
            complement.insertVertex(current.getData());
            current = listVertex.getNext();
        }
        
        // Insertar aristas que no existen en el grafo original
        List<E> vertices = getVertices();
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                E v1 = vertices.get(i);
                E v2 = vertices.get(j);
                if (!searchEdge(v1, v2)) {
                    complement.insertEdge(v1, v2);
                }
            }
        }
        
        // Verificar isomorfismo entre el grafo original y su complemento
        return this.isIsomorfo(complement);
    }

}