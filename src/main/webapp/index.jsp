<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Plataforma e-learning integral para onboarding, cultura y desarrollo interno empresarial">
    <title>OclarityBiz - Plataforma de Aprendizaje Corporativo</title>

    <!-- Preconexión para mejorar performance -->
    <link rel="preconnect" href="https://cdn.jsdelivr.net">
    <link rel="preconnect" href="https://cdnjs.cloudflare.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- Font Awesome (versión optimizada) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- Google Fonts (carga optimizada) -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">

    <!-- Favicon -->
    <link rel="icon" href="assets/img/favicon.ico" type="image/x-icon">

    <!-- Tu CSS personalizado -->
    <link rel="stylesheet" href="assets/css/styles.css?v=1.0">
</head>
<body class="landing-page">
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-landing fixed-top">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="#" aria-label="OclarityBiz Home">
            <img src="assets/img/oclaritybizwww.png" alt="Logo OclarityBiz" class="me-2 rounded header-img" height="50" width="50" loading="lazy">
            <span class="fw-bold brand-title">OclarityBiz</span>
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link nav-link-landing" href="#features">Características</a></li>
                <li class="nav-item"><a class="nav-link nav-link-landing" href="#testimonials">Testimonios</a></li>
                <li class="nav-item"><a class="nav-link nav-link-landing" href="#contact">Contacto</a></li>
                <li class="nav-item ms-lg-3">
                    <a class="btn btn-primary btn-landing-primary" href="login" role="button">
                        <i class="fas fa-sign-in-alt me-1"></i> Iniciar Sesión
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main class="landing-main">
    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-7">
                    <h1 class="hero-title">Transforma tu <span class="text-highlight">Talento</span> Empresarial</h1>
                    <p class="hero-lead">Plataforma e-learning integral para onboarding, cultura y desarrollo interno empresarial. Impulsa el crecimiento de tu equipo con tecnología de vanguardia.</p>

                    <div class="d-flex flex-wrap gap-3 hero-cta">
                        <a href="#demo" class="btn btn-primary btn-lg btn-cta-primary">
                            <i class="fas fa-rocket me-2"></i> Solicitar Demo
                        </a>
                        <a href="#features" class="btn btn-outline-primary btn-lg btn-cta-secondary">
                            <i class="fas fa-arrow-down me-2"></i> Descubre más
                        </a>
                    </div>
                </div>

                <div class="col-lg-5 d-none d-lg-block">
                    <img src="assets/img/hero-illustration.svg" alt="Plataforma de aprendizaje" class="img-fluid" loading="lazy">
                </div>
            </div>
        </div>
    </section>

    <!-- Sección de beneficios -->
    <section id="benefits" class="section-benefits">
        <div class="container">
            <div class="section-header text-center mb-5">
                <h2 class="section-title">
                    <i class="fas fa-lightbulb text-primary me-2"></i> ¿Por qué elegir OclarityBiz?
                </h2>
                <p class="section-subtitle mx-auto">
                    Integra onboarding, cultura y capacitación en un solo lugar. Personaliza módulos, mide el progreso y transforma la experiencia de aprendizaje corporativo.
                </p>
            </div>

            <div class="d-flex flex-wrap justify-content-center gap-3 mb-5">
                <span class="badge bg-primary-soft">
                    <i class="fas fa-check-circle text-primary me-1"></i> Fácil de usar
                </span>
                <span class="badge bg-primary-soft">
                    <i class="fas fa-check-circle text-primary me-1"></i> Personalizable
                </span>
                <span class="badge bg-primary-soft">
                    <i class="fas fa-check-circle text-primary me-1"></i> Escalable
                </span>
                <span class="badge bg-primary-soft">
                    <i class="fas fa-check-circle text-primary me-1"></i> Seguro
                </span>
            </div>

            <div class="divider divider-primary mx-auto"></div>
        </div>
    </section>

    <!-- Sección de características -->
    <section id="features" class="section-features">
        <div class="container">
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="feature-card card-hover">
                        <div class="feature-icon bg-primary-soft">
                            <i class="fas fa-user-plus text-primary"></i>
                        </div>
                        <h3 class="feature-title">Onboarding personalizado</h3>
                        <p class="feature-text">Automatiza el ingreso de nuevos empleados con módulos adaptados a tu empresa.</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="feature-card card-hover">
                        <div class="feature-icon bg-success-soft">
                            <i class="fas fa-people-group text-success"></i>
                        </div>
                        <h3 class="feature-title">Cultura corporativa</h3>
                        <p class="feature-text">Fomenta la identidad y valores de tu organización con recursos integrados.</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="feature-card card-hover">
                        <div class="feature-icon bg-warning-soft">
                            <i class="fas fa-graduation-cap text-warning"></i>
                        </div>
                        <h3 class="feature-title">Capacitación técnica</h3>
                        <p class="feature-text">Formación continua en Java EE, REST y frameworks modernos para tu equipo.</p>
                    </div>
                </div>
            </div>

            <div class="divider divider-primary mx-auto mt-5"></div>
        </div>
    </section>

    <!-- Sección de clientes -->
    <section class="section-clients">
        <div class="container">
            <div class="section-header text-center mb-5">
                <h2 class="section-title">
                    <i class="fas fa-building text-primary me-2"></i> Empresas que confían en nosotros
                </h2>
            </div>

            <div class="row g-4 justify-content-center">
                <div class="col-6 col-md-4 col-lg-2">
                    <div class="client-logo">
                        <img src="assets/img/logo_empresa1.png" alt="Empresa 1" class="img-fluid" loading="lazy">
                    </div>
                </div>
                <!-- Repetir para otros clientes -->
            </div>

            <div class="divider divider-primary mx-auto mt-5"></div>
        </div>
    </section>

    <!-- Sección de testimonios -->
    <section id="testimonials" class="section-testimonials">
        <div class="container">
            <div class="section-header text-center mb-5">
                <h2 class="section-title">
                    <i class="fas fa-star text-primary me-2"></i> Historias de éxito
                </h2>
            </div>

            <div class="row g-4">
                <div class="col-md-6">
                    <div class="testimonial-card card-hover">
                        <blockquote class="blockquote">
                            <p class="mb-4">“Gracias a OclarityBiz hemos unificado nuestra capacitación interna y onboarding en un solo lugar.”</p>
                            <footer class="blockquote-footer">Juan Pérez, <cite>Director de RRHH</cite></footer>
                        </blockquote>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="testimonial-card card-hover">
                        <blockquote class="blockquote">
                            <p class="mb-4">“La experiencia de usuario y la personalización nos ayudaron a mejorar la retención de talento.”</p>
                            <footer class="blockquote-footer">María Gómez, <cite>Líder de Talento</cite></footer>
                        </blockquote>
                    </div>
                </div>
            </div>

            <div class="divider divider-primary mx-auto mt-5"></div>
        </div>
    </section>

    <!-- Sección CTA -->
    <section id="demo" class="section-cta">
        <div class="container">
            <div class="cta-box text-center p-5 rounded-4">
                <h2 class="cta-title mb-4">
                    <i class="fas fa-rocket text-warning me-2"></i> ¿Listo para transformar tu empresa?
                </h2>
                <p class="cta-text mb-5 mx-auto">
                    Solicita una demo gratuita o contacta a nuestro equipo para descubrir cómo OclarityBiz puede adaptarse a tus necesidades.
                </p>

                <div class="d-flex flex-wrap justify-content-center gap-3">
                    <a href="mailto:info@oclaritybiz.com" class="btn btn-primary btn-lg btn-cta-primary">
                        <i class="fas fa-envelope me-2"></i> Solicitar demo
                    </a>
                    <a href="tel:+123456789" class="btn btn-outline-light btn-lg btn-cta-secondary">
                        <i class="fas fa-phone me-2"></i> Contactar
                    </a>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- Footer -->
<footer class="landing-footer">
    <div class="container py-5">
        <div class="row">
            <div class="col-lg-4 mb-4 mb-lg-0">
                <div class="footer-brand d-flex align-items-center mb-3">
                    <img src="assets/img/hlogol1.jpg" alt="OclarityBiz" height="40" width="40" loading="lazy" class="rounded me-2">
                    <span class="fw-bold fs-5">OclarityBiz</span>
                </div>
                <p class="text-muted">Plataforma de aprendizaje corporativo diseñada para transformar el talento en tu organización.</p>
            </div>

            <div class="col-lg-2 col-md-4 mb-4 mb-md-0">
                <h5 class="footer-title mb-3">Enlaces</h5>
                <ul class="footer-links list-unstyled">
                    <li class="mb-2"><a href="#features" class="footer-link">Características</a></li>
                    <li class="mb-2"><a href="#testimonials" class="footer-link">Testimonios</a></li>
                    <li class="mb-2"><a href="#" class="footer-link">Precios</a></li>
                    <li class="mb-2"><a href="#" class="footer-link">Blog</a></li>
                </ul>
            </div>

            <div class="col-lg-2 col-md-4 mb-4 mb-md-0">
                <h5 class="footer-title mb-3">Legal</h5>
                <ul class="footer-links list-unstyled">
                    <li class="mb-2"><a href="#" class="footer-link">Términos</a></li>
                    <li class="mb-2"><a href="#" class="footer-link">Privacidad</a></li>
                    <li class="mb-2"><a href="#" class="footer-link">Cookies</a></li>
                </ul>
            </div>

            <div class="col-lg-4 col-md-4">
                <h5 class="footer-title mb-3">Contacto</h5>
                <ul class="footer-contact list-unstyled">
                    <li class="mb-2">
                        <i class="fas fa-envelope me-2 text-primary"></i>
                        <a href="mailto:info@oclaritybiz.com" class="footer-link">info@oclaritybiz.com</a>
                    </li>
                    <li class="mb-2">
                        <i class="fas fa-phone me-2 text-primary"></i>
                        <a href="tel:+123456789" class="footer-link">+1 (234) 567-89</a>
                    </li>
                    <li class="mb-2">
                        <i class="fas fa-map-marker-alt me-2 text-primary"></i>
                        <span>Ciudad, País</span>
                    </li>
                </ul>

                <div class="social-links mt-4">
                    <a href="#" class="social-link" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social-link" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
                    <a href="#" class="social-link" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
                    <a href="#" class="social-link" aria-label="Instagram"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>

        <hr class="my-4">

        <div class="footer-bottom text-center">
            <p class="mb-0 text-muted">&copy; 2024 OclarityBiz. Todos los derechos reservados.</p>
        </div>
    </div>
</footer>

<!-- Bootstrap JS Bundle con Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<!-- Scripts personalizados -->
<script>
    // Smooth scroll para enlaces internos
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });

                // Actualizar URL sin recargar
                if (history.pushState) {
                    history.pushState(null, null, this.getAttribute('href'));
                } else {
                    window.location.hash = this.getAttribute('href');
                }
            }
        });
    });

    // Efecto de navbar al hacer scroll
    window.addEventListener('scroll', function() {
        const navbar = document.querySelector('.navbar-landing');
        if (window.scrollY > 50) {
            navbar.classList.add('navbar-scrolled');
        } else {
            navbar.classList.remove('navbar-scrolled');
        }
    });
</script>
</body>
</html>