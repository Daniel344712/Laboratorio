package controller;

import model.AsociacionDAO;

import model.asociacionModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class AsociacionController
{
    private ConsoleView viewConsole;

    private AsociacionDAO asociacionDAO;

    public AsociacionController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.asociacionDAO = new AsociacionDAO(connection);
    }
    public void agregarAsociacion(int idUsuario, int idRol)
    {

        asociacionModel datos = new asociacionModel(idUsuario,idRol);
        try{
            asociacionDAO.agregarAsociacion(datos);
            viewConsole.showMessage("Se insertaron correctamente los datos");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar los datos " + e.getMessage());
        }

    }
    public void mostrarAsociacion(int idUsuario, int idRol)
    {
        asociacionModel datos = new asociacionModel(idUsuario,idRol);
        try{
                asociacionDAO.mostrarAsociacion(datos);
                viewConsole.showMessage("Mostrando los datos correctamente");
        }catch (SQLException e)
        {
            viewConsole.errorMessage("Hay un error al mostrar los datos " + e.getMessage());
        }
    }
    public void borrarAsociacion(int idasociacion){
        try{
            asociacionDAO.borrarAsociacion(idasociacion);
            viewConsole.showMessage("Se borraron los datos correctamente");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al borrar los datos " + e.getMessage());
        }
    }
    public void actualizarAsociacion(int idUsuario, int idRol, int id){
        asociacionModel datos = new asociacionModel(idUsuario,idRol);
        try{
            asociacionDAO.actualizarAsociacion(datos, id);
            viewConsole.showMessage("Se actualizaron los datos correctamente");
        }catch (SQLException e){
            viewConsole.errorMessage("Error en actualizar los datos " + e.getMessage());
        }
    }

}
