package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class SedesController {
    private ConsoleView viewConsole;

    private SedesDAO sedesDAO;

    public SedesController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.sedesDAO = new SedesDAO(connection);
    }
    public void agregarSedes(String nombre, String localizacion){
        sedesModel datos = new sedesModel(nombre, localizacion);

            try{
                sedesDAO.agregarSede(datos);
                viewConsole.showMessage("Insercion de datos correcta");
            }catch (SQLException e){
                viewConsole.errorMessage("Error al insertar datos:" + e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
    public void borrarSedes(int idsede){
        try{
            sedesDAO.borrarSede(idsede);
            viewConsole.showMessage("Se borraron los datos correctamente");

        }catch (SQLException e){
            viewConsole.errorMessage("Error al borrar los datos:" + e.getMessage());
        }
    }
    public void actualizarSede(String nombre,String localizacion, int idsede) {
        sedesModel datos = new sedesModel(nombre, localizacion);
        try {
            sedesDAO.actualizarSede(datos, idsede);
            viewConsole.showMessage("Se actualizo los datos del usuario");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar los datos del usuario: " + e.getMessage());
        }
    }
    public void mostrarSede(String nombre, String localizacion){
        sedesModel datos = new sedesModel(nombre, localizacion);

        try{
            sedesDAO.mostrarSedes(datos);
            viewConsole.showMessage("Mostrando datos correcta");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al mostrar datos: " + e.getMessage());
        }
    }
}
