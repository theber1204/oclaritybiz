<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h1 class="welcome-title">Conoce a Nuestro Equipo</h1>
    <div class="users-grid">
        <c:forEach var="usuario" items="${usuarios}">
            <div class="user-card">
                <img src="${usuario.foto}" alt="Foto de ${usuario.nombre}" class="user-photo">
                <h2 class="user-name">${usuario.nombre}</h2>
                <p class="user-role">${usuario.rol}</p>
                <div class="user-socials">
                    <a href="${usuario.linkedin}" target="_blank" class="social-link">LinkedIn</a>
                    <a href="${usuario.twitter}" target="_blank" class="social-link">Twitter</a>
                    <a href="${usuario.github}" target="_blank" class="social-link">GitHub</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>