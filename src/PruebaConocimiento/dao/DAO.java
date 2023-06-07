package PruebaConocimiento.dao;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author giova
 */
public class DAO {

    static List<Cliente> clientes = new ArrayList<>();
    static List<Producto> productos = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();

    public static void crearCliente(Scanner scanner) {
        try {
            System.out.println("==== CREAR CLIENTE ====");
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el email del cliente: ");
            String email = scanner.nextLine();

            int nuevoClienteId = clientes.size() + 1;
            Cliente nuevoCliente = new Cliente(nuevoClienteId, nombre, apellido, email);
            clientes.add(nuevoCliente);

            System.out.println("");
            System.out.println("Cliente creado exitosamente con el ID: " + nuevoClienteId);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el Cliente : " + e);
        }
    }

    public static void crearProducto(Scanner scanner) {
        try {
            System.out.println("==== CREAR PRODUCTO ====");
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio;
            try {
                precio = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new RuntimeException("***** Coloque valores validos en precio! *****" + e);
            }
            int nuevoProductoId = productos.size() + 1;
            Producto nuevoProducto = new Producto(nuevoProductoId, nombre, precio);
            productos.add(nuevoProducto);

            System.out.println("");
            System.out.println("Producto creado exitosamente con el ID: " + nuevoProductoId);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto! : " + e);
        }
    }

    public static void crearPedido(Scanner scanner) {
        try {
            System.out.println("==== CREAR PEDIDO ====");
            System.out.print("Ingrese el ID del cliente: ");
            int clienteId = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID del producto: ");
            int productoId = Integer.parseInt(scanner.nextLine());

            Cliente cliente = clientes.stream().filter(c -> c.getClienteID() == clienteId).findFirst().orElse(null);
            Producto producto = productos.stream().filter(p -> p.getProductoID() == productoId).findFirst().orElse(null);

            if (cliente != null && producto != null) {
                int nuevoPedidoId = pedidos.size() + 1;
                Pedido nuevoPedido = new Pedido(nuevoPedidoId, cliente);
                nuevoPedido.agregarProducto(producto);
                pedidos.add(nuevoPedido);

                System.out.println("Pedido creado exitosamente con el ID: " + nuevoPedidoId);
            } else {
                System.out.println("No se pudo crear el pedido. Cliente o producto no encontrados.");
            }
        } catch (Exception e) {
            throw new RuntimeException("***** Error al crear el Pedido *****" + e);
        }
    }

    public static void actualizarCliente(Scanner scanner) {
        try {
            System.out.println("==== ACTUALIZAR CLIENTE ====");
            System.out.print("Ingrese el ID del cliente a actualizar: ");
            int clienteId = Integer.parseInt(scanner.nextLine());

            Cliente cliente = clientes.stream().filter(c -> c.getClienteID() == clienteId).findFirst().orElse(null);

            if (cliente != null) {
                System.out.print("Ingrese el nuevo nombre del cliente: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo apellido del cliente: ");
                String nuevoApellido = scanner.nextLine();
                System.out.print("Ingrese el nuevo email del cliente: ");
                String nuevoEmail = scanner.nextLine();

                cliente.setNombre(nuevoNombre);
                cliente.setApellido(nuevoApellido);
                cliente.setEmail(nuevoEmail);

                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el cliente. Cliente no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("**** Error al intentar actualizar el cliente!! *****" + e);
        }
    }

    public static void actualizarProducto(Scanner scanner) {
        try {
            System.out.println("==== ACTUALIZAR PRODUCTO ====");
            System.out.print("Ingrese el ID del producto a actualizar: ");
            int productoId = Integer.parseInt(scanner.nextLine());

            Producto producto = productos.stream().filter(p -> p.getProductoID() == productoId).findFirst().orElse(null);

            if (producto != null) {
                System.out.print("Ingrese el nuevo nombre del producto: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo precio del producto: ");
                double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);

                System.out.println("Producto actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el producto. Producto no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("***** Error al Actualizar el Producto! *****" + e);
        }
    }

    public static void eliminarCliente(Scanner scanner) {
        try {
            System.out.println("==== ELIMINAR CLIENTE ====");
            System.out.print("Ingrese el ID del cliente a eliminar: ");
            int clienteId = Integer.parseInt(scanner.nextLine());

            Cliente cliente = clientes.stream().filter(c -> c.getClienteID() == clienteId).findFirst().orElse(null);

            if (cliente != null) {
                clientes.remove(cliente);
                System.out.println("Cliente eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el cliente. Cliente no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("***** Error Al Eliminar el Cliente *****" + e);
        }
    }

    public static void eliminarProducto(Scanner scanner) {
        try {
            System.out.println("==== ELIMINAR PRODUCTO ====");
            System.out.print("Ingrese el ID del producto a eliminar: ");
            int productoId = Integer.parseInt(scanner.nextLine());

            Producto producto = productos.stream().filter(p -> p.getProductoID() == productoId).findFirst().orElse(null);

            if (producto != null) {
                productos.remove(producto);
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el producto. Producto no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("***** Error al eliminar el producto!!!!! *****" + e);
        }
    }

    public static void eliminarPedido(Scanner scanner) {
        System.out.println("==== ELIMINAR PEDIDO ====");
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        int pedidoId = Integer.parseInt(scanner.nextLine());

        Pedido pedido = pedidos.stream().filter(p -> p.getPedidoID() == pedidoId).findFirst().orElse(null);

        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el pedido. Pedido no encontrado.");
        }
    }

}
