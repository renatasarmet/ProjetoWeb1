<%-- 
    Document   : lista promoções
    Created on : 20/04/2019, 00:38:58
    Author     : Renata
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="l" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<l:listatag lista="${listaPromocao}" lista_vazia="${empty listaPromocao}" >
    <jsp:attribute name="head_title_lista">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="lista_de_promocoes"/> |
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="titulo_lista">
        <fmt:bundle basename="i18n.mensagem">
            <h1><fmt:message key="lista_de_promocoes"/></h1>
            <c:if test="${empty listaPromocao}">
                <h2><fmt:message key="nao_ha_promocao"/></h2>
                <sec:authorize access="hasAnyRole('ADMIN', 'TEATRO')">
                    <a href="cadastro"><fmt:message key="inserir"/></a>
                </sec:authorize>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <sec:authorize access="!hasRole('SITE')">
                <form action="filtrar_url" method="post">
                    <label><fmt:message key="filtre_url"/></label>
                    <input type="submit" value= <fmt:message key="pesquisar"/> />
                </form>
                <br>
                <form action="filtrar_teatro" method="post">
                    <label><fmt:message key="filtre_teatro"/></label>
                    <input type="text" name="teatro_desejado" size="45" />
                    <input type="submit" value=<fmt:message key="pesquisar"/> />
                </form>
            </sec:authorize>
            <table border="1" cellpadding="5">
                <sec:authorize access="!hasRole('SITE')">
                    <caption><h2><fmt:message key="lista_de_promocoes"/></h2></caption>
                </sec:authorize>
                <sec:authorize access="hasRole('SITE')">
                    <caption><h2><fmt:message key="minhas_promocoes"/></h2></caption>
                </sec:authorize>
                <tr>
                    <th><fmt:message key="id"/></th>
                    <th><fmt:message key="url"/></th>
                    <th><fmt:message key="teatro"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="preco"/></th>
                    <th><fmt:message key="data_sessao"/></th>
                    <th><fmt:message key="horario_sessao"/></th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th colspan="2" ><fmt:message key="opcoes"/></th>
                </sec:authorize>
            </tr>
            <c:forEach var="promo" items="${listaPromocao}">
                <tr>
                    <td><c:out value="${promo.id}" /></td>
                    <td><c:out value="${promo.url}" /></td>
                    <td><c:out value="${promo.getNomeTeatroPorCnpj(promo.cnpj)}" /></td>
                    <td><c:out value="${promo.nome}" /></td>
                    <td><c:out value="${promo.preco}" /></td>
                    <td><c:out value="${promo.data_sessao}" /></td>
                    <td><c:out value="${promo.horario_sessao}" /></td>
                <sec:authorize access="hasAnyRole('ADMIN','TEATRO')">
                    <td><a href="edicao?id=<c:out value='${promo.id}' />"><fmt:message key="edicao"/></a></td>
                    <td><a href="remocao?id=<c:out value='${promo.id}' />"onclick="return confirm('<fmt:message key="deseja_excluir"/>');"><fmt:message key="remocao"/></a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</fmt:bundle>
</jsp:body>
</l:listatag>
