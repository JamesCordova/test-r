package estructuras;

public class NodeHeap<T extends Comparable<T>> implements Comparable<NodeHeap<T>> {
    T item;
    int priority;

    public NodeHeap(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }
    public int compareTo(NodeHeap<T> other) {
        return this.priority - other.priority;
    }
}
