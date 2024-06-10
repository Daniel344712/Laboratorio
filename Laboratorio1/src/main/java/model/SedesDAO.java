package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SedesDAO {
    private Connection connection;

    public SedesDAO(Connection connection){
        this.connection = connection;
    }
    public  void agregarSede(sedesModel objeto) throws  Exception{
        String query = "INSERT INTO `sedes_RD`( `nombre`, `localizacion`) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getLocalizacion());
            stmt.executeUpdate();
        }
    }
    public void borrarSede(int idsede) throws SQLException {
        String query = "DELETE FROM `sedes_RD` WHERE idsede = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idsede);
            stmt.executeUpdate();
        }
    }
    public void actualizarSede(sedesModel objeto, int idsede) throws SQLException {
        String query = "UPDATE `sedes_RD` SET `nombre`=?, `localizacion`=? WHERE idsede=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getLocalizacion());
            stmt.setInt(3, idsede);
            stmt.executeUpdate();
        }
    }
    public void mostrarSedes(sedesModel datos) throws SQLException {
        String query = "SELECT * FROM `sedes_RD`";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String localizacion = rs.getString("localizacion");
                System.out.println("Nombre de la sede " + nombre +"localizacion " + localizacion);
            }
        }
    }
}
