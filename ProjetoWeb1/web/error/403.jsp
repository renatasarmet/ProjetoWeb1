<%-- 
    Document   : 403
    Created on : Apr 25, 2019, 7:25:45 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="title">Forbidden</jsp:attribute>
    <jsp:body>
        <center>
            <h1>Erro 403</h1>
            <h2>Você não tem permissão para acessar essa página!</h2>
        </center>
    </jsp:body>
</t:genericpage>
