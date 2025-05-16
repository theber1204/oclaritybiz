<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="fragments/header.jsp" %>

<div style="display: flex; min-height: 100vh;">
    <%@ include file="fragments/sidebar.jsp" %>
    <main style="flex-grow: 1; padding: 20px; background-color: #f9f9f9;">
        <jsp:include page="${modulePage}" />
    </main>
</div>

<%--<%@ include file="fragments/footer.jsp" %>--%>