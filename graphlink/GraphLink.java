package graphlink;

import listlinked.ListLinked;
import listlinked.Node;

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
            System.out.println(dataOri + " o " + dataDes + " no existen ....");
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

    public void removeEdge(E dataOri, E dataDes) {
        Vertex<E> vOri = this.listVertex.searchData(new Vertex<E>(dataOri));
        Vertex<E> vDes = this.listVertex.searchData(new Vertex<E>(dataDes));

        if (vOri == null || vDes == null) {
            System.out.println(dataOri + " o " + dataDes + " no existen ...");
        } else {
            Edge<E> eOriDes = new Edge<E>(vDes);
            Edge<E> eDesOri = new Edge<E>(vOri);

            if (vOri.listAdj.search(eOriDes)) {
                vOri.listAdj.remove(eOriDes);
                vDes.listAdj.remove(eDesOri);
                System.out.println("Arista (" + dataOri + "," + dataDes + ") eliminada ...");
            } else {
                System.out.println("Arista (" + dataOri + "," + dataDes + ") no existe ...");
            }
        }

    }

    public void removeVertex(E x) {
        Vertex<E> vRem = this.listVertex.searchData(new Vertex<E>(x));

        if (vRem == null) {
            System.out.println(x + "no existe ...");
        } else {
            // Eliminar todas las aristas conectadas al vértice a eliminar
            for (Node<Vertex<E>> current = this.listVertex.getHead(); current != null; current = current.getNext()) {
                Vertex<E> vertex = current.getData();
                Edge<E> eRem = new Edge<E>(vRem);
                vertex.listAdj.remove(eRem);
            }
            this.listVertex.remove(vRem);
            System.out.println("Vertice (" + x + ") eliminado ...");
        }
    }

    public boolean searchEdge(E vOri, E vDes) {
        Vertex<E> vertexOri = this.listVertex.searchData(new Vertex<E>(vOri));
        Vertex<E> vertexDes = this.listVertex.searchData(new Vertex<E>(vDes));

        if (vertexOri == null || vertexDes == null) {
            // Si alguno de los vértices no existe, la arista no puede existir
            return false;
        } else {
            // Crear una arista con el vértice de destino para buscarla en la lista de adyacencia
            Edge<E> eFind = new Edge<E>(vertexDes);
            // Buscar la arista en la lista de adyacencia del vértice de origen
            return vertexOri.listAdj.search(eFind);
        }
    }

    public boolean searchVertex(E data) {
        for (Node<Vertex<E>> current = this.listVertex.getHead(); current != null; current = current.getNext()) {
            Vertex<E> vertex = current.getData();
            if (vertex.getData().equals(data)) {
                // Se encontró el vértice con el dato deseado
                return true;
            }
        }
        // No se encontró el vértice con el dato deseado
        return false;
    }

    @Override
    public String toString() {
        return this.listVertex.toString();
    }

}
