package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsociacionDAO {
    private Connection con;

    public AsociacionDAO(Connection con) {
        this.con = con;
    }

    public void agregarAsociacion(asociacionModel objeto) throws SQLException{
        String query = "INSERT INTO `asociacion_RD`( `idUsuario`,`idRol`) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, objeto.getIdUsuario());
            stmt.setInt(2, objeto.getIdRol());
            stmt.executeUpdate();
        }
    }

    public void mostrarAsociacion(asociacionModel objeto) throws SQLException{
        String query = "SELECT * FROM `asociacion_RD`";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = 0;
                int idRol = 0;
                rs.getString("idUsuario");
                rs.getString("idRol");
                System.out.println("El id del usuario es " + idUsuario + "y el id del Rol es " + idRol);
            }
        }
    }

    public void borrarAsociacion(int id) throws SQLException {
        String query = "DELETE FROM `asociacion_RD` WHERE idasociacion= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public void actualizarAsociacion(asociacionModel objeto, int id) throws SQLException{
        String query = "UPDATE `asociacion` SET `idUsuario`=?, `idRol`=? WHERE idusuarios=?";
        try(PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, objeto.getIdUsuario());
            stmt.setInt(2, objeto.getIdRol());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }
}
