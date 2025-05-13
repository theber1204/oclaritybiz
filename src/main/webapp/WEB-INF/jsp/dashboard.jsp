<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="fragments/header.jsp">
    <jsp:param name="pageTitle" value="Dashboard" />
</jsp:include>

<div style="display: flex; background-color: #f9f9f9; height: 100vh;">
    <jsp:include page="fragments/sidebar.jsp" />
    <div class="container" style="flex-grow: 1; padding: 20px; background-color: #fff; border-radius: 8px; margin: 20px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
        <div style="text-align: center; margin-bottom: 20px;">
            <h1 style="font-size: 2.5em; color: #333;">
                Bienvenido, <strong>${userName}</strong>
            </h1>
            <p style="font-size: 1.2em; color: #666;">
                Estamos encantados de que estés aquí en <strong>${company.name}</strong>.
            </p>
        </div>
        <div style="display: flex; gap: 20px; margin-bottom: 30px;">
            <div style="flex: 1; padding: 20px; background-color: #e8f5e9; border-radius: 8px; text-align: center; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.08);">
                <h3 style="color: #2e7d32;">Datos de Empresa</h3>
                <p><strong>Nombre:</strong> ${company.name}</p>
                <p><strong>Descripción:</strong> ${company.description}</p>
            </div>
            <div style="flex: 1; padding: 20px; background-color: #e3f2fd; border-radius: 8px; text-align: center; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.08);">
                <h3 style="color: #1565c0;">Información del Sistema</h3>
                <p><strong>Usuarios Conectados:</strong> ${connectedUsers}</p>
                <p><strong>Última Actualización:</strong> ${lastUpdate}</p>
                <p><strong>Estado:</strong> Activo</p>
            </div>
        </div>
        <div class="modules-section">
            <h3>Módulos Disponibles</h3>
            <c:if test="${not empty defaultModules}">
                <div class="modules-grid">
                    <c:forEach var="module" items="${defaultModules}">
                        <div class="module-card">
                            <h4>${module.name}</h4>
                            <p>Status: ${module.status}</p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${empty defaultModules}">
                <p class="no-modules">No hay módulos disponibles actualmente.</p>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp" />