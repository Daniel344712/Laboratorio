package controller;

import model.UsuarioDAO;
import model.conexion;
import model.sedesModel;
import model.usuariosModel;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController {
    private ConsoleView viewConsole;

    private UsuarioDAO usuarioDAO;

    public UsuarioController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public void agregarUsuario(String apellido, String cedula, String nombre, String correo, int telefono){
        usuariosModel datos = new usuariosModel(apellido, cedula, nombre, correo, telefono);
        try{
            usuarioDAO.agregarUsuario(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos:" + e.getMessage());
        }
    }
    public void borrarUsuario(int idusuarios) {

      try{
          usuarioDAO.borrarUsuario(idusuarios);
          viewConsole.showMessage("Se borraron los datos correctamente");

      }catch (SQLException e){
          viewConsole.errorMessage("Error al borrar los datos:" + e.getMessage());
      }
    }
    public void actualizarUsuario(String apellido, String cedula, String nombre, String correo, int telefono, int id) {
        usuariosModel datos = new usuariosModel(apellido, cedula, nombre, correo,telefono);
        try {
            usuarioDAO.actualizarUsuario(datos, id);
            viewConsole.showMessage("Se actualizo los datos del usuario");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar los datos del usuario: " + e.getMessage());
        }
    }
    public void mostrarUsuario(String nombre, String apellido, String cedula, String correo, int telefono){
        usuariosModel datos = new usuariosModel(nombre, apellido, cedula,correo,telefono);

        try{
            usuarioDAO.mostraUsuario(datos);
            viewConsole.showMessage("Mostrando datos correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al mostrar datos: " + e.getMessage());
        }
    }
}
