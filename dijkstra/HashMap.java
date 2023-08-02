package dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josel
 */
class HashMap<K, V> implements Map<K, V> {

    private List<Entry<K, V>>[] hashTable;
    private static final int DEFAULT_CAPACITY = 16;

    public HashMap() {
        hashTable = new List[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        // Implementa aquí tu función de hash para convertir la clave en un índice de la tabla
        // Puedes utilizar el método hashCode() de la clave y hacer alguna operación con el tamaño de la tabla
        return key.hashCode() % hashTable.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }
        for (Entry<K, V> entry : hashTable[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Actualizar el valor si la clave ya existe
                return;
            }
        }
        hashTable[index].add(new Entry<>(key, value)); // Agregar nueva entrada si la clave no existe
    }

    public V get(K key) {
        int index = hash(key);
        if (hashTable[index] != null) {
            for (Entry<K, V> entry : hashTable[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Clave no encontrada
    }

    public Iterable<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (List<Entry<K, V>> bucket : hashTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    // Agregar otros métodos como remove, size, isEmpty, etc.
}
