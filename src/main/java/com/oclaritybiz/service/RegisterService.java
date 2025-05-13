package com.oclaritybiz.service;

import com.oclaritybiz.dao.UsuarioDAO;
import com.oclaritybiz.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.util.logging.Logger;

public class RegisterService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final Logger logger = Logger.getLogger(RegisterService.class.getName());

    public boolean registerUser(Usuario usuario) {
        try {
            // Hashear la contraseña del usuario antes de almacenarla
            String hashedPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            usuario.setPassword(hashedPassword);

            // Llamar al DAO para guardar el usuario
            return usuarioDAO.registrarUsuario(usuario);
        } catch (Exception e) {
            logger.severe("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
}