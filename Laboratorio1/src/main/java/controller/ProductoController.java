package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductoController {

    private ConsoleView viewConsole;
    private ProductosDAO productosDAO;

    public ProductoController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();

        this.productosDAO = new ProductosDAO(connection);
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
}
