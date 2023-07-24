package avl;
import myExceptions.ExceptionNoFound;

public class Test {

	public static void main(String[] args) throws ExceptionNoFound {
		Avl<Integer> b = new Avl<Integer>();
		
		b.insert(20);
		b.inOrden();
		b.insert(30);
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert(40);
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert(50);
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert(45);
		b.insert(10);
		b.inOrden();
		b.getMin();
		b.getMax();
		b.remove(10);
		b.inOrden();
		System.out.println("Padre es: " + b.parent(45));
		System.out.println(b.son(30));
		//System.out.println(b.search(44));
	}

}
