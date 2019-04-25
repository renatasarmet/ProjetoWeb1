<%-- 
    Document   : lista teatros
    Created on : 19/04/2019, 22:25:44
    Author     : João
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:listatag lista="${listaTeatros}" lista_vazia="${empty listaTeatros}">
    
    <jsp:attribute name="head_title_lista">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="lista_de_teatros"/> | <fmt:message key="site_de_promocoes"/>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="titulo_lista">
        <fmt:bundle basename="i18n.mensagem">
            <h1><fmt:message key="lista_de_teatros"/></h1>
        <c:if test="${empty listaTeatros}">
            <h2><fmt:message key="nao_ha_teatro"/></h2>
            <a href="cadastro"><fmt:message key="inserir"/></a>
        </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <table border="1" cellpadding="5">
                <caption><h2><fmt:message key="lista_de_teatros"/></h2></caption>
                <tr>
                    <th><fmt:message key="email"/></th>
                    <th><fmt:message key="senha"/></th>
                    <th><fmt:message key="cnpj"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="cidade"/></th>
                    <th colspan="2" ><fmt:message key="opcoes"/></th>
                </tr>
                <c:forEach var="teatro" items="${listaTeatros}">
                    <tr>
                        <td><c:out value="${teatro.email}" /></td>
                        <td><c:out value="${teatro.senha}" /></td>
                        <td><c:out value="${teatro.CNPJ}" /></td>
                        <td><c:out value="${teatro.nome}" /></td>
                        <td><c:out value="${teatro.cidade}" /></td>
                        <td><a href="cadastro?id=<c:out value='${teatro.id}' />"><fmt:message key="edicao"/></a></td>
                        <td><a href="remocao?id=<c:out value='${teatro.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                    </tr>
                </c:forEach>
                <a href="cadastro"><fmt:message key="cadastrar_novo_teatro"/></a>
            </c:if>
        </table>
        </fmt:bundle>
    </jsp:body>
</l:listatag>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <fmt:bundle basename="i18n.mensagem">
        <title><fmt:message key="site_de_promocoes"/></title>
        </fmt:bundle>
    </head>
    <body>
        <fmt:bundle basename="i18n.mensagem">
    <center>
        <h1><fmt:message key="lista_de_teatros"/></h1>
        <c:if test="${empty listaTeatros}">
            <h2><fmt:message key="nao_ha_teatro"/></h2>
            <a href="cadastro"><fmt:message key="inserir"/></a>
        </c:if>
        <c:if test="${!empty listaTeatros}">
            <table border="1" cellpadding="5">
                <caption><h2><fmt:message key="lista_de_teatros"/></h2></caption>
                <tr>
                    <th><fmt:message key="email"/></th>
                    <th><fmt:message key="senha"/></th>
                    <th><fmt:message key="cnpj"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="cidade"/></th>
                    <th colspan="2" ><fmt:message key="opcoes"/></th>
                </tr>
                <c:forEach var="teatro" items="${listaTeatros}">
                    <tr>
                        <td><c:out value="${teatro.email}" /></td>
                        <td><c:out value="${teatro.senha}" /></td>
                        <td><c:out value="${teatro.CNPJ}" /></td>
                        <td><c:out value="${teatro.nome}" /></td>
                        <td><c:out value="${teatro.cidade}" /></td>
                        <td><a href="cadastro?id=<c:out value='${teatro.id}' />"><fmt:message key="edicao"/></a></td>
                        <td><a href="remocao?id=<c:out value='${teatro.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                    </tr>
                </c:forEach>
                <a href="cadastro"><fmt:message key="cadastrar_novo_teatro"/></a>
            </c:if>
        </table>
    </center>
    </fmt:bundle>
</body>
</html>
