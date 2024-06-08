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

    private  ProductosDAO productosDAO;
    private PedidoDAO pedidoDAO;

    public CursoController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.cursoDAO = new CursoDAO(connection);
        this.productosDAO = new ProductosDAO(connection);
        this.pedidoDAO = new PedidoDAO(connection);
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
    public void agregarProdcuto(String nombreProdcuto, int cantidad, int precio){
        ProductosModel datos = new ProductosModel(nombreProdcuto, cantidad, precio);

        try
        {
            productosDAO.agregarProducto(datos);
            viewConsole.showMessage("Insercion de datos correcta a producto");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void mostrarProdcuto(String nombreProdcuto, int cantidad, int precio){
        ProductosModel datos = new ProductosModel(nombreProdcuto, cantidad, precio);

        try{
            productosDAO.mostrarProductos(datos);
            viewConsole.showMessage("Mostrando datos correcta");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al mostrar datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id){
        ProductosModel datos = new ProductosModel(id);
        datos.setId(id);

        try{
            productosDAO.borrarProducto(datos);
            viewConsole.showMessage("Producto eliminado correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al eliminar producto: " + e.getMessage());
        }
    }
    public void modificarProducto (int id, String nombre, int cantidad, int precio){
        ProductosModel datos = new ProductosModel(id, nombre, cantidad, precio);

        try {
            productosDAO.modificarProducto(datos);
            viewConsole.showMessage("Producto modificado correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al modificar producto: " + e.getMessage());
        }
    }

    public void agregarPedido(int idUsuario, Date fecha, double total, int idSede){
        PedidoModel datos = new PedidoModel(idUsuario, fecha, total, idSede);

        try
        {
            pedidoDAO.agregarPedido(datos);
            viewConsole.showMessage("Insercion de datos correcta a pedidos");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void mostrarPedido(int idUsuario, Date fecha, double total, int idSede){
        PedidoModel datos = new PedidoModel(idUsuario, fecha, total, idSede);

        try{
            pedidoDAO.mostrarPedido(datos);
            viewConsole.showMessage("Mostrando datos correcta");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al mostrar datos: " + e.getMessage());
        }
    }

    public void eliminarPedido(int id){
        PedidoModel datos = new PedidoModel(id);
        datos.setId(id);

        try{
            pedidoDAO.borrarPedido(datos);
            viewConsole.showMessage("Pedido eliminado correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al eliminar pedido: " + e.getMessage());
        }
    }

    public void modificarPedido (int id, int idUsuario, Date fecha, double total, int idSede){
        PedidoModel datos = new PedidoModel(id, idUsuario, fecha, total, idSede);

        try {
            pedidoDAO.modificarPedido(datos);
            viewConsole.showMessage("Pedido modificado correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al modificar pedido: " + e.getMessage());
        }
    }
}



























