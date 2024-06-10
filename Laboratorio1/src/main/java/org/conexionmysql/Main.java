package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.SedesController;
import controller.UsuarioController;
import model.usuariosModel;
import view.ConsoleView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Prueba MySQL!");
        ConsoleView viewConsole = new ConsoleView();
        ConsoleView consoleView = new ConsoleView();
        CursoController cursoController = new CursoController(consoleView);

        UsuarioController usuarioController = new UsuarioController(consoleView);
        SedesController sedesController = new SedesController(consoleView);
        String apellido = "Peraza";
        String cedula = "119310559";
        String nombre = "San Jose";
        String localizacion = "orotina";
        int idusuarios = 2;
        int idsede = 2;
      //  usuarioController.agregarUsuario(apellido,cedula,nombre);
       // usuarioController.borrarUsuario(idusuarios);
       // usuarioController.actualizarUsuario(apellido,cedula,nombre,idusuarios);
       //sedesController.agregarSedes(nombre,localizacion);
      // sedesController.actualizarSede(nombre,localizacion, idsede);
       // sedesController.mostrarSede(nombre,localizacion);
        usuarioController.mostrarUsuario(nombre,apellido,cedula);

    }
}