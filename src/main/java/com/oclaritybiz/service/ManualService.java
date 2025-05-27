package com.oclaritybiz.service;

import com.oclaritybiz.dao.ManualDAO;
import com.oclaritybiz.dao.ManualPageDAO;
import com.oclaritybiz.model.Manual;
import com.oclaritybiz.model.ManualPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ManualService {
    private final ManualDAO manualDAO;
    private final ManualPageDAO manualPageDAO;
    private final Connection connection;

    public ManualService(ManualDAO manualDAO, ManualPageDAO manualPageDAO, Connection connection) {
        this.manualDAO = manualDAO;
        this.manualPageDAO = manualPageDAO;
        this.connection = connection;
    }

    public List<Manual> listarManuales() throws SQLException {
        return manualDAO.listarManuales();
    }

    public Manual obtenerManualPorId(Long id) throws SQLException {
        return manualDAO.obtenerManualPorId(id, manualPageDAO);
    }

    public Long crearManual(Manual manual) throws SQLException {
        return manualDAO.crearManual(manual);
    }

    public boolean actualizarManual(Manual manual) throws SQLException {
        return manualDAO.actualizarManual(manual);
    }

    public boolean eliminarManual(Long id) throws SQLException {
        return manualDAO.eliminarManual(id);
    }

    public List<ManualPage> listarPaginasPorManual(Long manualId) throws SQLException {
        return manualPageDAO.listarPaginasPorManual(manualId);
    }

    public Long crearPagina(ManualPage page, Long manualId) throws SQLException {
        return manualPageDAO.crearPagina(page, manualId);
    }

    public boolean actualizarPagina(ManualPage page) throws SQLException {
        return manualPageDAO.actualizarPagina(page);
    }

    public boolean eliminarPagina(Long id) throws SQLException {
        return manualPageDAO.eliminarPagina(id);
    }

    public boolean crearManualConPaginas(Manual manual, List<ManualPage> pages) throws SQLException {
        String insertManualSQL = "INSERT INTO manual (title, description, status) VALUES (?, ?, 'ACTIVO')";
        String insertPageSQL = "INSERT INTO manual_page (manual_id, image_url, observations, `order`) VALUES (?, ?, ?, ?)";

        try (PreparedStatement manualStmt = connection.prepareStatement(insertManualSQL, Statement.RETURN_GENERATED_KEYS)) {
            manualStmt.setString(1, manual.getTitle());
            manualStmt.setString(2, manual.getDescription());
            manualStmt.executeUpdate();

            try (ResultSet generatedKeys = manualStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int manualId = generatedKeys.getInt(1);

                    try (PreparedStatement pageStmt = connection.prepareStatement(insertPageSQL)) {
                        for (ManualPage page : pages) {
                            pageStmt.setInt(1, manualId);
                            pageStmt.setString(2, page.getImageUrl());
                            pageStmt.setString(3, page.getObservations());
                            pageStmt.setInt(4, page.getOrder());
                            pageStmt.addBatch();
                        }
                        pageStmt.executeBatch();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}