package com.oclaritybiz.dao;

import com.oclaritybiz.model.Module;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleDAO {

    private final String dbUrl = "jdbc:mysql://localhost:3306/oclaritybiz_bd";
    private final String dbUser = "root";
    private final String dbPass = "";

    private static final Logger LOGGER = Logger.getLogger(ModuleDAO.class.getName());

    public List<Module> getModulesByUserId(long userId) throws SQLException {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT id, name, icon, link, status FROM modules WHERE user_id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "No se encontró el driver de MySQL", e);
            throw new SQLException("No se encontró el driver de MySQL", e);
        }

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Module module = new Module();
                    module.setId(rs.getString("id"));
                    module.setName(rs.getString("name"));
                    module.setIcon(rs.getString("icon"));
                    module.setLink(rs.getString("link"));
                    module.setStatus(rs.getString("status"));
                    modules.add(module);
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener módulos de la base de datos", e);
            throw e;
        }

        return modules;
    }
}