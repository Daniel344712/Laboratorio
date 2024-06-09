package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {

    private Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public void agregarCategorias(CategoriaModel categoria) throws SQLException {
        String query = "INSERT INTO `categorias_RD` (`nombreCategoria`) VALUES (?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.executeUpdate();
        }
    }
    public void mostrarCategorias(CategoriaModel categoria) throws SQLException {
        String query = "SELECT * FROM `categorias_RD`";
        try ( PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                categoria.setNombreCategoria(rs.getString("nombreCategoria"));
                System.out.println("Categoria: " + categoria.getNombreCategoria());
            }
        }
    }
    public void modificarCategorias(CategoriaModel categoria) throws SQLException {
        String query = "UPDATE `categorias_RD` SET `nombreCategoria` = ? WHERE `idcategorias` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        }
    }
    public void eliminarCategorias(CategoriaModel categoria) throws SQLException {
        String query = "DELETE FROM `categorias_RD` WHERE `idcategorias` = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
        }
    }
}
