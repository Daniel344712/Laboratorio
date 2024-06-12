package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolDAO {

    private Connection con;
    public RolDAO(Connection con) {
        this.con = con;
    }

    public void agregarRol(RolModel rol) throws SQLException {
        String query = "INSERT INTO `rol_RD` (`nombre`, `descripcion`) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.executeUpdate();
        }
    }
    public void mostrarRol(RolModel rol) throws SQLException {
        String query = "SELECT * FROM `rol_RD`";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                System.out.println("Nombre: " + rol.getNombre() + "Descripcion: " + rol.getDescripcion());
            }
        }
    }
    public void modificarRol(RolModel rol) throws SQLException {
        String query = "UPDATE `rol_RD` SET `nombre` = ?, `descripcion` = ? WHERE `id` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.setInt(3, rol.getId());
            stmt.executeUpdate();
        }
    }
    public void eliminarRol(RolModel rol) throws SQLException {
        String query = "DELETE FROM `rol_RD` WHERE `id` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, rol.getId());
            stmt.executeUpdate();
        }
    }
}
