package dijkstra;

import graphlink.Vertex;

/**
 *
 * @author josel
 */
public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);

    Iterable<K> keySet();

    // Agregar otros métodos como remove, size, isEmpty, etc.
}
