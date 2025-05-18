package com.oclaritybiz.auth;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class LogoutHandler extends Handler {
    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if ("/logout".equals(request.getServletPath())) {
            HttpSession session = request.getSession(false);
            if (session != null) session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
            return true;
        }
        if (next != null) return next.handle(request, response);
        return false;
    }
}