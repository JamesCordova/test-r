import dijkstra.Dijkstra;
//import dijkstra.Map;
import graphlink.GraphLink;
import graphlink.Vertex;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        GraphLink<String> grafo = new GraphLink<>();
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        grafo.insertEdge("A", "B", 4);
        grafo.insertEdge("A", "C", 2);
        grafo.insertEdge("B", "C", 5);
        grafo.insertEdge("B", "D", 10);
        grafo.insertEdge("C", "D", 3);
        grafo.insertEdge("D", "E", 7);

        // Imprimir el grafo
        System.out.println("Grafo:");
        System.out.println(grafo);

        // Calcular el camino más corto desde un vértice de origen (A) a todos los demás vértices
        Dijkstra<String> dijkstra = new Dijkstra<>(grafo);
        Vertex<String> origen = grafo.getVertices().searchData(new Vertex<>("A"));
        Map<Vertex<String>, Integer> distancias = dijkstra.calcularCaminoMasCortoDesde(origen);

        // Imprimir las distancias mínimas
        System.out.println("Distancias mínimas desde A a todos los vértices:");
        for (Vertex<String> vertex : distancias.keySet()) {
            System.out.println(vertex.getData() + ": " + distancias.get(vertex));
        }
    }
}
