package com.oclaritybiz.service;

import com.oclaritybiz.dao.ContactoDAO;
import com.oclaritybiz.model.Contacto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContactoService {

    private final ContactoDAO contactoDAO;

    public ContactoService(Connection connection) {
        this.contactoDAO = new ContactoDAO(connection);
    }

    public List<Contacto> obtenerContactosPorCompania(int companyId) throws SQLException {
        return contactoDAO.obtenerContactosPorCompania(companyId);
    }
}