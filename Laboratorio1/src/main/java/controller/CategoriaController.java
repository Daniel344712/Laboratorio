package controller;

import model.CategoriaDAO;
import model.CategoriaModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoriaController {

    private ConsoleView viewConsole;
    private CategoriaDAO categoriaDAO;

    public CategoriaController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.categoriaDAO = new CategoriaDAO(connection);
    }

    public void agregarCategoria(String nombreCategoria) {
        CategoriaModel datos = new CategoriaModel(nombreCategoria);

        try{
            categoriaDAO.agregarCategorias(datos);
            viewConsole.showMessage("Insercion de datos correcta acategorias");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al agregar el categoria: "+  e.getMessage());
        }
    }

    public void modificarCategoria(String nombreCategoria, int id) {
        CategoriaModel datos = new CategoriaModel(id, nombreCategoria);

        try{
            categoriaDAO.modificarCategorias(datos);
            viewConsole.showMessage("Modificacion de datos correcta acategorias");
        } catch (SQLException e){
            viewConsole.errorMessage("Error al modificar el categoria: "+ e.getMessage());
        }
    }
    public void eliminarCategoria(int id) {
        CategoriaModel datos = new CategoriaModel(id);

        try{
            categoriaDAO.eliminarCategorias(datos);
            viewConsole.showMessage("Eliminacion de datos correcta acategorias");
        } catch (SQLException e){
            viewConsole.errorMessage("Error al eliminar el categoria: "+  e.getMessage());
        }
    }

    public void listarCategorias(String nombreCategoria) {
        CategoriaModel datos = new CategoriaModel(nombreCategoria);

        try {
            categoriaDAO.mostrarCategorias(datos);
            viewConsole.showMessage("Lista de datos correcta de categorias");
        } catch (SQLException e){
            viewConsole.errorMessage("Error al listar el categoria: "+  e.getMessage());
        }
    }
}
