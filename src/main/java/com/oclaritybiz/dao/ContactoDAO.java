package com.oclaritybiz.dao;

import com.oclaritybiz.model.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    private final Connection connection;

    public ContactoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Contacto> obtenerContactosPorCompania(int companyId) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE company_id = ?";
        System.out.println("Conexión a BD: " + connection.getMetaData().getURL());
        System.out.println("Ejecutando SQL: " + sql + " con companyId=" + companyId);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, companyId);
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
                    contacto.setLinkedin(resultSet.getString("linkedin"));
                    contacto.setCompanyId(resultSet.getInt("company_id"));
                    contactos.add(contacto);
                }
                System.out.println("Contactos encontrados: " + contactos.size());
                return contactos;
            }
        }
    }
}