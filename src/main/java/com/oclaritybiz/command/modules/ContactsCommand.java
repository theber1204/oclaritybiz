package com.oclaritybiz.command.modules;

import com.oclaritybiz.model.Contacto;
import com.oclaritybiz.service.ContactoService;
import com.oclaritybiz.utils.DatabaseUtils;
import com.oclaritybiz.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ContactsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer companyId = (Integer) request.getSession().getAttribute("companyId");

        try (Connection connection = DatabaseUtils.getConnection()) {
            ContactoService contactoService = new ContactoService(connection);
            List<Contacto> contactos = contactoService.obtenerContactosPorCompania(companyId);
            request.setAttribute("contactos", contactos);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("contactos", List.of());
        }

        request.setAttribute("modulePage", "/WEB-INF/jsp/modules/contacts.jsp");
    }
}