<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard con Sidebar Estético</title>
    <!-- Vincula Bootstrap (puedes usar la versión que prefieras) -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Estilos para el sidebar */
        .sidebar {
            height: 100vh;
            background: linear-gradient(135deg, #343a40, #23272b);
            padding: 20px;
            color: #fff;
            transition: background 0.3s ease;
        }
        .sidebar h2 {
            font-size: 1.5rem;
            margin-bottom: 1rem;
        }
        .sidebar a {
            color: #fff;
            display: block;
            padding: 10px 15px;
            border-radius: 4px;
            margin-bottom: 10px;
            transition: background 0.3s ease;
        }
        .sidebar a:hover {
            background: rgba(255, 255, 255, 0.1);
            text-decoration: none;
        }

        /* Estilos para el contenido principal */
        .main-content {
            padding: 30px;
        }

        /* Estilos para los formularios */
        .form-control {
            border-radius: 0.25rem;
            box-shadow: none;
            border-color: #ced4da;
            transition: border-color 0.3s ease;
        }
        .form-control:focus {
            border-color: #80bdff;
            box-shadow: 0px 0px 5px rgba(0, 123, 255, 0.5);
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="d-flex">
    <!-- Sidebar -->
    <nav class="sidebar">
        <h2>Mi Aplicación</h2>
        <a href="#">Inicio</a>
        <a href="#">Módulo 1</a>
        <a href="#">Módulo 2</a>
        <a href="#">Configuración</a>
    </nav>

    <!-- Contenido Principal -->
    <div class="main-content flex-grow-1">
        <h1>Dashboard</h1>
        <p>Bienvenido al panel principal.</p>

        <!-- Ejemplo de formulario en un módulo -->
        <form>
            <div class="form-group">
                <label for="campo1">Campo 1</label>
                <input type="text" class="form-control" id="campo1" placeholder="Ingrese valor">
            </div>
            <div class="form-group">
                <label for="campo2">Campo 2</label>
                <input type="password" class="form-control" id="campo2" placeholder="Ingrese contraseña">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
</div>

<!-- Opcional: Vincula Bootstrap JS y dependencias -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>