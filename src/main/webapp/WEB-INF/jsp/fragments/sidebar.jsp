<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<aside class="sidebar">
    <h2 class="sidebar-title">Menú</h2>
    <ul class="sidebar-menu">
        <c:forEach var="module" items="${defaultModules}">
            <li class="sidebar-item">
                <a href="${pageContext.request.contextPath}${module.link}" class="sidebar-link">
                    <i class="${module.icon} sidebar-icon"></i>
                    <span class="sidebar-text">${module.name}</span>
                </a>
            </li>
        </c:forEach>
    </ul>
</aside>