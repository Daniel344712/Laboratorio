package controller;

import model.*;
import view.ConsoleView;

import java.beans.PropertyEditorSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class CursoController {

    private ConsoleView viewConsole;

    private CursoDAO cursoDAO;


    public CursoController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.cursoDAO = new CursoDAO(connection);
    }

    public void agregarCurso(String nombre, int estado){
        CursoModel datos = new CursoModel(nombre, estado);

        try
        {
            cursoDAO.agregarCurso(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }



}



























