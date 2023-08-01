package clases;

import avl.Avl;
import myExceptions.ExceptionNoFound;

public class Almacen{
    private int codigo;
    private String nombre;
    private String direccion;
    private Avl <Producto> almacen;

    public Almacen(int codigo, String nombre, String direccion){
        this.codigo=codigo;
        this.nombre=nombre;
        this.direccion=direccion;
        this.almacen=new Avl<Producto>();
        
    }

    public void traspasarProductos(Almacen almacen2) throws ExceptionNoFound{
        for(int i=0;i<this.almacen.getCont();i++){
            int temp1=almacen.getRoot().getCode();
            String temp2=almacen.getRoot().getDescripcion();
            int temp3=almacen.getRoot().getStock();
            Producto tempProducto=new Producto(temp1, temp2, temp3);
            almacen2.getAlmacen().insert(tempProducto);
            almacen.remove(almacen.getRoot());
        }
    }

    public Avl<Producto> getAlmacen() {
        return almacen;
    }
    public void setAlmacen(Avl<Producto> almacen) {
        this.almacen = almacen;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String toString(){
        return this.codigo+this.nombre+this.direccion;
    }

}