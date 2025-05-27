package com.oclaritybiz.dao;

import com.oclaritybiz.model.Company;
import com.oclaritybiz.model.Usuario;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private final String dbUrl = "jdbc:mysql://localhost:3306/oclaritybiz_bd";
    private final String dbUser = "root";
    private final String dbPass = "";

    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());

    public Usuario getUsuarioPorEmail(String email) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT u.id, u.name, u.password AS storedPassword, u.email, " +
                "c.id AS companyId, c.name AS companyName, c.description AS companyDescription " +
                "FROM users u JOIN companies c ON u.company_id = c.id WHERE u.email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "No se encontró el driver de MySQL", e);
            throw new SQLException("No se encontró el driver de MySQL", e);
        }

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Company company = new Company();
                    company.setId(rs.getInt("companyId"));
                    company.setName(rs.getString("companyName"));
                    company.setDescription(rs.getString("companyDescription"));

                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setName(rs.getString("name"));
                    usuario.setPassword(rs.getString("storedPassword"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setCompany(company);
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener usuario de la base de datos", e);
            throw e;
        }

        return usuario;
    }

    public Integer registrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO users (name, password, email, company_id) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "No se encontró el driver de MySQL", e);
            throw new SQLException("No se encontró el driver de MySQL", e);
        }

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getName());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getCompany().getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return null;
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al registrar usuario en la base de datos", e);
            throw e;
        }
    }
}