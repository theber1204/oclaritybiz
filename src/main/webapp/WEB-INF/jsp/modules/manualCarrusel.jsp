<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<c:if test="${not empty manualSeleccionado}">
    <div class="modal-header">
        <h2 class="modal-title" id="manualModalLabel">
            <c:out value="${manualSeleccionado.title}"/>
        </h2>
        <button type="button" class="btn-close"
                data-bs-dismiss="modal" aria-label="Cerrar"
                onclick="window.location.href='${pageContext.request.contextPath}/dashboard?module=manuales'"></button>
    </div>
    <div class="modal-body">
        <p class="text-muted"><c:out value="${manualSeleccionado.description}"/></p>
        <div id="manualCarousel" class="carousel slide mb-4 position-relative" data-bs-ride="carousel">
            <div class="carousel-inner">
                <c:forEach var="pagina" items="${manualSeleccionado.pages}" varStatus="status">
                    <div class="carousel-item ${status.first ? 'active' : ''}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${pagina.observations}</h5>
                                <img src="${pagina.imageUrl}" alt="Imagen de la página" class="img-fluid mb-2"/>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev position-absolute top-50 start-0 translate-middle-y ms-n5 bg-primary bg-opacity-75 text-white rounded-circle border-0 shadow-lg d-flex align-items-center justify-content-center" style="width:48px; height:48px;" type="button" data-bs-target="#manualCarousel" data-bs-slide="prev">
                <i class="fas fa-chevron-left fa-lg"></i>
            </button>
            <button class="carousel-control-next position-absolute top-50 end-0 translate-middle-y me-n5 bg-primary bg-opacity-75 text-white rounded-circle border-0 shadow-lg d-flex align-items-center justify-content-center" style="width:48px; height:48px;" type="button" data-bs-target="#manualCarousel" data-bs-slide="next">
                <i class="fas fa-chevron-right fa-lg"></i>
            </button>
        </div>
    </div>
</c:if>