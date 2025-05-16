<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap CSS primero -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<!-- Tus estilos personalizados después -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

<header class="navbar navbar-expand-lg navbar-landing shadow-sm px-3 py-2">
    <div class="container-fluid d-flex align-items-center justify-content-between">
        <!-- Logo y título -->
        <a href="${pageContext.request.contextPath}/dashboard" class="d-flex align-items-center text-decoration-none">
            <img src="${pageContext.request.contextPath}/assets/img/oclaritybizwww.png" alt="Logo" class="rounded-circle me-2" style="height:40px">
            <span class="brand-title">OclarityBiz</span>
        </a>
        <!-- Navegación -->
        <nav class="d-flex align-items-center gap-2">
            <a href="${pageContext.request.contextPath}/home" class="nav-link-landing">Inicio</a>
            <a href="${pageContext.request.contextPath}/logout" class="nav-link-landing text-danger">Cerrar Sesión</a>
        </nav>
    </div>
</header>