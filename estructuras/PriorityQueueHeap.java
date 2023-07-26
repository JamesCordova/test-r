package estructuras;
public class PriorityQueueHeap<T extends Comparable<T>> {

    private Heap<NodeHeap<T>> heap;

    public PriorityQueueHeap() {
        heap = new Heap<>();
    }

    public void enqueue(T item, int priority) {
        NodeHeap<T> element = new NodeHeap<>(item, priority);
        heap.insert(element);
    }

    public T dequeue() {
        NodeHeap<T> element = heap.remove();
        return element.item;
    }

    public T front() {
        NodeHeap<T> element = heap.remove();
        heap.insert(element);
        return element.item;
    }

    public T back() {
        return heap.remove().item;
    }

    public boolean isEmpty() {
        return true;
    }
}
