package model;

public class usuariosModel {
    private int idusuarios;
    private String apellido;
    private String cedula;

    private String correo;
    private int telefono;
    private String contrasenna;
  private String nombre;

    public usuariosModel(String apellido, String cedula, String nombre, String correo, int telefono, String contrasenna) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenna = contrasenna;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
