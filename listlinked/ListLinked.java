package listlinked;

public class ListLinked<E> {
	public Node<E> head;
	private int size;
	
	// Constructors
	public ListLinked() {
		this.head = null;
		this.size = 0;
	}
	
	// Methods
	public boolean isEmpty() {
		return this.head == null; 
	}
	
	public boolean search(E x) {
		Node<E> aux = this.head;
		for(; aux != null; aux = aux.getNext()) {
			if (aux.getData().equals(x)) {
				return true;
			}
		}
		return false;
	}

	public E searchData(E x) {
		Node<E> aux = this.head;
		for(; aux != null; aux = aux.getNext()) {
			if (aux.getData().equals(x)) {
				return aux.getData();
			}
		}
		return null;
	}
	
	public void insertFirst(E x) {
		this.head = new Node<E>(x, this.head);
		this.size++;
	}
	
	public void insertLast(E x) {
		if (this.isEmpty()) {
			this.insertFirst(x);
		}
		else {
			Node <E> aux = this.head;
			while (aux != null && aux.getNext() != null)
				aux = aux.getNext(); 
			if (aux != null) {// no es if(aux.getNext == null) ?
				aux.setNext(new Node<E> (x));
				this.size++;
			}
		}
	}
	
	public void remove(E x) {
		if (this.head != null && this.head.getData().equals(x)) { 
			this.head = this.head.getNext();
			this.size--;
		}
		else {
			Node<E> aux = this.head;
			while (aux.getNext() != null && !aux.getNext().getData().equals(x)) {
				aux = aux.getNext();
			}
			if (aux.getNext()!= null) {// duda
				aux.setNext(aux.getNext().getNext());
				this.size++;
			}
		}
	}

	public Node<E> getHead() {
        	return this.head;
    	}

   	public void setHead(Node<E> head) {
        	this.head = head;
    	}
	public int getSize() {
		return this.size;
	}
	// ToString
	public String toString() {
		String str = "";
		for(Node<E> aux = this.head; aux != null; aux = aux.getNext()) { 
			str = str + aux.toString() + ", "; 
		}
		return str;
	}
    
}
