<!-- src/main/webapp/WEB-INF/jsp/modules/editContactModal.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editContactModal" tabindex="-1" aria-labelledby="editContactModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form id="editContactForm" method="post" action="${pageContext.request.contextPath}/dashboard">
            <input type="hidden" name="action" value="editContact">">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editContactModalLabel">Editar Contacto</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id" id="contactId">
                    <div class="mb-3">
                        <label for="contactName" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="name" id="contactName" required>
                    </div>
                    <div class="mb-3">
                        <label for="contactSurnames" class="form-label">Apellidos</label>
                        <input type="text" class="form-control" name="surnames" id="contactSurnames">
                    </div>
                    <div class="mb-3">
                        <label for="contactEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" id="contactEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="contactPhone" class="form-label">Teléfono</label>
                        <input type="text" class="form-control" name="phone" id="contactPhone">
                    </div>
                    <div class="mb-3">
                        <label for="contactLinkedin" class="form-label">LinkedIn</label>
                        <input type="text" class="form-control" name="linkedin" id="contactLinkedin">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Guardar cambios</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var editModal = document.getElementById('editContactModal');
        editModal.addEventListener('show.bs.modal', function (event) {
            var button = event.relatedTarget;
            document.getElementById('contactId').value = button.getAttribute('data-id');
            document.getElementById('contactName').value = button.getAttribute('data-name');
            document.getElementById('contactSurnames').value = button.getAttribute('data-surnames');
            document.getElementById('contactEmail').value = button.getAttribute('data-email');
            document.getElementById('contactPhone').value = button.getAttribute('data-phone');
            document.getElementById('contactLinkedin').value = button.getAttribute('data-linkedin');
        });
    });
</script>