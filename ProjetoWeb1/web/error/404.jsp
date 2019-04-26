<%-- 
    Document   : 404
    Created on : 26/04/2019, 16:27:01
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="/ProjetoWeb1/css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="title">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="erro_404_titulo"/>
        </fmt:bundle>
    </jsp:attribute>
    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <center>
                <h1><fmt:message key="erro_404_h1"/></h1>
                <h2><fmt:message key="erro_404_mensagem"/></h2>
            </center>
        </fmt:bundle>
    </jsp:body>
</t:genericpage>
