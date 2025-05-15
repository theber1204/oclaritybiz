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

    private ContactoService contactoService;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            // Obtén la conexión desde una clase de utilidad o un pool de conexiones
            Connection connection = DatabaseUtils.getConnection();
            contactoService = new ContactoService(connection);
        } catch (SQLException e) {
            throw new ServletException("Error initializing ContactoService", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login");
            return;
        }

        try {
            List<Contacto> contactos = contactoService.obtenerContactosPorUsuario(userId);
            request.setAttribute("contactos", contactos);
            request.getRequestDispatcher("/WEB-INF/jsp/contacts.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener contactos.");
        }
    }
}