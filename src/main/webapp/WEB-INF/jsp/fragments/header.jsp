<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

<header class="header">
    <!-- Logo y título -->
    <div class="header-logo">
        <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Logo" class="header-img">
        <h1 class="header-title">OclarityBiz</h1>
    </div>

    <!-- Navegación -->
    <nav class="header-nav">
        <a href="${pageContext.request.contextPath}/home" class="header-link">Inicio</a>
        <a href="${pageContext.request.contextPath}/logout" class="header-link">Cerrar Sesión</a>
    </nav>
</header>