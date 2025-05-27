package com.oclaritybiz.servlet;

import com.oclaritybiz.command.Command;
import com.oclaritybiz.command.CommandFactory;
import com.oclaritybiz.model.Module;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!verificarSesion(request, response)) return;

        // Configurar los módulos predeterminados
        List<Module> defaultModules = List.of(
                new Module("home", "Inicio", "bi bi-house-door-fill", "/dashboard?module=home", "Activo"),
                new Module("contacts", "Contactos", "bi bi-people-fill", "/dashboard?module=contacts", "Activo"),
                new Module("manuales", "Manuales", "bi bi-journal-bookmark-fill", "/dashboard?module=manuales", "Activo"),
                new Module("reports", "Reportes", "bi bi-bar-chart-fill", "/dashboard?module=reports", "Activo")
        );
        request.setAttribute("defaultModules", defaultModules);

        // Configurar el módulo activo
        String currentPage = request.getParameter("module");
        request.setAttribute("currentPage", currentPage);

        // Si no se especifica un módulo, se usa el módulo predeterminado
        Command command = CommandFactory.getCommand(request, "GET");
        command.execute(request, response);

        // Redirigir a la página del dashboard
        request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!verificarSesion(request, response)) return;

        Command command = CommandFactory.getCommand(request, "POST");
        command.execute(request, response);
    }

    private boolean verificarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        Integer companyId = (session != null) ? (Integer) session.getAttribute("companyId") : null;
        if (companyId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}