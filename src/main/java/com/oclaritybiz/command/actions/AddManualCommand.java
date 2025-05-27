package com.oclaritybiz.command.actions;

import com.oclaritybiz.dao.ManualDAO;
import com.oclaritybiz.dao.ManualPageDAO;
import com.oclaritybiz.model.Manual;
import com.oclaritybiz.model.ManualPage;
import com.oclaritybiz.service.ManualService;
import com.oclaritybiz.utils.DatabaseUtils;
import com.oclaritybiz.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.SortedMap;
import java.util.TreeMap;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

public class AddManualCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Map<String,String[]> params = request.getParameterMap();

        Manual manual = new Manual();
        manual.setTitle(title);
        manual.setDescription(description);

        // Usar TreeMap para mantener orden por índice
        SortedMap<Integer,ManualPage> pagesMap = new TreeMap<>();
        for (String key : params.keySet()) {
            if (key.startsWith("pages[")) {
                String[] parts = key.split("\\[|\\]");
                int idx = Integer.parseInt(parts[1]);
                pagesMap.putIfAbsent(idx, new ManualPage());
                ManualPage page = pagesMap.get(idx);
                if (key.contains("[observations]")) {
                    page.setObservations(params.get(key)[0]);
                } else if (key.contains("[image_url]")) {
                    page.setImageUrl(params.get(key)[0]);
                }
            }
        }

        List<ManualPage> manualPages = new ArrayList<>();
        int order = 1;
        for (ManualPage page : pagesMap.values()) {
            page.setOrder(order++);
            manualPages.add(page);
        }

        try (Connection connection = DatabaseUtils.getConnection()) {
            ManualService manualService = new ManualService(
                    new ManualDAO(connection),
                    new ManualPageDAO(connection),
                    connection
            );
            boolean creado = manualService.crearManualConPaginas(manual, manualPages);

            if (creado) {
                response.sendRedirect(request.getContextPath() + "/dashboard?module=manuales");
            } else {
                request.setAttribute("error", "No se pudo crear el manual.");
                request.getRequestDispatcher("/WEB-INF/jsp/modules/manuals.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al crear el manual.");
            request.getRequestDispatcher("/WEB-INF/jsp/modules/manuals.jsp").forward(request, response);
        }
    }
}