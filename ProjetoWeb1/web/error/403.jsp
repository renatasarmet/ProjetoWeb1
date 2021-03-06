<%-- 
    Document   : 403
    Created on : Apr 25, 2019, 7:25:45 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="../css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="title">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="erro_403_titulo"/>
        </fmt:bundle>
    </jsp:attribute>
    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <center>
                <h1><fmt:message key="erro_403_h1"/></h1>
                <h2><fmt:message key="erro_403_mensagem"/></h2>
            </center>
        </fmt:bundle>
    </jsp:body>
</t:genericpage>
