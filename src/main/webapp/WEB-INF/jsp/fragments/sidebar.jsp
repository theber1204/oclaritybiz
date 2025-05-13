<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- WEB-INF/jsp/fragments/sidebar.jsp -->
<div class="sidebar">
    <h2>Mi App</h2>
    <nav>
        <ul>
            <jsp:useBean id="defaultModules" scope="request" type="java.util.List"/>
            <c:forEach var="module" items="${defaultModules}">
                <li>
                    <a href="${pageContext.request.contextPath}${module.link}">
                        <i class="${module.icon}"></i> ${module.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</div>