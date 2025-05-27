<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Inicio</title>
<div class="page-container py-4">
    <div class="container">
        <!-- Bienvenida -->
        <div class="welcome-section text-center mb-4">
            <h1 class="welcome-title mb-2">Bienvenido, <span class="highlight">${user.name}</span></h1>
            <p class="welcome-text">Estamos encantados de que estés aquí en <strong>${company.name}</strong>.</p>
        </div>

        <!-- Información de la empresa y sistema -->
        <div class="row g-4 info-section mb-5">
            <div class="col-md-6">
                <div class="info-card info-company h-100 shadow-sm p-4">
                    <h3 class="mb-3"><i class="fas fa-building me-2 text-primary"></i>Datos de Empresa</h3>
                    <p><strong>Nombre:</strong> ${company.name}</p>
                    <p><strong>Descripción:</strong> ${company.description}</p>
                </div>
            </div>
            <div class="col-md-6">
                <div class="info-card info-system h-100 shadow-sm p-4">
                    <h3 class="mb-3"><i class="fas fa-info-circle me-2 text-primary"></i>Información del Sistema</h3>
                    <p><strong>Estado:</strong> <span class="badge bg-success">${systemActive ? 'Activo' : 'Inactivo'}</span></p>
                </div>
            </div>
        </div>

        <!-- Módulos disponibles -->
        <div class="modules-section">
            <h2 class="modules-title mb-4">Módulos Disponibles</h2>
            <c:if test="${not empty defaultModules}">
                <div class="row modules-grid g-4">
                    <c:forEach var="module" items="${defaultModules}">
                        <div class="col-12 col-md-6 col-lg-4">
                            <div class="module-card h-100 shadow-sm p-4 d-flex flex-column align-items-start">
                                <div class="mb-3">
                                    <i class="${module.icon} fa-2x text-primary"></i>
                                </div>
                                <h3 class="mb-2">${module.name}</h3>
                                <span class="badge ${module.status eq 'Activo' ? 'bg-success' : 'bg-secondary'} mb-2">${module.status}</span>
                                <a href="${pageContext.request.contextPath}${module.link}" class="btn btn-landing-primary mt-auto">Ir al Módulo</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${empty defaultModules}">
                <p class="no-modules-text text-center text-muted">No hay módulos disponibles actualmente.</p>
            </c:if>
        </div>
    </div>
</div>