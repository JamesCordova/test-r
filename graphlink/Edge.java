package graphlink;

public class Edge<E> {

    private Vertex<E> source;
    private Vertex<E> destination;
    private int weight;

    public Edge(Vertex<E> source, Vertex<E> destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<E> getSource() {
        return source;
    }

    public void setSource(Vertex<E> source) {
        this.source = source;
    }

    public Vertex<E> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<E> destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "(" + source.getData() + "->" + destination.getData() + ", weight: " + weight + ")";
    }

}
