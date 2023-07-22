package clases;

public class Almacen{
    private String codigo;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String direccion;
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Almacen(String codigo, String nombre, String direccion){
        this.codigo=codigo;
        this.nombre=nombre;
        this.direccion=direccion;
    }
    public String toString(){
        return this.codigo+ this.nombre+this.direccion;
    }

}