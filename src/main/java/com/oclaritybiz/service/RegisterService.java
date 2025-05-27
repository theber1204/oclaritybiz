// src/main/java/com/oclaritybiz/service/RegisterService.java
package com.oclaritybiz.service;

import com.oclaritybiz.dao.UsuarioDAO;
import com.oclaritybiz.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.util.logging.Logger;

public class RegisterService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final Logger logger = Logger.getLogger(RegisterService.class.getName());

    // Cambia el tipo de retorno a Integer
    public Integer registerUser(Usuario usuario) {
        try {
            String hashedPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            usuario.setPassword(hashedPassword);

            // Retorna el id generado o null
            return usuarioDAO.registrarUsuario(usuario);
        } catch (Exception e) {
            logger.severe("Error al registrar usuario: " + e.getMessage());
            return null;
        }
    }
}