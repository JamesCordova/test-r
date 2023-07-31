package algoritmos;

import java.util.Arrays;

import Estructuras.Edge;
import Estructuras.GraphLink;
import Estructuras.ListLinked;
import Estructuras.Par;
import Estructuras.PriorityQueueHeap;
import Estructuras.Vertex;

public class dijkstraAlg<E extends Comparable<E>> {
	private int [] CosteCamino;
	private GraphLink<E> grafo;
	private Vertex<E> origen;
	private int nVert;
	private boolean[] know;
	private final int inf = Integer.MAX_VALUE;
	Par<Integer, Integer> [] misPares; 
	private PriorityQueueHeap<Vertex<E>> myHeap;
	
	public dijkstraAlg(Vertex<E> origen,GraphLink<E> grafo) {
		this.grafo = grafo;
		this.origen = origen;
		this.nVert = grafo.getListVertex().getSize();
		this.misPares = new Par[nVert];
		this.know = new boolean[nVert];
		this.CosteCamino = new int[nVert];
		this.myHeap = new PriorityQueueHeap<Vertex<E>>();
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
        	this.myHeap.enqueue(origen, 0);
        	while(!this.myHeap.isEmpty()) {
        		Vertex<E> current = this.myHeap.dequeue();
        		int currentDistance=CosteCamino[grafo.searchVertexIndex(current)];
        		
        		for (int i = 0; i < current.getListAdj().getSize(); i++) {
        			ListLinked<Edge<E>> misVecinos=current.getListAdj();
					Vertex<E> vecino = misVecinos.getHead().getData().getRefdest();
					int distP = currentDistance+misVecinos.getHead().getData().getWeight();
					Edge<E> currentEdge = misVecinos.getHead().getData();
					if(distP < CosteCamino[grafo.searchVertexIndex(current)]) {
						CosteCamino[grafo.searchVertexIndex(current)]=distP;
						myHeap.enqueue(vecino, distP);
					}
					
				}
        	}
        }	
}


