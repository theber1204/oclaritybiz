<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page-container">
    <!-- Contenedor principal -->
    <div class="container">
        <!-- Bienvenida -->
        <div class="welcome-section">
            <h1 class="welcome-title">Bienvenido, <span class="highlight">${userName}</span></h1>
            <p class="welcome-text">Estamos encantados de que estés aquí en <strong>${company.name}</strong>.</p>
        </div>

        <!-- Información de la empresa -->
        <div class="info-section">
            <div class="info-card info-company">
                <h3>Datos de Empresa</h3>
                <p><strong>Nombre:</strong> ${company.name}</p>
                <p><strong>Descripción:</strong> ${company.description}</p>
            </div>
            <div class="info-card info-system">
                <h3>Información del Sistema</h3>
                <p><strong>Usuarios Conectados:</strong> ${connectedUsers}</p>
                <p><strong>Última Actualización:</strong> ${lastUpdate}</p>
                <p><strong>Estado:</strong> Activo</p>
            </div>
        </div>

        <!-- Módulos disponibles -->
        <div class="modules-section">
            <h2 class="modules-title">Módulos Disponibles</h2>
            <c:if test="${not empty defaultModules}">
                <div class="modules-grid">
                    <c:forEach var="module" items="${defaultModules}">
                        <div class="module-card">
                            <h3>${module.name}</h3>
                            <p><strong>Estado:</strong> ${module.status}</p>
                            <a href="${pageContext.request.contextPath}${module.link}" class="module-link">Ir al Módulo</a>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${empty defaultModules}">
                <p class="no-modules-text">No hay módulos disponibles actualmente.</p>
            </c:if>
        </div>
    </div>
</div>