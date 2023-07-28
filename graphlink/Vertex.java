package graphlink;

import listlinked.ListLinked;

public class Vertex<E> {

    protected E data;
    protected ListLinked<Edge<E>> listAdj;
    public int indexPosition;

    public Vertex(E data) {
        this.data = data;
        this.listAdj = new ListLinked<Edge<E>>();
        this.indexPosition = -1;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.data + " -->\t " + this.listAdj.toString() + "\n";
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
