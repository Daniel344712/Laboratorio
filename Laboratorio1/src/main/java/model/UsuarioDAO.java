package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarUsuario( usuariosModel objeto) throws SQLException {
        String query = "INSERT INTO `usuario_RD`( `apellido`, `cedula`, `nombre`) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getApellido());
            stmt.setString(2, objeto.getCedula());
            stmt.setString(3, objeto.getNombre());
            stmt.executeUpdate();
        }
    }
    public void borrarUsuario(int idusuarios) throws SQLException {
        String query = "DELETE FROM `usuario_RD` WHERE idusuarios = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idusuarios);
            stmt.executeUpdate();
        }
    }

    public void actualizarUsuario(usuariosModel objeto, int id) throws SQLException {
        String query = "UPDATE `usuario_RD` SET `apellido`=?, `cedula`=?, `nombre`=? WHERE idusuarios=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, objeto.getApellido());
            stmt.setString(2, objeto.getCedula());
            stmt.setString(3, objeto.getNombre());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }
    public void mostraUsuario(usuariosModel datos) throws SQLException {
        String query = "SELECT * FROM `usuario_RD`";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String cedula = rs.getString("cedula");
                System.out.println("Nombre del usuario " + nombre + "apellido del usuario " + apellido + "cedula del usuario " + cedula);
            }
        }
    }

}
