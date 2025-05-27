<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="fragments/header.jsp" %>

<div class="d-flex flex-column flex-lg-row min-vh-100">
    <%@ include file="fragments/sidebar.jsp" %>
    <main class="flex-grow-1 p-3 bg-light">
        <jsp:include page="${modulePage}" />
    </main>
</div>

<%--<%@ include file="fragments/footer.jsp" %>--%>