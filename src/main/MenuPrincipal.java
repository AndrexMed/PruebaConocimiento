package main;

import PruebaConocimiento.dao.DAO;
import static PruebaConocimiento.dao.DAO.eliminarPedido;

import java.util.Scanner;

/**
 *
 * @author giova
 */
public class MenuPrincipal {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            System.out.println("==== MENU ====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear producto");
            System.out.println("3. Crear pedido");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Eliminar producto");
            System.out.println("8. Eliminar pedido");
            System.out.println("9. Salir");
            System.out.println("==============");
            System.out.print("Ingrese una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    DAO.crearCliente(scanner);
                    break;
                case "2":
                    DAO.crearProducto(scanner);
                    break;
                case "3":
                    DAO.crearPedido(scanner);
                    break;
                case "4":
                    DAO.actualizarCliente(scanner);
                    break;
                case "5":
                    DAO.actualizarProducto(scanner);
                    break;
                case "6":
                    DAO.eliminarCliente(scanner);
                    break;
                case "7":
                    DAO.eliminarProducto(scanner);
                    break;
                case "8":
                    eliminarPedido(scanner); // Llamar al nuevo método eliminarPedido
                    break;
                case "9":
                    bandera = false;
                    System.out.println("***** Adios *****");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                    break;
            }

            System.out.println();
        }
    }

}
