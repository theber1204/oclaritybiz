<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap CSS primero -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

<header class="navbar navbar-expand-lg navbar-landing shadow-sm px-3 py-2">
    <div class="container-fluid d-flex align-items-center">
        <!-- Logo y título -->
        <a href="${pageContext.request.contextPath}/dashboard" class="d-flex align-items-center text-decoration-none me-auto">
            <img src="${pageContext.request.contextPath}/assets/img/oclaritybizwww.png" alt="Logo" class="rounded-circle me-2" style="height:40px">
            <span class="brand-title">OclarityBiz</span>
        </a>
        <!-- Botón unificado para sidebar y navegación -->
        <button class="btn btn-primary d-lg-none ms-auto" id="toggleMenu" style="z-index: 1050;">
            <i class="bi bi-list"></i>
        </button>
        <!-- Navegación (visible solo en pantallas grandes) -->
        <nav class="collapse navbar-collapse d-none d-lg-block" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/home" class="nav-link-landing text-white">
                        <i class="bi bi-house-door-fill me-1"></i>Inicio
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/logout" class="nav-link-landing text-danger">
                        <i class="bi bi-box-arrow-right me-1"></i>Cerrar Sesión
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<aside class="dashboard-sidebar d-flex flex-column vh-100 shadow-lg bg-light position-fixed" id="sidebar"
       style="width: 250px; transition: transform 0.3s ease-in-out; transform: translateX(-100%);">
    <nav class="sidebar-menu flex-grow-1 d-flex flex-column">
        <ul class="list-unstyled mt-3">
            <c:forEach var="module" items="${defaultModules}">
                <li>
                    <a href="${pageContext.request.contextPath}${module.link}"
                       class="sidebar-link d-flex align-items-center px-3 py-2 rounded ${currentPage eq module.id ? 'active bg-primary text-white' : 'text-dark'}">
                        <i class="${module.icon} me-2"></i>
                        <span>${module.name}</span>
                    </a>
                </li>
            </c:forEach>
            <!-- Botones de Inicio y Cerrar Sesión (solo en el sidebar) -->
            <li class="mt-4">
                <a href="${pageContext.request.contextPath}/home" class="sidebar-link d-flex align-items-center px-3 py-2 text-dark">
                    <i class="bi bi-house-door-fill me-2"></i>
                    <span>Inicio</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout" class="sidebar-link d-flex align-items-center px-3 py-2 text-danger">
                    <i class="bi bi-box-arrow-right me-2"></i>
                    <span>Cerrar Sesión</span>
                </a>
            </li>
        </ul>
    </nav>
</aside>

<script>
    const sidebar = document.getElementById('sidebar');
    const toggleMenu = document.getElementById('toggleMenu');

    toggleMenu.addEventListener('click', () => {
        // Alternar el sidebar
        const isSidebarVisible = sidebar.style.transform === 'translateX(0px)';
        sidebar.style.transform = isSidebarVisible ? 'translateX(-100%)' : 'translateX(0)';
    });
</script>
<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>