<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<div class="container py-4">
    <h1 class="welcome-title text-center mb-4">Conoce a Nuestro Equipo</h1>
    <p class="text-center text-secondary mb-4">
        Total contactos: <span class="fw-bold"><c:out value="${fn:length(contactos)}"/></span>
    </p>
    <div class="row g-4 justify-content-center">
        <c:forEach var="contacto" items="${contactos}">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3 d-flex">
                <div class="user-card shadow-sm rounded-xl p-4 text-center h-100 d-flex flex-column align-items-center w-100">
                    <img src="/ruta/por/defecto.jpg"
                         alt="Foto de ${contacto.name} ${contacto.surnames}"
                         class="user-photo rounded-circle mb-3"
                         style="width:100px; height:100px; object-fit:cover; border:3px solid var(--primary-soft); background:var(--white);">
                    <h2 class="user-name mb-1 fs-5">${contacto.name} ${contacto.surnames}</h2>
                    <p class="user-role text-muted mb-2">${contacto.email}</p>
                    <div class="user-socials d-flex gap-2 mt-auto">
                        <span class="text-shadow" title="Teléfono" style="color:var(--dark);">
                            <i class="bi bi-telephone"></i>
                            <span class="ms-1">${contacto.phone}</span>
                        </span>
                    </div>
                    <div class="user-socials d-flex gap-2 mt-2">
                        <c:if test="${not empty contacto.linkedin}">
                            <a href="${contacto.linkedin}" class="social-link" target="_blank" rel="noopener" title="LinkedIn" style="background-color:#0a66c2;">
                                <i class="bi bi-linkedin"></i>
                            </a>
                        </c:if>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>