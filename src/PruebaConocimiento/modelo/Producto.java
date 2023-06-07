package PruebaConocimiento.modelo;

/**
 *
 * @author giova
 */
public class Producto {

    private int productoID;
    private String nombre;
    private double precio;

    public Producto(int nuevoProductoId, String nombre, double precio) {
        this.productoID = nuevoProductoId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
