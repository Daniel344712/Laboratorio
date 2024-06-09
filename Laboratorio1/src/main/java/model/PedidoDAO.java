package model;

import java.sql.*;

public class PedidoDAO {
    private Connection con;

    public PedidoDAO (Connection con) {
        this.con = con;
    }

    public void agregarPedido(PedidoModel pedido) throws SQLException {
        String query = "INSERT INTO `pedidos_RD` (`idusuario`, `fecha`, `total`, `sedeid`) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, pedido.getIdUsuario());
            stmt.setString(2, pedido.getFecha());
            stmt.setDouble(3, pedido.getTotal());
            stmt.setInt(4, pedido.getIdSede());
            stmt.executeUpdate();
        }
    }

    public void mostrarPedido(PedidoModel pedido) throws SQLException {
        String query = "SELECT * FROM `pedidos_RD`";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idusuario");
                Date fecha = rs.getDate("fecha");
                double total = rs.getDouble("total");
                int sedeid = rs.getInt("sedeid");
                System.out.println("Id usuario: "+ idUsuario + " , Fecha del pedido: "+ fecha + " , Total del pedido: "+ total + " Sede id: "+ sedeid );
            }
        }
    }

    public void borrarPedido(PedidoModel pedido) throws SQLException {
        String query = "DELETE FROM `pedidos_RD` WHERE `idpedidos` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, pedido.getId());
            stmt.executeUpdate();
        }
    }
    public void modificarPedido(PedidoModel pedido) throws SQLException {
        String query = "UPDATE `pedidos_RD` SET `idusuario` = ?, `fecha` = ?, `total` = ? , `sedeid` = ? WHERE `idpedidos` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, pedido.getIdUsuario());
            stmt.setString(2, pedido.getFecha());
            stmt.setDouble(3, pedido.getTotal());
            stmt.setInt(4, pedido.getIdSede());
            stmt.setInt(5, pedido.getId());
            stmt.executeUpdate();
        }
    }
}
