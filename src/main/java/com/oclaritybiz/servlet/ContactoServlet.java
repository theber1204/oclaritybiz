package com.oclaritybiz.servlet;

import com.oclaritybiz.model.Contacto;
import com.oclaritybiz.service.ContactoService;
import com.oclaritybiz.utils.DatabaseUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContactoServlet", urlPatterns = {"/contacts"})
public class ContactoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer companyId = (Integer) session.getAttribute("companyId");

        if (companyId == null) {
            response.sendRedirect("login");
            return;
        }

        try (Connection connection = DatabaseUtils.getConnection()) {
            ContactoService contactoService = new ContactoService(connection);
            List<Contacto> contactos = contactoService.obtenerContactosPorCompania(companyId);
            request.setAttribute("contactos", contactos);
            request.getRequestDispatcher("/WEB-INF/jsp/modules/contacts.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener contactos.");
        }
    }
}