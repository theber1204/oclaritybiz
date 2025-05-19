package com.oclaritybiz.auth;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class ValidationHandler extends Handler {
    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "Datos inválidos.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return true;
        }
        if (next != null) return next.handle(request, response);
        return false;
    }
}