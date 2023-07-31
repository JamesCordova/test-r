package graphlink;

public class Edge<E extends Comparable<E>> implements Comparable<Integer> {

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

    @Override
    public String toString() {
        if (this.weight > -1) {
            return this.refdest.data.toString() + "[" + this.weight + "]";
        }
        return this.refdest.data.toString();
    }

	@Override
	public int compareTo(Integer peso) {
			return this.weight-peso;
	}
    public Vertex<E> getRefdest() {
		return refdest;
	}

	public Integer getWeight() {
		return weight;
	}
}

