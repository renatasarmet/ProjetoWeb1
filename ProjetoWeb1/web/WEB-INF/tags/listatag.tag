<%-- 
    Document   : listatag
    Created on : 25/04/2019, 13:57:40
    Author     : João
--%>

<%@tag description="Lista genérica" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="lista" required="true"%>
<%@attribute name="lista_vazia" required="true"%>
<%@attribute name="head_title_lista" fragment="true"%>
<%@attribute name="titulo_lista" fragment="true"%>

<%-- any content can be specified here e.g.: --%>
<t:genericpage>
    <jsp:attribute name="head_include">
        <link rel="stylesheet" href="../css/main.css"/>
    </jsp:attribute>
    <jsp:attribute name="title">
        <jsp:invoke fragment="head_title_lista"/>
    </jsp:attribute>
    <jsp:body>
        <center>
            <jsp:invoke fragment="titulo_lista" />
            <c:if test="${!lista_vazia}">
                <jsp:doBody/>
            </c:if>
        </center>
    </jsp:body>
</t:genericpage>