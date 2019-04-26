<%-- 
    Document   : lista sites de venda de ingresso
    Created on : Apr 15, 2019, 10:24:03 AM
    Author     : root
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:listatag lista="${listaSites}" lista_vazia="${empty listaSites}" >
    <jsp:attribute name="head_title_lista">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="lista_site_venda_ingresso"/> | <fmt:message key="site_de_promocoes"/>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="titulo_lista">
        <fmt:bundle basename="i18n.mensagem">
            <h1><fmt:message key="lista_site_venda_ingresso"/></h1>
            <c:if test="${empty listaSites}">
                <h2><fmt:message key="nao_ha_site"/></h2>
                <a href="cadastro"><fmt:message key="inserir"/></a>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <table border="1" cellpadding="5">
                <tr>
                    <th><fmt:message key="id"/></th>
                    <th><fmt:message key="email"/></th>
                    <th><fmt:message key="url"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="telefone"/></th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th colspan="2" ><fmt:message key="opcoes"/></th>
                </sec:authorize>
            </tr>
            <c:forEach var="site" items="${listaSites}">
                <tr>
                    <td><c:out value="${site.id}" /></td>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.url}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="edicao?id=<c:out value='${site.id}' />"><fmt:message key="edicao"/></a></td>
                    <td><a href="remocao?id=<c:out value='${site.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</fmt:bundle>
</jsp:body>
</l:listatag>
