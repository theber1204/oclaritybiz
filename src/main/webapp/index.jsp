<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="WEB-INF/includes/navbar.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>OclarityBiz - Plataforma de Aprendizaje Corporativo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="assets/img/hlogol1.jpg" alt="Logo" height="70"> OclarityBiz
        </a>
    </div>
</nav>

<header class="bg-light py-5 text-center">
    <div class="container">
        <h1 class="display-5 fw-bold">Bienvenido a OclarityBiz</h1>
        <p class="lead">Tu plataforma e-learning para onboarding, cultura y desarrollo interno empresarial.</p>
        <a href="login" class="btn btn-primary btn-lg mt-3">Iniciar Sesión</a>
    </div>
</header>

<section class="py-5">
    <div class="container">
        <h2 class="text-center mb-4">¿Qué ofrecemos?</h2>
        <div class="row">
            <div class="col-md-4">
                <h5>Onboarding personalizado</h5>
                <p>Automatiza el ingreso de nuevos empleados con módulos diseñados por empresa.</p>
            </div>
            <div class="col-md-4">
                <h5>Cultura corporativa</h5>
                <p>Fomenta la identidad de la empresa con cursos y recursos integrados.</p>
            </div>
            <div class="col-md-4">
                <h5>Capacitación técnica</h5>
                <p>Formación continua con tecnología Java EE, REST, y frameworks modernos.</p>
            </div>
        </div>
    </div>
</section>
<section class="py-5 bg-light">
    <div class="container">
        <h2 class="text-center mb-4">Empresas que confían en nosotros</h2>
        <div class="row text-center">
            <div class="col-md-3 mb-3">
                <img src="assets/img/logo_empresa1.png" alt="Empresa 1" height="50">
            </div>
            <div class="col-md-3 mb-3">
                <img src="assets/img/logo_empresa2.png" alt="Empresa 2" height="50">
            </div>
            <!-- Más logos -->
        </div>
    </div>
</section>
<section class="bg-white py-5">
    <div class="container">
        <h2 class="text-center mb-4">Historias de éxito</h2>
        <div class="row">
            <div class="col-md-6">
                <blockquote class="blockquote border p-3">
                    <p class="mb-0">
                        “Gracias a OclarityBiz hemos unificado nuestra capacitación interna y onboarding en un solo lugar.”
                    </p>
                    <footer class="blockquote-footer mt-2">Juan Pérez, Director de RRHH</footer>
                </blockquote>
            </div>
            <!-- Otro testimonio -->
        </div>
    </div>
</section>


<footer class="">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">OClarityBiz</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- Aquí va la lógica JSTL para usuarios logueados o no -->
                    <li class="nav-item">
                        <a class="nav-link" href="contacto.jsp">Contacto</a>
                    </li>
                    <!-- etc. -->
                </ul>
            </div>
        </div>
    </nav>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
