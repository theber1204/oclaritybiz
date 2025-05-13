package com.oclaritybiz.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.oclaritybiz.model.Usuario;
import com.oclaritybiz.model.Module;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Usuario user = (Usuario) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Simulación de módulos (puedes reemplazar por tu lógica real)
        List<Module> defaultModules = new ArrayList<>();
        defaultModules.add(new Module("1", "Ventas", "fa-shopping-cart", "/ventas", "Activo"));
        defaultModules.add(new Module("2", "Inventario", "fa-boxes", "/inventario", "Inactivo"));
        defaultModules.add(new Module("3", "Reportes", "fa-chart-bar", "/reportes", "Activo"));

        session.setAttribute("defaultModules", defaultModules);

        Object companyAttr = session.getAttribute("company");
        request.setAttribute("userName", user.getName());
        request.setAttribute("company", companyAttr);
        request.setAttribute("defaultModules", defaultModules);

        request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }
}