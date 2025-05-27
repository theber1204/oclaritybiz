package com.oclaritybiz.command.modules;

import com.oclaritybiz.dao.ManualDAO;
import com.oclaritybiz.dao.ManualPageDAO;
import com.oclaritybiz.model.Manual;
import com.oclaritybiz.service.ManualService;
import com.oclaritybiz.utils.DatabaseUtils;
import com.oclaritybiz.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ManualsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DatabaseUtils.getConnection()) {
            ManualService manualService = new ManualService(
                    new ManualDAO(connection),
                    new ManualPageDAO(connection),
                    connection
            );
            List<Manual> manuales = manualService.listarManuales();
            request.setAttribute("manuales", manuales);

            // Lógica para detalle de manual
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    Long id = Long.parseLong(idParam);
                    Manual manualSeleccionado = manualService.obtenerManualPorId(id);
                    request.setAttribute("manualSeleccionado", manualSeleccionado);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            request.setAttribute("modulePage", "/WEB-INF/jsp/modules/manuals.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error listando manuales");
        }
    }
}