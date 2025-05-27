package com.oclaritybiz.command.modules;

import com.oclaritybiz.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ReportsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("modulePage", "/WEB-INF/jsp/modules/reports.jsp");
    }
}