package com.oclaritybiz.service;

import com.oclaritybiz.dao.ModuleDAO;
import com.oclaritybiz.model.Module;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleService {

    private final ModuleDAO moduleDAO = new ModuleDAO();
    private static final Logger LOGGER = Logger.getLogger(ModuleService.class.getName());

    public List<Module> obtenerModulosPorUsuario(long userId) {
        try {
            List<Module> modules = moduleDAO.getModulesByUserId(userId);

            // Asignar nombres alternativos
            for (Module module : modules) {
                if ("Contacts".equals(module.getName())) {
                    module.setName("Red de Contactos");
                }
                // Agrega más condiciones si es necesario
            }

            return modules;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener módulos para el usuario con ID: " + userId, e);
            return new ArrayList<>();
        }
    }
}