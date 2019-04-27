<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<sec:authorize access="hasAnyRole('ADMIN','SITE','TEATRO')">
    <% request.setAttribute("user_email", request.getUserPrincipal().getName().toString()); %>
</sec:authorize>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="title"></jsp:attribute>
    <jsp:body>
        <sec:authorize access="hasAnyRole('ADMIN','SITE','TEATRO')">
            <fmt:bundle basename="i18n.mensagem">
                <h2><fmt:message key="bem_vindo"/> ${user_email}</h2>
            </fmt:bundle>
        </sec:authorize>
        <sec:authorize access="!hasAnyRole('ADMIN','TEATRO','SITE')">
            <jsp:include page="/usuario/anonymous.jsp"></jsp:include>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <jsp:include page="/usuario/admin.jsp"></jsp:include>
        </sec:authorize>
            
        <sec:authorize access="hasRole('TEATRO')">
            <jsp:include page="/usuario/teatro.jsp"></jsp:include>
        </sec:authorize>
        
        <sec:authorize access="hasRole('SITE')">
            <jsp:include page="/usuario/site.jsp"></jsp:include>
        </sec:authorize>
    </jsp:body>
</t:genericpage>