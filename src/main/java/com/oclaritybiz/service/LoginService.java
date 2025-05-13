package com.oclaritybiz.service;

import com.oclaritybiz.dao.UsuarioDAO;
import com.oclaritybiz.model.Usuario;
import java.util.logging.Logger;

public class LoginService {
    private final UsuarioService
            usuarioService
            = new UsuarioService
            ();
    private static final Logger logger = Logger.getLogger(LoginService.class.getName());

    public Usuario login(String email, String password) {
        try {
            return usuarioService.autenticar(email, password);
        } catch (Exception e) {
            logger.severe("Error during login: " + e.getMessage());
            return null;
        }
    }
}