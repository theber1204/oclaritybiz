package com.oclaritybiz.command.actions;

import com.oclaritybiz.model.Contacto;
import com.oclaritybiz.service.ContactoService;
import com.oclaritybiz.utils.DatabaseUtils;
import com.oclaritybiz.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

public class CreateContactCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer companyId = (Integer) request.getSession().getAttribute("companyId");

        if (companyId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setName(nombre);
        nuevoContacto.setEmail(email);
        nuevoContacto.setPhone(telefono);

        try (Connection connection = DatabaseUtils.getConnection()) {
            ContactoService contactoService = new ContactoService(connection);
            boolean creado = contactoService.crearContacto(nuevoContacto, companyId);

            if (creado) {
                response.sendRedirect(request.getContextPath() + "/dashboard?module=contacts&successCreate=true");
            } else {
                request.setAttribute("error", "No se pudo crear el contacto.");
                request.setAttribute("contacto", nuevoContacto);
                request.setAttribute("modulePage", "/WEB-INF/jsp/modules/createContact.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al crear el contacto.");
            request.setAttribute("contacto", nuevoContacto);
            request.setAttribute("modulePage", "/WEB-INF/jsp/modules/createContact.jsp");
        }
    }
}