package com.oclaritybiz.dao;

import com.oclaritybiz.model.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {

    // Método para obtener todas las compañías desde la tabla "company"
    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT id, name, description FROM company";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setName(rs.getString("name"));
                company.setDescription(rs.getString("description"));
                companies.add(company);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Puedes mejorar el manejo de excepciones según tus necesidades
        }

        return companies;
    }

    // Método de ejemplo para insertar una nueva compañía
    public void createCompany(Company company) {
        String sql = "INSERT INTO company (name, description) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, company.getName());
            ps.setString(2, company.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}