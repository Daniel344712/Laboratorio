package model;

public class asociacionModel {
    private int id;
    private int idUsuario;
    private int idRol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public asociacionModel(int idUsuario, int idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }
}
