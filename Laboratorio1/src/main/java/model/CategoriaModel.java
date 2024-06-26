package model;

public class CategoriaModel {

    private int id;
    private String nombreCategoria;

    public CategoriaModel(int id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaModel(int id) {
        this.id = id;
    }
    public CategoriaModel(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
