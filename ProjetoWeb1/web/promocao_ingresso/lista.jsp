<%-- 
    Document   : lista
    Created on : 20/04/2019, 00:38:58
    Author     : Renata
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
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
            <h1><fmt:message key="lista_de_promocoes"/></h1>
            <c:if test="${empty listaPromocao}">
                <h2><fmt:message key="nao_ha_promocao"/></h2>
                <a href="cadastro"><fmt:message key="inserir"/></a>
            </c:if>
            <c:if test="${!empty listaPromocao}">
                <form action="filtrar_url" method="post">
                    <label><fmt:message key="filtre_url"/></label>
                    <input type="submit" value= <fmt:message key="pesquisar"/> />
                </form>
                <br>
                <form action="filtrar_cnpj" method="post">
                    <label><fmt:message key="filtre_cnpj"/></label>
                    <input type="text" name="cnpj_desejado" size="45" />
                    <input type="submit" value=<fmt:message key="pesquisar"/> />
                </form>
                <table border="1" cellpadding="5">
                    <caption><h2><fmt:message key="lista_de_promocoes"/></h2></caption>
                    <tr>
                        <th><fmt:message key="id"/></th>
                        <th><fmt:message key="url"/></th>
                        <th><fmt:message key="cnpj"/></th>
                        <th><fmt:message key="nome"/></th>
                        <th><fmt:message key="preco"/></th>
                        <th><fmt:message key="data_sessao"/></th>
                        <th><fmt:message key="horario_sessao"/></th>
                        <th colspan="2" ><fmt:message key="opcoes"/></th>
                    </tr>
                    <c:forEach var="promo" items="${listaPromocao}">
                        <tr>
                            <td><c:out value="${promo.id}" /></td>
                            <td><c:out value="${promo.url}" /></td>
                            <td><c:out value="${promo.cnpj}" /></td>
                            <td><c:out value="${promo.nome}" /></td>
                            <td><c:out value="${promo.preco}" /></td>
                            <td><c:out value="${promo.data_sessao}" /></td>
                            <td><c:out value="${promo.horario_sessao}" /></td>
                            <td><a href="edicao?id=<c:out value='${promo.id}' />"><fmt:message key="edicao"/></a></td>
                            <td><a href="remocao?id=<c:out value='${promo.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </center>
    </fmt:bundle>
</body>
</html>
