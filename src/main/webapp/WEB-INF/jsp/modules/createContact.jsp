<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Contacto</title>
</head>
<body>
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<div style="color:red;"><%= error %></div>
<% } %>
<form action="${pageContext.request.contextPath}/createContact" method="post">
    <label>Nombre: <input type="text" name="nombre" value="${contacto != null ? contacto.name : ''}" required></label><br>
    <label>Email: <input type="email" name="email" value="${contacto != null ? contacto.email : ''}" required></label><br>
    <label>Teléfono: <input type="text" name="telef ono" value="${contacto != null ? contacto.phone : ''}" required></label><br>
    <button type="submit">Crear</button>
</form>
<a href="${pageContext.request.contextPath}/contacts">Volver a la lista</a>
</body>
</html>