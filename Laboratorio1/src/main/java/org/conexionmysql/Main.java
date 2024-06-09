package org.conexionmysql;

import controller.*;
import view.ConsoleView;

import java.sql.Date;

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
        ProductoController productoController = new ProductoController(consoleView);
        PedidoController pedidoController = new PedidoController(consoleView);
        CategoriaController categoriaController = new CategoriaController(consoleView);

        /**
         * Prueba de inserción de datos a la tabla productos_RD
         * */
        String nombreProducto = "Mouse";
        int cantidad = 25;
        int precio = 5000;
        //productoController.agregarProdcuto(nombreProducto, cantidad, precio);
        //productoController.mostrarProdcuto(nombreProducto, cantidad, precio);
        //productoController.eliminarProducto(2);
       // productoController.modificarProducto(1, "Teclado",25, 10000);


        /**
         * Prueba de inserción de datos a la tabla pedidos_RD
         * */
        int idUsuario = 0;
        String fecha = "";
        int total = 0;
        int idSede = 0;
       //pedidoController.agregarPedido(2, "2024-01-05", 5000, 2);
        //pedidoController.modificarPedido(1, 2, "2024-02-01", 12500, 2);
       // pedidoController.eliminarPedido(2);
       //edidoController.mostrarPedido(idUsuario, fecha, total, idSede);

        /**
         * Prueba de inserción de datos a la tabla categorias_RD
         * */
        int idCategoria = 0;
        String nombreCategoria = "";
        //categoriaController.agregarCategoria("Tarjetas de video");
        //categoriaController.modificarCategoria("Mouses", 1);
        //categoriaController.eliminarCategoria(1);
        categoriaController.listarCategorias(nombreCategoria);
    }
}