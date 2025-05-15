package com.oclaritybiz.servlet;

import com.oclaritybiz.model.Usuario;
import com.oclaritybiz.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final LoginService loginService = new LoginService();

    // Configuramos un logger
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos los datos del formulario
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Logueamos los datos recibidos
        LOGGER.log(Level.INFO, "Datos enviados: email={0}, password={1}", new Object[]{email, password});
        // Con System.out.println sería:
        // System.out.println("Datos enviados: email=" + email + ", password=" + password);

        if (isInvalid(email, password)) {
            forwardWithError(request, response, "Datos inválidos.");
            return;
        }

        // Llamamos al LoginService
        Usuario usuario = loginService.login(email, password);

        if (usuario != null) {
            createSession(request, usuario);
            response.sendRedirect("dashboard");
        } else {
            forwardWithError(request, response, "Usuario o contraseña incorrectos.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private boolean isInvalid(String email, String password) {
        return email == null || email.isEmpty() || password == null || password.isEmpty();
    }

    private void forwardWithError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void createSession(HttpServletRequest request, Usuario usuario) {
        HttpSession session = request.getSession();
        session.setAttribute("user", usuario); // Usuario completo
        session.setAttribute("userId", usuario.getId()); // ID del usuario
        session.setAttribute("company", usuario.getCompany());
    }
}