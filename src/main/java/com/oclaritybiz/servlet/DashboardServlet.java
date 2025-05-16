package com.oclaritybiz.servlet;

import com.oclaritybiz.model.Contacto;
import com.oclaritybiz.model.Module;
import com.oclaritybiz.service.ContactoService;
import com.oclaritybiz.utils.DatabaseUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar sesión y companyId
        HttpSession session = request.getSession(false); // No crear nueva sesión
        Integer companyId = (session != null) ? (Integer) session.getAttribute("companyId") : null;
        if (companyId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Obtener el parámetro "module" y asignar un valor predeterminado si es null
        String module = request.getParameter("module");
        if (module == null || module.isEmpty()) {
            module = "default";
        }

        // Determinar la página JSP del módulo
        String modulePage;
        switch (module) {
            case "home":
            default:
                modulePage = "/WEB-INF/jsp/modules/default.jsp";
                break;
            case "contacts":
                modulePage = "/WEB-INF/jsp/modules/contacts.jsp";
                // Cargar contactos solo si el módulo es contacts
                try (Connection connection = DatabaseUtils.getConnection()) {
                    ContactoService contactoService = new ContactoService(connection);
                    List<Contacto> contactos = contactoService.obtenerContactosPorCompania(companyId);
                    request.setAttribute("contactos", contactos);
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("contactos", List.of());
                }
                break;
            case "reports":
                modulePage = "/WEB-INF/jsp/modules/reports.jsp";
                break;
        }

        // Crear una lista de módulos predeterminados
        List<Module> defaultModules = List.of(
                new Module("home", "Inicio", "icon-home", "/dashboard?module=home", "Activo"),
                new Module("contacts", "Contactos", "icon-contacts", "/dashboard?module=contacts", "Activo"),
                new Module("reports", "Reportes", "icon-reports", "/dashboard?module=reports", "Activo")
        );

        // Establecer atributos en la solicitud
        request.setAttribute("modulePage", modulePage);
        request.setAttribute("defaultModules", defaultModules);
        request.setAttribute("currentPage", module);

        // Redirigir al dashboard
        request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }
}