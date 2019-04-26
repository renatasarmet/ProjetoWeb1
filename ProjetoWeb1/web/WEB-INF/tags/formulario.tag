<%-- 
    Document   : formulario
    Created on : 25/04/2019, 13:58:44
    Author     : João
--%>

<%@tag description="Formulário genérico" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="model" required="true"%>
<%@attribute name="model_id" required="true"%>
<%@attribute name="model_null" required="true"%>
<%@attribute name="head_include_form" fragment="true"%>
<%@attribute name="head_title_form" fragment="true"%>
<%@attribute name="titulo_form" fragment="true"%>

<%-- any content can be specified here e.g.: --%>
<t:genericpage>
    <jsp:attribute name="title">
        <jsp:invoke fragment="head_title_form"/>
    </jsp:attribute>
    <jsp:attribute name="head_include">
        <script
            src="https://code.jquery.com/jquery-3.4.0.min.js"
            integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="../js/validacao.js"></script>
        <jsp:invoke fragment="head_include_form"/>
        <link rel="stylesheet" href="../css/main.css" type="text/css"/>
    </jsp:attribute>
    <jsp:body>
        <center>
            <h2>
                <jsp:invoke fragment="titulo_form"/>
            </h2>
            <c:if test="${!model_null}">
                <form class="criacao" action="atualizacao">
                    <input type="hidden" name="id" value="<c:out value='${model_id}' />" />
                </c:if>
                <c:if test="${model_null}">
                    <form class="edicao" action="insercao" onsubmit="return validaForm()">
                    </c:if>
                    <jsp:doBody/>
                </form>
        </center>
    </jsp:body>
</t:genericpage>