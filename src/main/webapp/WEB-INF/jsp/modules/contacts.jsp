<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container py-4">
    <h1 class="welcome-title text-center mb-4">Conoce a Nuestro Equipo</h1>
    <p>Total contactos: <c:out value="${fn:length(contactos)}"/></p>
    <div class="row g-4 justify-content-center">
        <c:forEach var="contacto" items="${contactos}">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3">
                <div class="user-card shadow-sm rounded-xl p-4 text-center h-100 d-flex flex-column align-items-center">
                    <!-- No tienes foto, nombre ni rol en Contacto, así que usa los campos reales -->
                    <img src="/ruta/por/defecto.jpg" alt="Sin foto" class="user-photo rounded-circle mb-3" style="width:100px; height:100px; object-fit:cover; border:3px solid var(--primary-soft); background:var(--white);">
                    <h2 class="user-name mb-1 fs-5">${contacto.name} ${contacto.surnames}</h2>
                    <p class="user-role text-muted mb-3">${contacto.email}</p>
                    <div class="user-socials d-flex gap-2 mt-auto">
                        <span class="social-link">${contacto.phone}</span>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>