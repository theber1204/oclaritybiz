<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- WEB-INF/jsp/fragments/sidebar.jsp -->
<div class="sidebar">
    <h2>Mi App</h2>
    <a href="${pageContext.request.contextPath}/dashboard?tenant=default">Inicio</a>
    <a href="${pageContext.request.contextPath}/module1">Módulo 1</a>
    <a href="${pageContext.request.contextPath}/module2">Módulo 2</a>
    <a href="${pageContext.request.contextPath}/settings">Configuración</a>
</div>