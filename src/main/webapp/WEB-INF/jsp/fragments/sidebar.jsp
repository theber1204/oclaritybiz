<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<aside class="dashboard-sidebar d-flex flex-column vh-100 shadow-lg bg-white">
    <nav class="sidebar-menu flex-grow-1 d-flex flex-column">
        <ul class="list-unstyled mt-3">
            <c:forEach var="module" items="${defaultModules}">
                <li>
                    <a href="${pageContext.request.contextPath}${module.link}"
                       class="sidebar-link d-flex align-items-center px-3 py-2 ${currentPage eq module.id ? 'active' : ''}">
                        <i class="${module.icon} me-2"></i>
                        <span>${module.name}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</aside>