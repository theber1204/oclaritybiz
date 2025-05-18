package com.oclaritybiz.servlet;

import com.oclaritybiz.auth.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    private Handler handlerChain;

    @Override
    public void init() {
        handlerChain = new LogoutHandler();
        // Puedes agregar más handlers aquí si lo necesitas
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handlerChain.handle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handlerChain.handle(request, response);
    }
}