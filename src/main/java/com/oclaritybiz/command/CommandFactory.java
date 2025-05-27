package com.oclaritybiz.command;

import com.oclaritybiz.command.actions.AddManualCommand;
import com.oclaritybiz.command.actions.CreateContactCommand;
import com.oclaritybiz.command.actions.EditContactCommand;
import com.oclaritybiz.command.modules.*;
import jakarta.servlet.http.HttpServletRequest;

public class CommandFactory {
    public static Command getCommand(HttpServletRequest request, String method) {
        if ("POST".equalsIgnoreCase(method)) {
            return getPostCommand(request);
        } else {
            return getGetCommand(request);
        }
    }

    private static Command getGetCommand(HttpServletRequest request) {
        String module = request.getParameter("module");
        if (module == null || module.isEmpty()) {
            return new DefaultCommand();
        }

        switch (module) {
            case "contacts":
                return new ContactsCommand();
            case "manuales":
                return new ManualsCommand();
            case "reports":
                return new ReportsCommand();
            default:
                return new DefaultCommand();
        }
    }

    private static Command getPostCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        if ("addManual".equals(action)) {
            return new AddManualCommand();
        } else if ("createContact".equals(action)) {
            return new CreateContactCommand();
        } else if ("editContact".equals(action)) {
            return new EditContactCommand();
        }
        return new DefaultCommand();
    }
}