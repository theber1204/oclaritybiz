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

public class EditContactCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surnames = request.getParameter("surnames");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String linkedin = request.getParameter("linkedin");

        Contacto contacto = new Contacto();
        contacto.setId(id);
        contacto.setName(name);
        contacto.setSurnames(surnames);
        contacto.setEmail(email);
        contacto.setPhone(phone);
        contacto.setLinkedin(linkedin);

        try (Connection connection = DatabaseUtils.getConnection()) {
            ContactoService contactoService = new ContactoService(connection);
            boolean actualizado = contactoService.actualizarContacto(contacto);

            if (actualizado) {
                response.sendRedirect(request.getContextPath() + "/dashboard?module=contacts");
            } else {
                request.setAttribute("error", "No se pudo actualizar el contacto.");
                request.setAttribute("modulePage", "/WEB-INF/jsp/modules/editContactModal.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al actualizar el contacto.");
            request.setAttribute("modulePage", "/WEB-INF/jsp/modules/editContactModal.jsp");
        }
    }
}