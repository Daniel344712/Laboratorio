package controller;

import model.RolDAO;
import model.RolModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class RolController {

    private ConsoleView viewConsole;
    private RolDAO rolDAO;

    public RolController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.rolDAO = new RolDAO(connection);
    }

    public void agregarRol (String nombre, String descripcion){
        RolModel datos = new RolModel(nombre, descripcion);
        try{
            rolDAO.agregarRol(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        } catch (SQLException e){
            viewConsole.showMessage("Error al agregar el rol" + e.getMessage());
        }
    }

    public void borarRol (int idRol){
        RolModel datos = new RolModel(idRol);
        try{
            rolDAO.eliminarRol(datos);
            viewConsole.showMessage("Rol eliminado correctamente");
        } catch (SQLException e){
            viewConsole.showMessage("Error al eliminar el rol" + e.getMessage());
        }
    }
    public void modificarRol (int idRol, String nombre, String descripcion){
        RolModel datos = new RolModel(idRol, nombre, descripcion);
        try {
            rolDAO.modificarRol(datos);
            viewConsole.showMessage("Rol modificado correctamente");
        } catch (SQLException e){
            viewConsole.showMessage("Error al modificar el rol" + e.getMessage());
        }
    }
    public void mostrarRol (String nombre, String descripcion){
        RolModel datos = new RolModel(nombre, descripcion);
        try {
            rolDAO.mostrarRol(datos);
            viewConsole.showMessage("Rol mostrado correctamente");
        } catch (SQLException e){
            viewConsole.showMessage("Error al mostrar el rol" + e.getMessage());
        }
    }
}
