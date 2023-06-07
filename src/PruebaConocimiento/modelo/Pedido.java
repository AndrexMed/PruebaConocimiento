package PruebaConocimiento.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class Pedido {

    private int pedidoID;
    private Cliente cliente;
    private List<Producto> productos;

    public Pedido(int nuevoPedidoId, Cliente cliente) {
        this.pedidoID = nuevoPedidoId;
        this.cliente = cliente;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        if (productos == null) {
            productos = new ArrayList<>();
        }
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        if (productos != null) {
            productos.remove(producto);
        }
    }

}
