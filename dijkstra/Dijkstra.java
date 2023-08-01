package dijkstra;

import graphlink.Edge;
import graphlink.GraphLink;
import graphlink.Vertex;
import java.util.HashMap;
import java.util.Map;
import listlinked.ListLinked;
import listlinked.Node;
/**
 *
 * @author josel
 */
public class Dijkstra<E> {

    private GraphLink<E> grafo;

    public Dijkstra(GraphLink<E> grafo) {
        this.grafo = grafo;
    }

    public Map<Vertex<E>, Integer> calcularCaminoMasCortoDesde(Vertex<E> origen) {
        // Mapa para almacenar la distancia mínima desde el vértice de origen hasta cada vértice
        Map<Vertex<E>, Integer> distancias = new HashMap<>();

        // Inicializar todas las distancias con infinito excepto el vértice de origen
        for (Vertex<E> vertex : grafo.getVertices().toArrayList()) {
            if (vertex.equals(origen)) {
                distancias.put(vertex, 0);
            } else {
                distancias.put(vertex, Integer.MAX_VALUE);
            }
        }

        // Conjunto para almacenar los vértices visitados
        ListLinked<Vertex<E>> visitados = new ListLinked<>();
        visitados.insertFirst(origen);

        // Calcular la distancia mínima para todos los vértices
        while (!visitados.isEmpty()) {
            Vertex<E> actual = getVerticeMasCercano(distancias, visitados);
            visitados.remove(actual);

            ListLinked<Edge<E>> adyacentes = grafo.getEdges(actual);
            if (adyacentes != null) {
                for (Node<Edge<E>> nodoArista = adyacentes.getHead(); nodoArista != null; nodoArista = nodoArista.getNext()) {
                    Edge<E> arista = nodoArista.getData();
                    Vertex<E> destino = arista.getRefdest();
                    int pesoArista = arista.getWeight();
                    int distanciaAcumulada = distancias.get(actual) + pesoArista;

                    if (distanciaAcumulada < distancias.get(destino)) {
                        distancias.put(destino, distanciaAcumulada);
                        visitados.insertFirst(destino);
                    }
                }
            }
        }

        return distancias;
    }

    private Vertex<E> getVerticeMasCercano(Map<Vertex<E>, Integer> distancias, ListLinked<Vertex<E>> visitados) {
        int distanciaMinima = Integer.MAX_VALUE;
        Vertex<E> verticeMasCercano = null;

        for (Node<Vertex<E>> current = visitados.getHead(); current != null; current = current.getNext()) {
            Vertex<E> vertex = current.getData();
            int distanciaActual = distancias.get(vertex);

            if (distanciaActual < distanciaMinima) {
                distanciaMinima = distanciaActual;
                verticeMasCercano = vertex;
            }
        }

        return verticeMasCercano;
    }
}
