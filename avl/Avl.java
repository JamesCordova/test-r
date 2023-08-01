package avl;
import myExceptions.ExceptionNoFound;

public class Avl<E extends Comparable<E>> {
	private NodeAvl<E> root;
	private boolean height;
	private int cont;
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public Avl() {
		this.root = null;
		this.cont=0;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	//Insert for external use
	public void insert(E x) throws ExceptionNoFound {
		this.root = insert(x, this.root);	
		this.height = false;
	}
	
	private NodeAvl<E> insert(E x, NodeAvl<E> current) throws ExceptionNoFound{
		NodeAvl<E> res = current;
		if (current == null) {
			res = new NodeAvl<E>(x);
			this.height = true;
		}
		else {
			int resC = current.getData().compareTo(x);
			if (resC == 0)
				throw new ExceptionNoFound("Elemento ya se encuentra en el arbol");
			if (resC < 0) {
				res.setRight(insert(x, current.getRight()));
				if (this.height) {
					switch(res.getBf()) {
					case -1: res.setBf(0);
							this.height = false;
							break;
					case 0: res.setBf(1);
							break;
					case 1: //res.setBf(2);
							res = balanceToLeft(res);
							this.height = false;
							break;
					}
				}
				
			}
			else {
				res.setLeft(insert(x, current.getLeft()));
				if (this.height) {
					switch(res.getBf()) {
					case -1: //res.setBf(-2);
							res = balanceToRight(res);
							this.height = false;
							break;
					case 0: res.setBf(-1);
							break;
					case 1: res.setBf(0);
							this.height = false;
							break;
					}
				}
			}
		}
		cont++;
		return res;	
	}
	
	private NodeAvl<E> balanceToLeft(NodeAvl<E> node){
		NodeAvl<E> son = node.getRight();
		if (son.getBf() == 1){
			node.setBf(0);
			son.setBf(0);
			node = rotateRSL(node);
		}
		else if (son.getBf() == -1) {
			NodeAvl<E> gSon = son.getLeft();
			switch(gSon.getBf()) {
			case -1: node.setBf(0); son.setBf(-1); break;
			case 0: node.setBf(0); son.setBf(0); break;
			case 1: node.setBf(1); son.setBf(0); break;
			}
			gSon.setBf(0);
			
			node.setRight(rotateRSR(son));
			node = rotateRSL(node);
		}
		return node;
	}
	
	//Balanceo a la derecha
	private NodeAvl<E> balanceToRight(NodeAvl<E> node){
		NodeAvl<E> son = node.getLeft();
		if (son.getBf() == -1){
			node.setBf(0);
			son.setBf(0);
			node = rotateRSR(node);
		}
		else if (son.getBf() == 1) {
			NodeAvl<E> gSon = son.getRight();
			switch(gSon.getBf()) {
			case 1: node.setBf(0); son.setBf(-1); break;
			case 0: node.setBf(0); son.setBf(0); break;
			case -1: node.setBf(1); son.setBf(0); break;
			}
			gSon.setBf(0);
			
			node.setRight(rotateRSL(son));
			node = rotateRSR(node);
		}
		return node;
	}
	
	private NodeAvl<E> rotateRSL(NodeAvl<E> node){
		NodeAvl<E> son = node.getRight();
		node.setRight(son.getLeft());
		son.setLeft(node);
		node = son;
		return node;
	}
	
	private NodeAvl<E> rotateRSR(NodeAvl<E> node){
		NodeAvl<E> son = node.getLeft();
		node.setLeft(son.getRight());
		son.setRight(node);
		node = son;
		return node;
	}

	public E getRoot() {
		return this.root.getData();
	}
	
	// Search for external use
	public E search(E x) throws ExceptionNoFound {
		 NodeAvl<E> aux = search(x, this.root);
		 if (aux == null)
			throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
		 return aux.getData();
	}
	
	private NodeAvl<E> search(E x, NodeAvl<E> current) throws ExceptionNoFound{
		if (current == null) {
			return null;
		}
		else {
			int resC = current.getData().compareTo(x);
			if (resC == 0)
				return current;
			if (resC < 0)
				 return search(x, current.getRight());
			else
				return search(x, current.getLeft());
		}
	}
	
	//Remove for external use
	public void remove(E x) throws ExceptionNoFound {
		this.root = remove(x, this.root);	
	}
	
	private NodeAvl<E> remove(E x, NodeAvl<E> current) throws ExceptionNoFound{
		NodeAvl<E> res = current;
		if (current == null) {
			throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
		}
		else {
			int resC = current.getData().compareTo(x);
			if (resC < 0)
				res.setRight(remove(x, current.getRight()));
			else if (resC > 0)
				res.setLeft(remove(x, current.getLeft()));
			else {
				if (current.getLeft()!= null && current.getRight() != null) {
					//case 3: dos hijos
                		// Encontramos el sucesor inmediato (menor valor en el subárbol derecho)
               			NodeAvl<E> sucesor = getMin(current.getRight());
                		// Reemplazamos el valor del nodo actual con el valor del sucesor
               			current.setData(sucesor.getData());
						// Eliminamos el sucesor del subárbol derecho
                		res.setRight(remove(sucesor.getData(), current.getRight()));
						//Actualizamos el BF del root
						current.setBf(current.getRight().getBf()-current.getLeft().getBf());
				}
				else {
					if (isLeaf(current)) 	//case 1: hoja
						res = null;
					else{ //case 2: solo un hijo
						res = current.getLeft() != null ? current.getLeft() : current.getRight();
					} 
				}
			}
		}
		cont--;
		return res;	
	}

	private boolean isLeaf(NodeAvl<E> current) {
		return current.getLeft() == null && current.getRight() == null;
	}
	
	//Elemento Minimo del arbol avl
	public void getMin() {
		if (isEmpty())
			System.out.println("Arbol esta vacio ....");
		else{
			System.out.println(getMin(this.root).toString());
		}
	}
	private NodeAvl<E> getMin(NodeAvl<E> current) {
		if (current.getLeft() != null)
			getMin(current.getLeft());
		else
			return current;
		return current;
	}
	
	//Elemento Maximo del arbol avl
	public void getMax() {
		if (isEmpty())
			System.out.println("Arbol esta vacio ....");
		else{
			System.out.println(getMax(this.root).toString());
		}
	}
	
	private NodeAvl<E> getMax(NodeAvl<E> current) {
		if (current.getRight() != null)
			getMax(current.getRight());
		else
			return current;
		return current;
	}
	//Obtener el padre de un nodo
	public E parent(E x) {
		NodeAvl<E> aux = parent(x, this.root);
		if (aux == null)
			System.out.println("Arbol esta vacio ....");
		return aux.getData();		
	}
	private NodeAvl<E> parent(E x, NodeAvl<E> current) {
		if(current.getLeft()!=null && current.getRight() != null) {
			int resLeft = current.getLeft().getData().compareTo(x);
			int resRight = current.getRight().getData().compareTo(x);
			if (resLeft == 0 || resRight == 0)
				return current;
			if (resLeft < 0)
				 return parent(x, current.getRight());
			else
				return parent(x, current.getLeft());
		}
		else
			return current;
	}
		
	//Obtener los hijos de un nodo
	public String son(E x) {
		String sonList = son(x, this.root);
		if (isEmpty())
			System.out.println("Arbol esta vacio ....");
		return ""+ sonList;		
	}
		
	private String son(E x, NodeAvl<E> current) {
		String str ="";

		int res = current.getData().compareTo(x);
		if (res == 0 ) {
			if(current.getLeft()!=null && current.getRight() != null)
				return str+ "Hijos: "+current.getLeft().getData() + "," + current.getRight().getData();
			if(current.getLeft()==null && current.getRight() == null)
				return str+ "El Nodo es hoja, no tiene hijos";
			if(current.getLeft()== null)
				return str +"Solo tiene Hijo derecho: "+ current.getRight().getData();
			if(current.getRight()== null)
				return str +"Solo tiene hijo izquierdo: " + current.getLeft().getData();		
			}
		if (res < 0)
			return son(x, current.getRight());
		else
			return son(x, current.getLeft());	
	}	
	
	//Recorrido inorden para mostrar arbol
	public void inOrden() {
		if (isEmpty())
			System.out.println("Arbol esta vacio ....");
		else{
			inOrden(this.root);
			System.out.println();
		}
	}
	
	private void inOrden(NodeAvl<E> current) {
		if (current.getLeft() != null)
			inOrden(current.getLeft());
		System.out.print(current + ", ");
		if (current.getRight()!= null)
			inOrden(current.getRight());
	}

}
