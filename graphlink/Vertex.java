package graphlink;

public class Vertex<E> {

    private E data;
    private LinkedList<Edge<E>> edges;

    public Vertex(E data) {
        this.data = data;
        this.edges = new LinkedList<>();
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public LinkedList<Edge<E>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<E>> edges) {
        this.edges = edges;
    }

    public String toString() {
        return data.toString();
    }

}
