package com.oclaritybiz.servlet;

import com.oclaritybiz.model.Module;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el parámetro "module" y asignar un valor predeterminado si es null
        String module = request.getParameter("module");
        if (module == null || module.isEmpty()) {
            module = "default";
        }

        // Determinar la página JSP del módulo
        String modulePage;
        switch (module) {
            case "contacts":
                modulePage = "/WEB-INF/jsp/modules/contacts.jsp";
                break;
            case "reports":
                modulePage = "/WEB-INF/jsp/modules/reports.jsp";
                break;
            default:
                modulePage = "/WEB-INF/jsp/modules/default.jsp";
                break;
        }

        // Crear una lista de módulos predeterminados
        List<com.oclaritybiz.model.Module> defaultModules = List.of(
                new com.oclaritybiz.model.Module("1", "Contactos", "icon-contacts", "/dashboard?module=contacts", "Activo"),
                new Module("2", "Reportes", "icon-reports", "/dashboard?module=reports", "Activo")
        );

        // Establecer atributos en la solicitud
        request.setAttribute("modulePage", modulePage);
        request.setAttribute("defaultModules", defaultModules);

        // Redirigir al dashboard
        request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }
}