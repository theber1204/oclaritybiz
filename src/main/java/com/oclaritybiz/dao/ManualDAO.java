package com.oclaritybiz.dao;

import com.oclaritybiz.model.Manual;
import com.oclaritybiz.model.ManualPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManualDAO {
    private final Connection connection;

    public ManualDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Manual> listarManuales() throws SQLException {
        List<Manual> manuales = new ArrayList<>();
        String sql = "SELECT id, title, description, status FROM manuals";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Manual manual = new Manual();
                manual.setId(rs.getLong("id"));
                manual.setTitle(rs.getString("title"));
                manual.setDescription(rs.getString("description"));
                manual.setStatus(rs.getString("status"));
                // Puedes cargar las páginas aquí si lo necesitas
                manuales.add(manual);
            }
        }
        System.out.println("Manual encontrado: " + manuales.size());
        return manuales;
    }

    public Manual obtenerManualPorId(Long id, ManualPageDAO manualPageDAO) throws SQLException {
        String sql = "SELECT id, title, description, status FROM manuals WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Manual manual = new Manual();
                    manual.setId(rs.getLong("id"));
                    manual.setTitle(rs.getString("title"));
                    manual.setDescription(rs.getString("description"));
                    manual.setStatus(rs.getString("status"));
                    // Cargar páginas asociadas
                    manual.setPages(manualPageDAO.listarPaginasPorManual(manual.getId()));
                    return manual;
                }
            }
        }
        return null;
    }

    public Long crearManual(Manual manual) throws SQLException {
        String sql = "INSERT INTO manuals (title, description, status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, manual.getTitle());
            ps.setString(2, manual.getDescription());
            ps.setString(3, manual.getStatus());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return null;
    }

    public boolean actualizarManual(Manual manual) throws SQLException {
        String sql = "UPDATE manuals SET title = ?, description = ?, status = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, manual.getTitle());
            ps.setString(2, manual.getDescription());
            ps.setString(3, manual.getStatus());
            ps.setLong(4, manual.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminarManual(Long id) throws SQLException {
        String sql = "DELETE FROM manuals WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}