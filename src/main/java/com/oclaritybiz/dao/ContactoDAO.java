package com.oclaritybiz.dao;

import com.oclaritybiz.model.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    private final String dbUrl = "jdbc:mysql://localhost:3306/oclaritybiz_bd";
    private final String dbUser = "root";
    private final String dbPass = "";

    private final Connection connection;

    public ContactoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Contacto> obtenerContactosPorUsuario(int userId) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Contacto> contactos = new ArrayList<>();
                while (resultSet.next()) {
                    Contacto contacto = new Contacto();
                    contacto.setId(resultSet.getInt("id"));
                    contacto.setUserId(resultSet.getInt("user_id"));
                    contacto.setName(resultSet.getString("name"));
                    contacto.setSurnames(resultSet.getString("surnames"));
                    contacto.setPhone(resultSet.getString("phone"));
                    contacto.setEmail(resultSet.getString("email"));
                    contacto.setCompanyId(resultSet.getInt("company_id"));
                    contactos.add(contacto);
                }
                return contactos;

            }
        }
    }
}