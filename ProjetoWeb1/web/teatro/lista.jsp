<%-- 
    Document   : lista teatros
    Created on : 19/04/2019, 22:25:44
    Author     : João
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="l" %>

<l:listatag lista="${listaTeatros}" lista_vazia="${empty listaTeatros}">

    <jsp:attribute name="head_title_lista">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="lista_de_teatros"/> |
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="titulo_lista">
        <fmt:bundle basename="i18n.mensagem">
            <h1><fmt:message key="lista_de_teatros"/></h1>
            <c:if test="${empty listaTeatros}">
                <h2><fmt:message key="nao_ha_teatro"/></h2>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="cadastro"><fmt:message key="inserir"/></a>
                </sec:authorize>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <form action="filtrar_cidade" method="post">
                <label>Cidade:</label>
                <input type="text" name="cidade_desejado" size="45" />
                <input type="submit" value=<fmt:message key="pesquisar"/> />
            </form>
            <br>
            <table border="1" cellpadding="5">
                <tr>
                    <th><fmt:message key="email"/></th>
                    <th><fmt:message key="cnpj"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="cidade"/></th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th colspan="2" ><fmt:message key="opcoes"/></th>
                </sec:authorize>
            </tr>
            <c:forEach var="teatro" items="${listaTeatros}">
                <tr>
                    <td><c:out value="${teatro.email}" /></td>
                    <td><c:out value="${teatro.CNPJ}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="cadastro?id=<c:out value='${teatro.id}' />"><fmt:message key="edicao"/></a></td>
                    <td><a href="remocao?id=<c:out value='${teatro.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</fmt:bundle>
</jsp:body>
</l:listatag>
