<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Crear Usuario - OclarityBiz</title>
    <!-- Enlace a Bootstrap para consistencia con login.jsp -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Crear Nuevo Usuario</h2>

    <!-- Formulario -->
    <form action="register" method="post" class="mx-auto" style="max-width: 400px;">
        <!-- Campo: Nombre de Usuario -->
        <div class="mb-3">
            <label for="username" class="form-label">Nombre de Usuario</label>
            <input type="text" class="form-control" id="username"
                   name="username" placeholder="Ingresa un nombre de usuario"
                   required minlength="4" maxlength="20">
        </div>

        <!-- Campo: Email -->
        <div class="mb-3">
            <label for="email" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" id="email"
                   name="email" placeholder="Ingresa tu correo electrónico"
                   required maxlength="100">
        </div>

        <!-- Campo: Contraseña -->
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password"
                   name="password" placeholder="Ingresa una contraseña segura"
                   required minlength="3" maxlength="50">
        </div>

        <!-- Campo: ID de Empresa -->
        <div class="mb-3">
            <label for="company" class="form-label">ID de Empresa</label>
            <input type="text" class="form-control" id="company"
                   name="company" placeholder="Ingrese el ID de la empresa"
                   required>
        </div>

        <!-- Botón de enviar -->
        <button type="submit" class="btn btn-primary w-100">Crear Usuario</button>

        <!-- Mensajes de error o éxito -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
    </form>
</div>
</body>

</html>