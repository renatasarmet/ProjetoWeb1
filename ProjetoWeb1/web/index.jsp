<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%--<% request.setAttribute("user_email", request.getUserPrincipal().getName().toString()); %>--%>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="title"></jsp:attribute>
    <jsp:body>
        <%--<h2>Bemvindo ${user_email}</h2>--%>
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