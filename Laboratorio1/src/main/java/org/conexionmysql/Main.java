package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
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

        /**
         * Prueba de inserción de datos a la tabla productos_RD
         * */
        //String nombreProducto = "Mouse";
        //int cantidad = 20;
       // int precio = 7000;
        //cursoController.agregarProdcuto(nombreProducto, cantidad, precio);
        //cursoController.mostrarProdcuto(nombreProducto, cantidad, precio);
        //cursoController.eliminarProducto(2);
        //cursoController.modificarProducto(1, "Teclado",25, 10000);


        /**
         * Prueba de inserción de datos a la tabla pedidos_RD
         * */


    }
}