package com.oclaritybiz.dao;

import com.oclaritybiz.model.ManualPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManualPageDAO {
    private final Connection connection;

    public ManualPageDAO(Connection connection) {
        this.connection = connection;
    }

    public List<ManualPage> listarPaginasPorManual(Long manualId) throws SQLException {
        List<ManualPage> paginas = new ArrayList<>();
        String sql = "SELECT id, image_url, observations, `order` FROM manual_page WHERE manual_id = ? ORDER BY `order`";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, manualId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ManualPage page = new ManualPage();
                    page.setId(rs.getLong("id"));
                    page.setImageUrl(rs.getString("image_url"));
                    page.setObservations(rs.getString("observations"));
                    page.setOrder(rs.getInt("order"));
                    paginas.add(page);
                }
            }
        }
        System.out.println("Páginas encontradas: " + paginas.size());
        return paginas;
    }

    public Long crearPagina(ManualPage page, Long manualId) throws SQLException {
        String sql = "INSERT INTO manual_page (manual_id, imageUrl, observations, `order`) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, manualId);
            ps.setString(2, page.getImageUrl());
            ps.setString(3, page.getObservations());
            ps.setInt(4, page.getOrder());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return null;
    }

    public boolean actualizarPagina(ManualPage page) throws SQLException {
        String sql = "UPDATE manual_page SET imageUrl = ?, observations = ?, `order` = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, page.getImageUrl());
            ps.setString(2, page.getObservations());
            ps.setInt(3, page.getOrder());
            ps.setLong(4, page.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminarPagina(Long id) throws SQLException {
        String sql = "DELETE FROM manual_page WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}