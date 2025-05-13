package com.oclaritybiz.servlet;

import com.oclaritybiz.model.Company;
import com.oclaritybiz.model.Usuario;
import com.oclaritybiz.service.RegisterService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateUserServlet", urlPatterns = {"/register"})
public class CreateUserServlet extends HttpServlet {

    private final RegisterService registerService = new RegisterService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Obtener los parámetros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Contraseña en texto plano
        String email = request.getParameter("email"); // <-- Agregado
        String companyParam = request.getParameter("company"); // ID de la compañía

        // 2. Validar los parámetros del formulario
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                email == null || email.trim().isEmpty() || // <-- Validar email
                companyParam == null || companyParam.trim().isEmpty()) {

            request.setAttribute("errorMessage", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
            return;
        }

        // 3. Crear el objeto Usuario con datos validados
        Usuario usuario = new Usuario();
        usuario.setName(username);
        usuario.setPassword(password); // Se hash en el servicio más tarde
        usuario.setEmail(email); // <-- Asignar email

        try {
            // Convertir el ID de la compañía en un entero y asociarlo al Usuario
            int companyId = Integer.parseInt(companyParam);

            Company company = new Company();
            company.setId(companyId);
            usuario.setCompany(company);

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "ID de compañía inválido.");
            request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
            return;
        }

        // 4. Intentar registrar el usuario utilizando el servicio
        try {
            boolean creado = registerService.registerUser(usuario);

            if (creado) {
                // Usuario creado exitosamente
                request.setAttribute("successMessage", "Usuario creado exitosamente.");
                request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
            } else {
                // Error al crear el usuario
                request.setAttribute("errorMessage", "No se pudo crear el usuario.");
                request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // Manejar errores inesperados
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error interno: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirigir al formulario de creación
        request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp").forward(request, response);
    }
}