package graphlink;

public class Edge<E> {

    protected Vertex<E> refdest;
    protected Integer weight;

    public Edge(Vertex<E> refdest, int weight) {
        this.refdest = refdest;
        this.weight = weight;
    }

    public Edge(Vertex<E> refdest) {
        this(refdest, -1);
    }

    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refdest.equals(e.refdest);
        }
        return false;
    }

    // Métodos adicionales para acceder a refdest y weight desde fuera de la clase
    public Vertex<E> getRefdest() {
        return refdest;
    }

    public int getWeight() {
        return weight;
    }	

    @Override
    public String toString() {
        if (this.weight > -1) {
            return this.refdest.data.toString() + "[" + this.weight + "]";
        }
        return this.refdest.data.toString();
    }
}

