package com.oclaritybiz.auth;

import com.oclaritybiz.model.Usuario;
import com.oclaritybiz.service.LoginService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class LoginHandler extends Handler {
    private final LoginService loginService = new LoginService();

    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Usuario usuario = loginService.login(email, password);
            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", usuario);
                session.setAttribute("userId", usuario.getId());
                session.setAttribute("company", usuario.getCompany());
                session.setAttribute("companyId", usuario.getCompany().getId());
                response.sendRedirect("dashboard");
            } else {
                // Guardar el error en sesión y redirigir
                request.getSession().setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
                response.sendRedirect("login");
            }
            return true;
        }
        if (next != null) return next.handle(request, response);
        return false;
    }
}