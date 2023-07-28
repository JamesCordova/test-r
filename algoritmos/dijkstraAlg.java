package algoritmos;

import java.util.Arrays;
import Estructuras.GraphLink;
import Estructuras.Par;
import Estructuras.Vertex;

public class dijkstraAlg<E> {
	private int [] CosteCamino;
	private GraphLink<Vertex<E>> grafo;
	private Vertex<E> origen;
	private int nVert;
	private boolean[] know;
	private final int inf = Integer.MAX_VALUE;
	
	
	Par<Integer, Integer> [] misPares; 
	public dijkstraAlg(Vertex<E> origen,GraphLink<Vertex<E>> grafo) {
		this.grafo = grafo;
		this.origen = origen;
		this.nVert = grafo.getListVertex().getSize();
		this.misPares = new Par[nVert];
		this.know = new boolean[nVert];
		this.CosteCamino = new int[nVert];
		procesar();
	}
	private dijkstraAlg() {
		//prohibido ingresar vacio
	}
	public void procesar() {
        Arrays.fill(CosteCamino, inf);
//        int aux=grafo.getListVertex().searchIndex(origen.getData());
//        CosteCamino[aux] = 0;
	}
}

