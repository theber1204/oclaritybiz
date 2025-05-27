package com.oclaritybiz.service;

import com.oclaritybiz.dao.UsuarioDAO;
import com.oclaritybiz.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    public Usuario autenticar(String email, String password) {
        try {
            Usuario usuario = usuarioDAO.getUsuarioPorEmail(email);
            if (usuario == null) {
                LOGGER.log(Level.WARNING, "Usuario no encontrado con el email: {0}", email);
                return null;
            }
            if (BCrypt.checkpw(password, usuario.getPassword())) {
                LOGGER.log(Level.INFO, "Usuario autenticado exitosamente: {0}", email);
                return usuario;
            } else {
                LOGGER.log(Level.WARNING, "Contraseña incorrecta para el usuario: {0}", email);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al autenticar usuario", e);
        }
        return null;
    }

    /**
     * Registra un nuevo usuario y retorna el id generado o null si falla.
     */
    public Integer registrarUsuario(Usuario usuario) {
        try {
            if (usuario.getName() == null || usuario.getName().isEmpty()) {
                LOGGER.log(Level.WARNING, "El nombre del usuario no puede estar vacío.");
                return null;
            }
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                LOGGER.log(Level.WARNING, "El email del usuario no puede estar vacío.");
                return null;
            }
            if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
                LOGGER.log(Level.WARNING, "La contraseña del usuario no puede estar vacía.");
                return null;
            }
            if (usuario.getCompany() == null || usuario.getCompany().getId() <= 0) {
                LOGGER.log(Level.WARNING, "El usuario debe pertenecer a una empresa válida.");
                return null;
            }
            String hashedPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            usuario.setPassword(hashedPassword);
            return usuarioDAO.registrarUsuario(usuario);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al registrar usuario", e);
            return null;
        }
    }
}