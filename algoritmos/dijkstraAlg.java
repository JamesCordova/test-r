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
	private int origenIndex;
	
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
        	int nIteraciones = 0;
        	while(!this.myHeap.isEmpty()&& nIteraciones < grafo.getListVertex().getSize()) {
        		Vertex<E> current = this.myHeap.dequeue();
        		know[nIteraciones] = true;
        		int currentDistance=CosteCamino[grafo.searchVertexIndex(current)];
        		
//        		for (Node<Edge<E>> i = current.getListAdj().getHead();i.getNext()!=null; i=i.getNext()) {
//        			ListLinked<Edge<E>> misVecinos=current.getListAdj();
//					Vertex<E> vecino = misVecinos.getHead().getData().getRefdest();
//					int distP = currentDistance+misVecinos.getHead().getData().getWeight();
//					Edge<E> currentEdge = misVecinos.getHead().getData();
//					if(distP < CosteCamino[grafo.searchVertexIndex(current)]) {
//						CosteCamino[grafo.searchVertexIndex(current)]=distP;
//						myHeap.enqueue(vecino, distP);
//					}
//				}
        		for (Node<Edge<E>> i = current.getListAdj().getHead();i.getNext()!=null; i=i.getNext()) {
        			int j = 0;//se usara como indice del arreglo
        			Vertex<E> vecino = i.getData().getRefdest();
        			int distP = currentDistance + i.getData().getWeight();
        			
        			if (distP < CosteCamino[j]) {
						CosteCamino[j]=distP;
//						know[j] = true;
					}
        			if (know[j]=false) {
        				myHeap.enqueue(vecino,CosteCamino[j]);
					}
        			
        			j++;
				}
        		this.misPares[nIteraciones] = new Par<Integer, Integer>(nIteraciones,currentDistance);
        		nIteraciones++;
        	}
        }
	public void getRutaMin(int nVertice) {
		int viajante=nVertice;
		int distancia = inf;
		int nIteraciones = 0;
		while (distancia!=0) {
			distancia = this.misPares[viajante].getDistance();
			viajante = this.misPares[viajante].getID();
		}
	}
}



