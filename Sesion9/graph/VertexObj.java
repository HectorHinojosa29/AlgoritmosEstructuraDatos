package graph;
//EJERCICIO 3
class VertexObj<V, E> {
    protected V info;
    protected int position;

    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
    }

    public V getInfo() {
        return info;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Vértice " + position + ": " + info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VertexObj<?, ?> vertexObj = (VertexObj<?, ?>) obj;
        return info.equals(vertexObj.info);
    }
}