package avl;
import myExceptions.ExceptionNoFound;
import clases.Almacen;
import clases.Producto;


public class Test {

	public static void main(String[] args) throws ExceptionNoFound {
		Almacen nuevo=new Almacen(001, "almacen1", "direccion1");
		Producto producto1=new Producto(1);
		producto1.setDescripcion("Audifonos nueva generaciòn");
		producto1.setStock(100);
		Producto producto2=new Producto(2);
		producto2.setDescripcion("Laptops nueva generaciòn");
		producto1.setStock(50);
		Producto producto3=new Producto(3);
		producto3.setDescripcion("Ropa caballeros 2023");
		producto1.setStock(150);

		nuevo.getAlmacen().insert(producto1);
		nuevo.getAlmacen().inOrden();
		System.out.println("root: " + nuevo.getAlmacen().getRoot());
		nuevo.getAlmacen().insert(producto2);
		nuevo.getAlmacen().inOrden();
		System.out.println("root: " + nuevo.getAlmacen().getRoot());
		nuevo.getAlmacen().insert(producto3);
		nuevo.getAlmacen().inOrden();
		System.out.println("root: " + nuevo.getAlmacen().getRoot());
		nuevo.getAlmacen().remove(producto2);
		nuevo.getAlmacen().inOrden();
		System.out.println("root: " + nuevo.getAlmacen().getRoot());
		nuevo.getAlmacen().insert(producto3);
		nuevo.getAlmacen().inOrden();
		System.out.println("root: " + nuevo.getAlmacen().getRoot());
		nuevo.getAlmacen().getMin();
		nuevo.getAlmacen().getMax();
		
		System.out.println("Avl de enteros PRUEBA");

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
