package graphlink;

import listlinked.ListLinked;

public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        this.listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<E>(data);
        if (this.listVertex.search(v)) {
            System.out.println("Vertice con " + data + " ya fue insertado");
        } else {
            this.listVertex.insertFirst(v);
        }
    }

    public void insertEdge(E dataOri, E dataDes) {
        Vertex<E> vOri = this.listVertex.searchData(new Vertex<E>(dataOri));
        Vertex<E> vDes = this.listVertex.searchData(new Vertex<E>(dataDes));

        if (vOri == null || vDes == null) {
            System.out.println(dataOri + " o " + dataDes + "no existen ....");
        } else {
            Edge<E> e = new Edge<E>(vDes);
            if (vOri.listAdj.search(e)) {
                System.out.println("Arista (" + dataOri + "," + dataDes + ") ya fue insertada ...");
            } else {
                vOri.listAdj.insertFirst(e);
                vDes.listAdj.insertFirst(new Edge<E>(vOri));
            }
        }

    }

    @Override
    public String toString() {
        return this.listVertex.toString();
    }
}
