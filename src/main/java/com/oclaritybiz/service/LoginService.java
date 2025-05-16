package com.oclaritybiz.service;

import com.oclaritybiz.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginService {
    private final UsuarioService usuarioService = new UsuarioService();
    private static final Logger logger = Logger.getLogger(LoginService.class.getName());

    /**
     * Auth a un usuario con el email y contraseña proporcionados.
     *
     * @param email    El email del usuario.
     * @param password La contraseña del usuario.
     * @return El objeto Usuario si las credenciales son correctas, o null si no lo son.
     */
    public Usuario login(String email, String password) {
        try {
            Usuario usuario = usuarioService.autenticar(email, password);
            if (usuario != null) {
                logger.log(Level.INFO, "Usuario autenticado: {0}", email);
            } else {
                logger.log(Level.WARNING, "Credenciales incorrectas para el email: {0}", email);
            }
            return usuario;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error durante el inicio de sesión para el email: " + email, e);
            return null;
        }
    }
}