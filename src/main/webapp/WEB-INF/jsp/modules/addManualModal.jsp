<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="addManualModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Crear Nuevo Manual</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">
        <form id="addManualForm" action="${pageContext.request.contextPath}/dashboard" method="post">
          <input type="hidden" name="action" value="addManual"/>
          <div class="mb-3">
            <label for="manualTitle" class="form-label">Título</label>
            <input type="text" id="manualTitle" name="title" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="manualDescription" class="form-label">Descripción</label>
            <textarea id="manualDescription" name="description" class="form-control" rows="3" required></textarea>
          </div>
          <div id="manualPagesContainer">
            <div class="mb-3 page-item">
              <label for="manualPage1" class="form-label">Página</label>
              <textarea id="manualPage1" name="pages[0][observations]" class="form-control" rows="3" required></textarea>
              <input id="manualImage1" name="pages[0][image_url]" type="text" class="form-control mt-2" placeholder="URL de la imagen" required/>
            </div>
          </div>
          <button type="button" id="addPageButton" class="btn btn-secondary btn-sm">Agregar Página</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" form="addManualForm" class="btn btn-primary">Guardar Manual</button>
      </div>
    </div>
  </div>
</div>

<script>
  document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('manualPagesContainer');
    const addBtn = document.getElementById('addPageButton');
    let pageCounter = 1; // Contador global inicializado en 1

    addBtn.addEventListener('click', () => {
      // Incrementar el contador global
      pageCounter++;

      // Crear un nuevo divisor
      const divider = document.createElement('hr');
      divider.className = 'my-4';

      // Crear un nuevo elemento de página
      const newPage = document.createElement('div');
      newPage.className = 'mb-3 page-item';
      newPage.innerHTML = `
        <label for="manualPage${pageCounter}" class="form-label">Página ${pageCounter}</label>
        <textarea id="manualPage${pageCounter}" name="pages[${pageCounter - 1}][observations]" class="form-control" rows="3" required></textarea>
        <input id="manualImage${pageCounter}" name="pages[${pageCounter - 1}][image_url]" type="text" class="form-control mt-2" placeholder="URL de la imagen" required/>
      `;

      // Agregar el divisor y la nueva página al contenedor
      container.appendChild(divider);
      container.appendChild(newPage);
    });
  });
</script>