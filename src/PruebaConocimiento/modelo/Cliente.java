package PruebaConocimiento.modelo;

/**
 *
 * @author giova
 */
public class Cliente {
    
    private int clienteID;
    private String nombre;
    private String apellido;
    private String email;

    public Cliente(int nuevoClienteId, String nombre, String apellido, String email) {
        this.clienteID = nuevoClienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
