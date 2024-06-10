package controller;

import model.PedidoDAO;
import model.PedidoModel;
import model.ProductosDAO;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class PedidoController {

    private ConsoleView viewConsole;
    private PedidoDAO pedidoDAO;

    public PedidoController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.pedidoDAO = new PedidoDAO(connection);

    }
    public void agregarPedido(int idUsuario, String fecha, double total, int idSede){
        PedidoModel datos = new PedidoModel(idUsuario, fecha, total, idSede);

        try
        {
            pedidoDAO.agregarPedido(datos);
            viewConsole.showMessage("Insercion de datos correcta a pedidos");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void mostrarPedido(int idUsuario, String fecha, double total, int idSede){
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

    public void modificarPedido (int id, int idUsuario, String fecha, double total, int idSede){
        PedidoModel datos = new PedidoModel(id, idUsuario, fecha, total, idSede);

        try {
            pedidoDAO.modificarPedido(datos);
            viewConsole.showMessage("Pedido modificado correctamente");

        } catch (SQLException e){
            viewConsole.errorMessage("Error al modificar pedido: " + e.getMessage());
        }
    }
}
