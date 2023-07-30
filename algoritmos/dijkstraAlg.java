package algoritmos;

import java.util.Arrays;
import Estructuras.GraphLink;
import Estructuras.Par;
import Estructuras.PriorityQueueHeap;
import Estructuras.Vertex;

public class dijkstraAlg<E extends Comparable<E>> {
	private int [] CosteCamino;
	private GraphLink<Vertex<E>> grafo;
	private Vertex<E> origen;
	private int nVert;
	private boolean[] know;
	private final int inf = Integer.MAX_VALUE;
	Par<Integer, Integer> [] misPares; 
	private PriorityQueueHeap<E> myHeap;
	
	public dijkstraAlg(Vertex<E> origen,GraphLink<Vertex<E>> grafo) {
		this.grafo = grafo;
		this.origen = origen;
		this.nVert = grafo.getListVertex().getSize();
		this.misPares = new Par[nVert];
		this.know = new boolean[nVert];
		this.CosteCamino = new int[nVert];
		this.myHeap = new PriorityQueueHeap<>();
		procesar();
	}
	private dijkstraAlg() {
		//prohibido ingresar vacio
	}
	public void procesar() {
        Arrays.fill(CosteCamino, inf);
        	int index = grafo.searchVertexIndex(origen);
//        	int aux=grafo.getListVertex().searchIndex(origen.getData());
        	CosteCamino[index] = 0;
        	this.myHeap.enqueue(origen.getData(), 0);
        }	
}


