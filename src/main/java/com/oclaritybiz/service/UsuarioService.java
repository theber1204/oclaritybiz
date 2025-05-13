package com.oclaritybiz.service;

import com.oclaritybiz.dao.UsuarioDAO;
import com.oclaritybiz.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    /**
     * Auth al usuario basado en el email y la contraseña proporcionados.
     *
     * @param email    Correo electrónico del usuario.
     * @param password Contraseña en texto plano ingresada por el usuario.
     * @return Usuario autenticado o null si las credenciales son incorrectas.
     */
    public Usuario autenticar(String email, String password) {
        try {
            // Obtener el usuario desde la base de datos utilizando el DAO
            Usuario usuario = usuarioDAO.getUsuarioPorEmail(email);

            // Si no existe el usuario o hay un error, devolver null
            if (usuario == null) {
                LOGGER.log(Level.WARNING, "Usuario no encontrado con el email: {0}", email);
                return null;
            }

            // Comparar la contraseña ingresada con la almacenada (hash)
            if (BCrypt.checkpw(password, usuario.getPassword())) {
                LOGGER.log(Level.INFO, "Usuario autenticado exitosamente: {0}", email);
                return usuario; // Retornar el usuario autenticado
            } else {
                LOGGER.log(Level.WARNING, "Contraseña incorrecta para el usuario: {0}", email);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al autenticar usuario", e);
        }

        return null; // Si falla la autenticación, retornar null
    }

    /**
     * Registra un nuevo usuario después de validar y hash su contraseña.
     *
     * @param usuario Usuario con los datos proporcionados por el cliente.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean registrarUsuario(Usuario usuario) {
        try {
            // Validar los datos de entrada del usuario (simple validación de nulos o formatos)
            if (usuario.getName() == null || usuario.getName().isEmpty()) {
                LOGGER.log(Level.WARNING, "El nombre del usuario no puede estar vacío.");
                return false;
            }
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                LOGGER.log(Level.WARNING, "El email del usuario no puede estar vacío.");
                return false;
            }
            if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
                LOGGER.log(Level.WARNING, "La contraseña del usuario no puede estar vacía.");
                return false;
            }
            if (usuario.getCompany() == null || usuario.getCompany().getId() <= 0) {
                LOGGER.log(Level.WARNING, "El usuario debe pertenecer a una empresa válida.");
                return false;
            }

            // Hash la contraseña introducida por el usuario
            String hashedPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            usuario.setPassword(hashedPassword); // Actualiza la contraseña con el hash

            // Llamar al DAO para guardar el usuario en la base de datos
            return usuarioDAO.registrarUsuario(usuario);

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al registrar usuario", e);
            return false; // Retorna false si ocurre cualquier error al guardar en la base de datos
        }
    }
}