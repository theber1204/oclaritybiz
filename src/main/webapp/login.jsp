<!-- filepath: c:\Users\Eber Henri\IdeaProjects\oclaritybizV1\src\main\webapp\login.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - OclarityBiz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="w-100" style="max-width: 400px;">
        <h2 class="text-center mb-4">Iniciar sesión</h2>
        <form action="login" method="post" class="p-4 border rounded-3 shadow-sm bg-white">
            <div class="mb-3">
                <label for="email" class="form-label">Correo electrónico</label>
                <input type="text" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Ingresar</button>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger mt-3">${errorMessage}</div>
            </c:if>
        </form>
    </div>
</div>
</body>

</html>