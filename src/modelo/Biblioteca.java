package modelo;

public class Biblioteca {
    private int idbiblioteca;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;
    private String estado;

    public Biblioteca() {
    }

    public Biblioteca(int idbiblioteca, String nombre, String codigo, String direccion, String telefono, String estado) {
        this.idbiblioteca = idbiblioteca;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdbiblioteca() {
        return idbiblioteca;
    }

    public void setIdbiblioteca(int idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
