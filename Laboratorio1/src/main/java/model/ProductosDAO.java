package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosDAO {
    private  Connection connection;

    public ProductosDAO(Connection connection) {
        this.connection = connection;

    }

    public  void agregarProducto(ProductosModel producto) throws SQLException {
        String query = "INSERT INTO `productos_RD` (`nombreProducto`, `cantidad`, `precio`) VALUES (?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());
            stmt.executeUpdate();
        }

    }

    public void mostrarProductos(ProductosModel datos) throws SQLException {
        String query = "SELECT * FROM `productos_RD`";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString("nombreProducto");
                int cantidad = rs.getInt("cantidad");
                int precio = rs.getInt("precio");
                System.out.println("Nombre del producto: " + nombreProducto + ", Cantidad: " + cantidad + ", Precio: " + precio);
            }
        }
    }

    public void borrarProducto(ProductosModel producto) throws SQLException {
        String query = "DELETE FROM `productos_RD` WHERE `idproductos` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, producto.getId());
            stmt.executeUpdate();
        }
    }
    public void modificarProducto(ProductosModel producto) throws SQLException {
        String query = "UPDATE `productos_RD` SET `nombreProducto` = ?, `cantidad` = ?, `precio` = ? WHERE `idproductos` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getId());
            stmt.executeUpdate();
        }
    }





}
