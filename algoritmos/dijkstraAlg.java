package algoritmos;

import Estructuras.GraphLink;
import Estructuras.Par;
import Estructuras.Vertex;

public class dijkstraAlg<E> {
	int [] CosteCamino;
	GraphLink<Vertex<E>> grafo;
	Vertex<E> origen;
	Par<Integer, Integer> [] misPares; 
	public dijkstraAlg(Vertex<E> origen,GraphLink<Vertex<E>> grafo) {
		this.grafo = grafo;
		this.origen = origen;
		this.misPares = new Par[grafo.getListVertex().getSize()];
	}
	private dijkstraAlg() {
		//prohibido ingresar vacio
	}
	public void procesar() {
		
	}
}
