package clases;

public class Producto implements Comparable<Producto>{
	private int code;
	private String descripcion;
	private int stock;
	public Producto(int code, String desc, int stock) {
		this.code=code;
		this.descripcion=desc;
		this.stock= stock;
	}
	public Producto(int code) {
		this(code, " ", 1);
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return this.code-o.getCode();
	}
	public String toString (){
		return this.descripcion;
	}
}
