package com.oclaritybiz.servlet;

import com.oclaritybiz.service.ModuleService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.oclaritybiz.model.Usuario;
import com.oclaritybiz.model.Module;
import java.io.IOException;
//import java.util.ArrayList;
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

        // Obtener módulos desde el servicio
        ModuleService moduleService = new ModuleService();
        List<Module> defaultModules = moduleService.obtenerModulosPorUsuario(user.getId());

        Object companyAttr = session.getAttribute("company");
        request.setAttribute("userName", user.getName());
        request.setAttribute("company", companyAttr);
        request.setAttribute("defaultModules", defaultModules);

        request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }
}