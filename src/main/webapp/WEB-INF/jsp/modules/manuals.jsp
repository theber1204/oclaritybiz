<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="addManualModal.jsp" />

<title>Manuales</title>
<div class="container py-4">
    <h1 class="welcome-title text-center mb-4">Listado de Manuales</h1>
    <p class="text-center text-secondary mb-4">
        Total manuales: <span class="fw-bold"><c:out value="${fn:length(manuales)}"/></span>
    </p>
    <div class="row g-4 justify-content-center">
        <c:forEach var="manual" items="${manuales}">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3 d-flex">
                <div class="user-card shadow-sm rounded-xl p-4 text-center h-100 d-flex flex-column align-items-center w-100">
                    <div class="mb-3">
                        <i class="bi bi-journal-bookmark-fill fa-2x text-primary"></i>
                    </div>
                    <h2 class="user-name mb-1 fs-5">${manual.title}</h2>
                    <p class="user-role text-muted mb-2">${manual.description}</p>
                    <div class="user-socials d-flex gap-2 mt-auto">
                        <a href="${pageContext.request.contextPath}/dashboard?module=manuales&id=${manual.id}"
                           class="btn btn-primary btn-sm">Ver Manual</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 d-flex">
            <div class="user-card shadow-sm rounded-xl p-4 text-center h-100 d-flex flex-column align-items-center w-100 position-relative border-dashed border-2 border-primary">
                <button type="button" class="btn btn-primary rounded-circle position-absolute top-0 start-50 translate-middle"
                        style="width: 48px; height: 48px;" data-bs-toggle="modal" data-bs-target="#addManualModal">
                    <i class="bi bi-plus-lg"></i>
                </button>
                <div class="mb-3 mt-4">
                    <i class="bi bi-journal-plus fa-2x text-primary"></i>
                </div>
                <h2 class="user-name mb-1 fs-5">Agregar Manual</h2>
                <p class="user-role text-muted mb-2">Crear un nuevo manual</p>
            </div>
        </div>
    </div>
    <c:if test="${empty manuales}">
        <p class="no-modules-text text-center text-muted">No hay manuales disponibles actualmente.</p>
    </c:if>
</div>

<!-- Detalle del manual -->
<div class="modal fade" id="manualModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <jsp:include page="manualCarrusel.jsp"/>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<c:if test="${not empty manualSeleccionado}">
    <script>
        new bootstrap.Modal(document.getElementById('manualModal')).show();
    </script>
</c:if>